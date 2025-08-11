package com.example.assignment_gd2.util;

import com.example.assignment_gd2.model.Book;
import com.example.assignment_gd2.model.BorrowRequest;
import com.example.assignment_gd2.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateUtil {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Đổi DB name cho khớp với script bạn tạo: LibrarySystem
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=LibrarySystem;encrypt=true;trustServerCertificate=true");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "12345");
        properties.put(Environment.SHOW_SQL, "true");
        // properties.put(Environment.HBM2DDL_AUTO, "update"); // mở khi dev

        conf.setProperties(properties);

        // Đăng ký entity
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(Book.class);
        conf.addAnnotatedClass(BorrowRequest.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();

        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() { return FACTORY; }
    public static synchronized Session getSession() { return FACTORY.openSession(); }

    public static void main(String[] args) {
        getFactory();
        System.out.println("Hibernate run successfully!");
    }
}