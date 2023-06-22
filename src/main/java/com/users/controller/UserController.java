package com.users.controller;

import com.users.dao.UserDao;
import com.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {
  private final UserDao userDao;

  @Autowired
  public UserController(UserDao userDao) {
    this.userDao = userDao;
  }

  @GetMapping("/list")
  public String listUsers(Model model) {
    List<User> users = userDao.listUsers();
    model.addAttribute("users", users);
    return "user-list";
  }

  @GetMapping("/search-form")
  public String searchForm(Model model) {
    return "user-search";
  }

  @GetMapping("/edit/{id}")
  public String editUser(@PathVariable int id, Model model) {
    User user = userDao.findById(id);
    model.addAttribute("user", user);
    return "user-edit";
  }

  @PostMapping("/search")
  public String searchUser(@RequestParam Map<String, String> entries, Model model) {
    System.out.println(entries);
    User user = userDao.findById(Integer.parseInt(entries.getOrDefault("id", "0").toString()));
    if (user == null) {
      model.addAttribute("message", "User not found with id: " + entries.get("id"));
      return "error";
    }
    model.addAttribute("user", user);
    return "user-edit";
  }

  @PostMapping("/save")
  public ModelAndView saveUser(@ModelAttribute("user") User user) {
    userDao.update(user);
    return new ModelAndView("redirect:/users/list");
  }
}
