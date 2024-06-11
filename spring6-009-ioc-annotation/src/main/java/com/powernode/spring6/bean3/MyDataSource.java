package com.powernode.spring6.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @ClassName MyDataSource
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/2 16:59
 * @Version 1.0
 **/
@Component
public class MyDataSource implements DataSource {

    // 1、使用@Value注解注入的时候没有setter方法
    @Value(value = "com.mysql.cj.jdbc.Driver")
    private String driver;
    @Value("jdbc:mysql://localhost:3306/spring6")
    private String url;
    @Value("root")
    private String username;
    @Value("root")
    private String password;

    // 3、@Value注解还能用在构造方法参数上
    public MyDataSource(@Value("jdbc:mysql://localhost:3306/spring6") String url) {
        this.url = url;
    }

    // 2、@Value注解也能使用在方法上
    @Value("com.mysql.cj.jdbc.Driver")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Value("jdbc:mysql://localhost:3306/spring6")
    public void setUrl(String url) {
        this.url = url;
    }

    @Value("root")
    public void setUsername(String username) {
        this.username = username;
    }

    @Value("root")
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }

    @Override
    public Connection getConnection(String s, String s1) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter printWriter) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int i) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> aClass) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> aClass) throws SQLException {
        return false;
    }

    @Override
    public String toString() {
        return "MyDataSource{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
