package comTurizm.Model;

import comTurizm.Helper.DBConnector;
import comTurizm.View.PrimaryGUI;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Connection
{
    public static boolean addOtel(String name,String address,String mail,String phone,int wifi,int minibar,int tv,int case1,int console,int projec,int autopark,int roomservice,int fitnessCenter,String city,int count,String link,int price,int salary)
    {
        String query="INSERT INTO otels(name,address,mail,phone,wifi,minibar,tv,case1,console,projection,autoPark,roomService,fitnessCenter,city,roomCount,link,price,salary) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try
        {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setString(1,name);
            st.setString(2,address);
            st.setString(3,mail);
            st.setString(4,phone);
            st.setInt(5,wifi);
            st.setInt(6,minibar);
            st.setInt(7,tv);
            st.setInt(8,case1);
            st.setInt(9,console);
            st.setInt(10,projec);
            st.setInt(11,autopark);
            st.setInt(12,roomservice);
            st.setInt(13,fitnessCenter);
            st.setString(14,city);
            st.setInt(15,count);
            st.setString(16,link);
            st.setInt(17,price);
            st.setInt(18,salary);

            return st.executeUpdate()!=-1;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }


    }
    public static boolean deleteOtel(String name)
    {
        String query="DELETE FROM otels WHERE name="+name;

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);

            return st.executeUpdate()!=1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static boolean addCustomer(String otelName,int roomId,int totalPrice,String in,String out)
    {
        String query="INSERT INTO rezerv(otelName,roomId,totalPrice,in1,out1) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);
            st.setString(1,otelName);
            st.setInt(2,roomId);
            st.setInt(3,totalPrice);
            st.setString(4,in);
            st.setString(5,out);


            return st.executeUpdate()!=-1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static boolean addCustomer2(String customerName,int roomId)
    {
        String query="UPDATE rezerv SET customerName="+"'"+customerName+"'"+" WHERE roomId="+"'"+roomId+"'";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);

            return st.executeUpdate()!=-1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean setRoomCount(int room,String name,String city)
    {
        String query="UPDATE otels SET roomCount="+"'"+room+"'"+" WHERE name="+"'"+name+"' AND city="+"'"+city+"'";

        try {
            PreparedStatement st=DBConnector.getInstance().prepareStatement(query);

            return st.executeUpdate()!=-1;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }









}
