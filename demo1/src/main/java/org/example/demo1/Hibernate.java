package org.example.demo1;

import org.example.demo1.entity.LoaiSanPham;
import org.example.demo1.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class Hibernate {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // ✅ Thay thế DBMetadata.getConnectString() bằng chuỗi kết nối trực tiếp
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=PTPM_FINALLY_SOF3012;encrypt=true;trustServerCertificate=true");

        properties.put(Environment.USER, "sa"); // thay bằng user SQL của bạn
        properties.put(Environment.PASS, "12345"); // thay bằng password của bạn
        properties.put(Environment.SHOW_SQL, "true");
        // properties.put(Environment.HBM2DDL_AUTO, "update"); // mở nếu muốn tạo bảng tự động

        conf.setProperties(properties);

        // ✅ Thêm class entity nếu có, ví dụ:
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(LoaiSanPham.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();

        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }

    public static synchronized Session getSession() {
        return FACTORY.openSession();
    }

    public static void main(String[] args) {
        getFactory();
        System.out.println("Hibernate run successfully!");
    }
}
