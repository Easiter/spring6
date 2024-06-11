package com.powernode.spring6.test;

import com.powernode.spring6.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName SpringJdbcTest
 * @Description TODO
 * @Author lizueyu
 * @Date 2022/11/3 9:14
 * @Version 1.0
 **/
public class SpringJdbcTest {

    @Test
    public void testCallBack(){
        // �������дjdbc���룬����ʹ��callback�ص�����
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // ׼��sql���
        String sql = "select id,real_name,age from t_user where id = ?";
        // ע��ص���������execute����ִ�е�ʱ�򣬻ص������е�doInPreparedStatement�����ᱻ����
        User user = jdbcTemplate.execute(sql, new PreparedStatementCallback<User>() {
            @Override
            public User doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                User user = new User();
                ps.setInt(1, 2);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String real_name = rs.getString("real_name");
                    int age = rs.getInt("age");
                    user = new User(id, real_name, age);
                }
                return user;
            }
        });
        System.out.println(user);
    }

    @Test
    public void testAddBatch(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // �������
        String sql = "insert into t_user(id ,real_name,age) values(?,?,?)";
        Object[] objs1 = {null, "С��", 20};
        Object[] objs2 = {null, "С��", 21};
        Object[] objs3 = {null, "С��", 22};
        List<Object[]> list = new ArrayList<>();
        list.add(objs1);
        list.add(objs2);
        list.add(objs3);

        int[] count = jdbcTemplate.batchUpdate(sql, list);
        System.out.println(Arrays.toString(count));
    }

    @Test
    public void testQueryOneValue() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select count(1) from t_user";
        Integer total = jdbcTemplate.queryForObject(sql, int.class);
        System.out.println(total);
    }

    @Test
    public void testQueryAll() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name , age from t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(userList);
    }

    @Test
    public void testQuery() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "select id, real_name , age from t_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        System.out.println(user);
    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "delete from t_user where id = ?";
        int count = jdbcTemplate.update(sql, 1);
        System.out.println(count);
    }


    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        String sql = "update t_user set real_name = ? ,age = ? where id = ?";
        int count = jdbcTemplate.update(sql, "������", 55, 1);
        System.out.println(count);
    }

    @Test
    public void testInsert() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        // insert���
        String sql = "insert into t_user(real_name,age) values (?,?)";
        // ע�⣺��jdbcTemplate�У�ֻҪ��insert��delete��update���ģ����ǵ���update����
        int count = jdbcTemplate.update(sql, "����", 20);
        System.out.println(count);
    }


    @Test
    public void testJdbc() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }
}
