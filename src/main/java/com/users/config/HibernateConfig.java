package com.users.config;

import com.users.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.PersistentClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@EnableTransactionManagement
public class HibernateConfig {


  @Bean
  public SessionFactory getSessionFactory() {
//    org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml");
//    SessionFactory sessionFactory = configuration.buildSessionFactory();
//

//    System.out.println("Hibernate Properties:");
//    configuration.getProperties().forEach((key, value) -> {
//      System.out.println(key + ": " + value);
//    });

    StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        .configure("hibernate.cfg.xml") // Load Hibernate configuration from hibernate.cfg.xml
        .build();
    MetadataSources metadataSources = new MetadataSources(serviceRegistry);
    Metadata metadata = metadataSources.buildMetadata();

    metadataSources.addAnnotatedClass(User.class);

    // Build the Metadata and SessionFactory
    SessionFactory sessionFactory = metadata.buildSessionFactory();

    // Print all mapping class names
    System.out.println("Mapped Entity Classes:");
    for (PersistentClass persistentClass : metadata.getEntityBindings()) {
      System.out.println(persistentClass.getClassName());
    }


    return sessionFactory;
  }   // @Bean

  public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource);
//        sessionFactoryBean.setPackagesToScan();
    sessionFactoryBean.setPackagesToScan(User.class.getPackage().getName());
    sessionFactoryBean.setHibernateProperties(hibernateProperties());
    return sessionFactoryBean;
  }

  //    @Bean
  public HibernateTransactionManager transactionManager(LocalSessionFactoryBean sessionFactoryBean) {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactoryBean.getObject());
    return transactionManager;
  }

  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    properties.setProperty("hibernate.hbm2ddl.auto", "update");
//        properties.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
//        properties.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/user_app");
//        properties.setProperty("hibernate.connection.username","root");
//        properties.setProperty("hibernate.connection.password","");
    return properties;
  }
}
