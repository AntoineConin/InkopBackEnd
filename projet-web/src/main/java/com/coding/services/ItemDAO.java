package com.coding.services;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coding.models.Item;

public class ItemDAO {

    public static final String JDBC_URL = "jdbc:postgresql://manny.db.elephantsql.com:5432/qaltgcbu";
    public static final String JDBC_LOGIN = "qaltgcbu";
    public static final String JDBC_PWD = "rlbsmVdV3FGTcpYICry1ulUsMnVQU0Lg";

    public List<Item> getItems() throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "SELECT * FROM items;";
            try (Statement st = co.createStatement()) {
                try (ResultSet rs = st.executeQuery(sql)) {
                    List<Item> list = new ArrayList<>();
                    while (rs.next()) {
                        Item i = new Item();

                        i.setItemId(rs.getInt("itemId"));
                        i.setId(rs.getInt("id"));
                        i.setName(rs.getString("name"));
                        i.setDescription(rs.getString("description"));
                        i.setQuantity(rs.getInt("quantity"));
                        list.add(i);
                    }
                    return list;
                }
            }
        }
    }

    public Item getItemById(int id) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "SELECT * FROM items where itemId=?;";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setInt(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        Item i = new Item();
                        i.setId(rs.getInt("itemId"));
                        i.setName(rs.getString("name"));
                        i.setDescription(rs.getString("description"));
                        return i;
                    }
                    return null;
                }
            }
        }
    }

    public void add(Item item) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "INSERT INTO items (id, name, description, quantity) VALUES(?, ?, ?, ?);";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setInt(1, item.getId());
                st.setString(2, item.getName());
                st.setString(3, item.getDescription());
                st.setInt(4, item.getQuantity());
                st.execute();
            }
        }
    }

    public void update(int id, Item item) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "UPDATE items SET name=? , description=? , quantity=? WHERE itemId=?;";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setString(1, item.getName());
                st.setString(2, item.getDescription());
                st.setInt(3, item.getQuantity());
                st.setInt(4, id);
                st.execute();
            }
        }
    }

    public void delete(int id) throws SQLException {
        try (Connection co = DriverManager.getConnection(JDBC_URL, JDBC_LOGIN, JDBC_PWD)) {
            String sql = "DELETE FROM items WHERE itemId=?;";
            try (PreparedStatement st = co.prepareStatement(sql)) {
                st.setInt(1, id);
                st.execute();
            }
        }
    }
}