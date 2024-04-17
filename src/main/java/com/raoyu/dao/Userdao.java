package com.raoyu.dao;

import com.raoyu.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
//user表中增删查改操作
public class Userdao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //插入操作
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //删除，where id=?
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //更新，where id=?
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //查询，where id=?
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //查询，where username=? and password=?
        String sql1 = "select*from usertable where username=? and password=?";
        PreparedStatement pstmt = con.prepareStatement(sql1);
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        User user = null;
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            user = new User();//构造对象调用set方法设置user表中参数
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        //查询，where username=?
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //查询，where  password=?
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        //查询，where email=?
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        //查询，where gender=?
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        //查询，where birthdate=?
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        //查询，所有信息
        return null;
    }
}
