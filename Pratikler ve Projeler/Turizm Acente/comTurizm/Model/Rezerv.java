package comTurizm.Model;

import comTurizm.Helper.DBConnector;
import comTurizm.Helper.Helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Rezerv
{
    private String otelName;
    private int roomId;
    private String customerName;
    private String customerId;
    private int totalPrice;
    private String in;
    private String out;

    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getOtelName() {
        return otelName;
    }

    public void setOtelName(String otelName) {
        this.otelName = otelName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Rezerv(String otelName, int roomId, int totalPrice, String in, String out) {
        this.otelName = otelName;
        this.roomId = roomId;
        this.totalPrice = totalPrice;
        this.in = in;
        this.out = out;
        setRoomId(this.roomId);

        Connection.addCustomer(otelName,roomId,totalPrice,in,out);

    }
    public Rezerv(String customerName,int roomId)
    {
        this.customerName=customerName;
        this.roomId=roomId;
        Connection.addCustomer2(customerName,roomId);
        Helper.showMessage("Rezervasyonunuz yapıldı");
    }






}
