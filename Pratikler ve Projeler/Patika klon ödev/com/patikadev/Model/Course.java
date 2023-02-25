package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course
{
    private int id;
    private int userId;
    private int patikaId;
    private String name;
    private String language;
    private Patika patika;
    private User educator;

    public Course(int id, int userId, int patikaId, String name, String language)
    {
        this.id = id;
        this.userId = userId;
        this.patikaId = patikaId;
        this.name = name;
        this.language = language;
        this.patika=Patika.getFetch(this.patikaId);
        this.educator=User.getFetchByUName(this.userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPatikaId() {
        return patikaId;
    }

    public void setPatikaId(int patikaId) {
        this.patikaId = patikaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Patika getPatika() {
        return patika;
    }

    public void setPatika(Patika patika) {
        this.patika = patika;
    }

    public User getEducator() {
        return educator;
    }

    public void setEducator(User educator) {
        this.educator = educator;
    }
    public static ArrayList<Course> getList()
    {
        ArrayList<Course> courseList=new ArrayList<>();
        Course obj;

        try {
            Statement st= DBConnector.getInstance().createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM course");
            while (rs.next())
            {
                int id=rs.getInt("id");
                int userId=rs.getInt("userId");
                int patikaId=rs.getInt("patikaId");
                String name=rs.getString("name");
                String language=rs.getString("language");
                obj=new Course(id,userId,patikaId,name,language);

                courseList.add(obj);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseList;

    }
    public static boolean addCourse(int userId,int patikaId,String name,String language)
    {
        String query="INSERT INTO course (id,userId,patikaId,name,language) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setInt(1,Course.getList().toArray().length+1);
            st.setInt(2,userId);
            st.setInt(3,patikaId);
            st.setString(4,name);
            st.setString(5,language);

            return st.executeUpdate()!=-1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
