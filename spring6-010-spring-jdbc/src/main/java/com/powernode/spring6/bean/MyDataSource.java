package com.powernode.spring6.bean;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

/**
 * @ClassName MyDataSource
 * @Description
 * @Author lizueyu
 * @Date 2022/11/3 8:51
 * @Version 1.0
 **/

/*
    �Լ�������Դ������Դ���ڵ�Ŀ����Ϊ���ṩConnection����
    ֻҪʵ����DataSource�ӿڵĶ�������Դ
    ��³�����ӳأ�C3p0���ӳأ�dbcp���ӳأ���ʵ����DataSource�ӿ�
 */
public class MyDataSource implements DataSource {

    private String driver;
    private String url;
    private String username;
    private String password;

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        try {
            // ע������
            Class.forName(driver);
            // ��ȡ���ݿ����Ӷ���
            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}
