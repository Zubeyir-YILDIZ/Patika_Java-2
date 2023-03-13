package comTurizm.View;

import comTurizm.Helper.Config;
import comTurizm.Helper.Helper;
import comTurizm.Model.Connection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminPGUI extends JFrame
{
    private JPanel panel1;
    private JTextField txt_name;
    private JTextField txt_mail;
    private JTextField txt_phone;
    private JTextField txt_address;
    private JCheckBox chk_wifi;
    private JCheckBox chk_tv;
    private JCheckBox chk_mBar;
    private JCheckBox chk_safe;
    private JCheckBox chk_console;
    private JCheckBox chk_projection;
    private JCheckBox chk_park;
    private JCheckBox chk_serviceRoom;
    private JCheckBox chk_fitness;
    private JButton btn_add;
    private JTabbedPane tabbedPane1;
    private JTextField txt_delete;
    private JButton btn_delete;
    private JButton çıkışButton;
    private JTextField txt_link;
    private JTextField txt_count;
    private JTextField txt_price;
    private JTextField txt_salary;
    private String[] links=new String[1000];
    private int counter=0;

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public adminPGUI()
    {
        add(panel1);
        setSize(600,600);
        setLocation(Helper.screenLocation("x",getSize()),Helper.screenLocation("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        btn_add.addActionListener(e ->
        {
            if(txt_name.getText().equals("") || txt_address.getText().equals("") || txt_mail.getText().equals("") || txt_phone.getText().equals(""))
                Helper.showMessage("fill");
            else
            {
                int wifi=0;
                int minibar=0;
                int tv=0;
                int case1=0;
                int console=0;
                int projec=0;
                int autoP=0;
                int roomService=0;
                int fitness=0;
                if(chk_wifi.isSelected())
                    wifi=1;
                if(chk_mBar.isSelected())
                    minibar=1;
                if(chk_tv.isSelected())
                    tv=1;
                if(chk_safe.isSelected())
                    case1=1;
                if(chk_console.isSelected())
                    console=1;
                if(chk_projection.isSelected())
                    projec=1;
                if (chk_park.isSelected())
                    autoP=1;
                if(chk_serviceRoom.isSelected())
                    roomService=1;
                if(chk_fitness.isSelected())
                    fitness=1;
                int count=Integer.parseInt(txt_count.getText());
                int price=Integer.parseInt(txt_price.getText());
                int salary=Integer.parseInt(txt_salary.getText());
                Connection.addOtel(txt_name.getText(),txt_address.getText(),txt_mail.getText(),txt_phone.getText(),wifi,minibar,tv,case1,console,projec,autoP,roomService,fitness,txt_address.getText().split("-")[0],count,txt_link.getText(),price,salary);
                Helper.showMessage("done");
            }
        });
        btn_delete.addActionListener(e -> {

            if(!txt_delete.getText().equals(""))
            {
                Connection.deleteOtel(txt_delete.getText());
                Helper.showMessage("Kayıt silindi");
            }
            else
                Helper.showMessage("fill");
        });
        çıkışButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void createPanel()
    {
        adminPGUI adminPGUI=new adminPGUI();
    }




}
