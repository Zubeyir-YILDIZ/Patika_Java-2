package com.patikadev.Model;

import com.patikadev.Helper.DBConnector;
import com.patikadev.View.EducatorGUI;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Educator extends User
{
    private static int counter=0;


    public static boolean updateEdu(String lesName,String lesLang,int id)
    {
        String query="UPDATE course SET name=? , language=? WHERE id=?";
        try {
            PreparedStatement st= DBConnector.getInstance().prepareStatement(query);
            st.setString(1,lesName);
            st.setString(2,lesLang);
            st.setInt(3,id);

            return st.executeUpdate()!=-1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static String query(String name)
    {
        String query="SELECT * FROM course WHERE name LIKE '%{{name}}%' ";
        query=query.replace("{{name}}",name);


        return query;

    }

    public static DefaultTableModel searchList(String name, int value,DefaultTableModel mdl)
    {
        Object[] row=new Object[value];
        if(name.equals(""))
        {
            for(Course obj: Course.getList())
            {
                int i=0;
                row[i++]=obj.getId();
                row[i++]=obj.getPatika().getName();
                row[i++]=obj.getName();
                row[i++]=obj.getLanguage();
                mdl.addRow(row);
            }
        }
        else
        {
            for(Course obj: Course.getList())
            {
                if(obj.getName().equals(name))
                {
                    int i=0;
                    row[i++]=obj.getId();
                    row[i++]=obj.getPatika().getName();
                    row[i++]=obj.getName();
                    row[i++]=obj.getLanguage();
                    mdl.addRow(row);
                }
            }

        }
        return mdl;
    }
    public static boolean setUdu(int id,int eduId,String name,String question,String link)
    {
        String query="INSERT INTO education (id,educatorId,name,question,link) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setInt(1,counter++);
            st.setInt(2,eduId);
            st.setString(3,name);
            st.setString(4,question);
            st.setString(5,link);

            return st.executeUpdate() != -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] getQues(int id)
    {
        String[] list=new String[2];
        try {
            Statement st=DBConnector.getInstance().createStatement();
            ResultSet rs=st.executeQuery("SELECT * from education WHERE educatorId="+id);
            while (rs.next())
            {
                String ques=rs.getString("question");
                String link=rs.getString("link");
                list[0]=ques;
                list[1]=link;
            }

            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

