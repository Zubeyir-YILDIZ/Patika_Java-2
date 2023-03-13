package comTurizm.Model;

import comTurizm.Helper.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Otels
{
    private String name;
    private String address;
    private String mail;
    private String phone;
    private int wifi;
    private int minibar;
    private int tv;
    private int case1;
    private int console;
    private int projection;
    private int autoPark;
    private int roomService;
    private int fitnessCenter;
    private String city1;
    private int roomCount;
    private String link;
    private int price;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public int getMinibar() {
        return minibar;
    }

    public void setMinibar(int minibar) {
        this.minibar = minibar;
    }

    public int getTv() {
        return tv;
    }

    public void setTv(int tv) {
        this.tv = tv;
    }

    public int getCase1() {
        return case1;
    }

    public void setCase1(int case1) {
        this.case1 = case1;
    }

    public int getConsole() {
        return console;
    }

    public void setConsole(int console) {
        this.console = console;
    }

    public int getProjection() {
        return projection;
    }

    public void setProjection(int projection) {
        this.projection = projection;
    }

    public int getAutoPark() {
        return autoPark;
    }

    public void setAutoPark(int autoPark) {
        this.autoPark = autoPark;
    }

    public int getRoomService() {
        return roomService;
    }

    public void setRoomService(int roomService) {
        this.roomService = roomService;
    }

    public int getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(int fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public String getCity() {
        return city1;
    }

    public void setCity(String city1) {
        this.city1 = city1;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Otels(String name, String address, String mail, String phone, int wifi, int minibar, int tv, int case1, int console, int projection, int autoPark, int roomService, int fitnessCenter, String city1, int roomCount, String link, int price, int salary)
    {
        this.name = name;
        this.address = address;
        this.mail = mail;
        this.phone = phone;
        this.wifi = wifi;
        this.minibar = minibar;
        this.tv = tv;
        this.case1 = case1;
        this.console = console;
        this.projection = projection;
        this.autoPark = autoPark;
        this.roomService = roomService;
        this.fitnessCenter = fitnessCenter;
        this.city1 = city1;
        this.roomCount = roomCount;
        this.link = link;
        this.price = price;
        this.salary = salary;
    }
    public static ArrayList<Otels> getList(String city2)
    {
        ArrayList<Otels> otelList=new ArrayList<>();
        Otels obj;

        try {
            String query="SELECT * FROM otels WHERE city='"+city2+"'";
            Statement st= DBConnector.getInstance().createStatement();
            ResultSet rs=st.executeQuery(query);

            while (rs.next())
            {
                String name=rs.getString("name");
                String address=rs.getString("address");
                String mail=rs.getString("mail");
                String phone=rs.getString("phone");
                int wifi=rs.getInt("wifi");
                int minibar=rs.getInt("minibar");
                int tv=rs.getInt("tv");
                int case1=rs.getInt("case1");
                int console=rs.getInt("console");
                int projection=rs.getInt("projection");
                int autoPark=rs.getInt("autoPark");
                int roomService=rs.getInt("roomService");
                int fitnessCenter=rs.getInt("fitnessCenter");
                String city1=rs.getString("city");
                int roomCount=rs.getInt("roomCount");
                String link=rs.getString("link");
                int price=rs.getInt("price");
                int salary=rs.getInt("salary");
                obj=new Otels(name,address,mail,phone,wifi,minibar,tv,case1,console,projection,autoPark,roomService,fitnessCenter,city1,roomCount,link,price,salary);

                otelList.add(obj);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return otelList;

    }
}
