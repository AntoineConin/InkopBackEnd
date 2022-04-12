package com.coding.services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coding.models.User;

public class UserDAO {

    public static final String JDBC_URL = "jdbc:postgresql://manny.db.elephantsql.com:5432/qaltgcbu";
    public static final String JDBC_LOGIN = "qaltgcbu";
    public static final String JDBC_PWD = "rlbsmVdV3FGTcpYICry1ulUsMnVQU0Lg";

    public List<User> getUsers() throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "SELECT * FROM users;";
            try (Statement st = co.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    List<User> list = new ArrayList<>();
                    while (rs.next()) {
                        User u = new User();
                        u.setId(rs.getInt("id"));
                        u.setName(rs.getString("username"));
                        u.setPassword(rs.getString("pwd"));
                        list.add(u);
                    }
                    return list;
                }
            }
        }
    }

    public User getUserById(int id) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "SELECT * FROM users where id=?;";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setInt(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        User u = new User();
                        u.setId(rs.getInt("id"));
                        u.setName(rs.getString("username"));
                        u.setPassword(rs.getString("pwd"));
                        return u;
                    }
                    return null;
                }
            }
        }
    }

    public void add(User user) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "INSERT INTO users (username, pwd) VALUES(?, ?);";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setString(1, user.getName());
                st.setString(2, user.getPassword());
                st.execute();
            }
        }
    }

    public void update(int id, User user) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "UPDATE users SET username=? , pwd=? WHERE id=?;";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setString(1, user.getName());
                st.setString(2, user.getPassword());
                st.setInt(3, id);
                st.execute();
            }
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "DELETE FROM users WHERE id=?;";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setInt(1, id);
                st.execute();
            }
        }
    }
}
