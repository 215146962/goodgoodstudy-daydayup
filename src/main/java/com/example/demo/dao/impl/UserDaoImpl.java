package com.example.demo.dao.impl;

import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer addUser(User user) {
        String sql = "insert into tip_user_info(username,age,name)values(?,?,?)";
        return jdbcTemplate.update(sql,user.getUsername(),user.getAge(),user.getName());
    }

    @Override
    public Integer addErrorUser(User user) {
        String sql = "insert into tip_user_info(username1,age1,name1)values(?,?,?)";
        return jdbcTemplate.update(sql,user.getUsername(),user.getAge(),user.getName());
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from tip_user_info";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {

            /**
             * 我们自己手动将查询出来的结果集和java对象中的属性做映射
             * @param rs
             * @param rowNum
             * @return
             * @throws SQLException
             */
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });

        return userList;
    }
}
