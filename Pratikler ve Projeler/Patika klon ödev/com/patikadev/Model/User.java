package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.Helper.Helper;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User
{
    private static int counter=0;
    private int id;
    private String name;
    private String userName;
    private String password;
    private String userType;

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public static ArrayList<User> getList()
    {
        String query="SELECT * FROM user";
        ArrayList<User> userList=new ArrayList<>();
        User u;
        try {
            Statement st= DBConnector.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next())
            {
                u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setUserType(rs.getString("userType"));
                userList.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static boolean add(String name,String userName,String userType,String password)
    {
            counter+=1;
            String query="INSERT INTO user(id,name,userName,userType,password) VALUES (?,?,?,?,?) ";
            User findUser=User.getFetchByUName(userName);
            if(findUser!=null)
            {
                Helper.showMessage("isHave");
                return false;
            }
            try {
                PreparedStatement pr=DBConnector.getInstance().prepareStatement(query);
                pr.setInt(1,(User.getList().toArray().length+1));
                pr.setString(2,name);
                pr.setString(3,userName);
                pr.setString(4,userType);
                pr.setString(5,password);
                int response=pr.executeUpdate();
                if(response==-1)
                {
                    Helper.showMessage("error");
                }
                return response !=-1;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }
    public static User getFetchByUName(String userName)
    {
       User u = null;
       String query="SELECT * FROM user WHERE userName=?";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setString(1,userName);
            ResultSet rs=st.executeQuery();
            if (rs.next())
            {   u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setUserType(rs.getString("userType"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;
    }
    public static boolean delete(int id)
    {
        String query="DELETE FROM user WHERE id=?";
        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setInt(1,id);
            return st.executeUpdate()!=-1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static boolean update(int id,String userName,String uUserName,String userType,String password)
    {
        String query="UPDATE user SET name=?,username=?,password=?,userType=? WHERE id=?";
        User findUser=User.getFetchByUName(uUserName);
        if(findUser!=null && findUser.getId() !=id)
        {
            Helper.showMessage("isHave");
            return false;
        }
        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setString(1,userName);
            st.setString(2,uUserName);
            st.setString(3,password);
            st.setString(4,userType);
            st.setInt(5,id);
            return st.executeUpdate()!=-1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static ArrayList<User> searchUserList(String query)
    {
        ArrayList<User> userList=new ArrayList<>();
        User u;
        try {
            Statement st= DBConnector.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next())
            {
                u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setUserType(rs.getString("userType"));
                userList.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
    public static String query(String username,String name,String userType)
    {
        String query="SELECT * FROM user WHERE username LIKE '%{{username}}%'  AND name LIKE '%{{name}}%' ";
        query=query.replace("{{username}}",username);
        query=query.replace("{{name}}",name);
        if(!userType.isEmpty())
        {
            query+="AND userType LIKE '{{userType}}'";
            query= query.replace("{{userType}}",userType);
        }


        return query;

    }
    public static User getFetchByUName(int id)
    {
        User u = null;
        String query="SELECT * FROM user WHERE id=?";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs=st.executeQuery();
            if (rs.next())
            {   u=new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setUserName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setUserType(rs.getString("userType"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;
    }
    public static User getFetchByUName(String name,String pass)
    {
        User obj = null;
        String query="SELECT * FROM user WHERE username=? AND password=?";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setString(1,name);
            st.setString(2,pass);
            ResultSet rs=st.executeQuery();
            if (rs.next())
            {
                switch (rs.getString("userType"))
                {
                    case "operator":
                        obj=new Operator();
                        break;
                    default:
                        obj=new User();
                }
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                obj.setUserName(rs.getString("username"));
                obj.setPassword(rs.getString("password"));
                obj.setUserType(rs.getString("userType"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return obj;
    }


}
