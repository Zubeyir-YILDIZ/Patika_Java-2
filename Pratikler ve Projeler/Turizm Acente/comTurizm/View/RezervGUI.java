package comTurizm.View;

import comTurizm.Helper.Config;
import comTurizm.Helper.Helper;
import comTurizm.Model.Rezerv;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RezervGUI extends JFrame
{


    private JPanel panel;
    private JLabel lbl_parentName;
    private JTextField txt_parentName;
    private JLabel lbl_tcNo;
    private JTextField txt_tcNo;
    private int roomId;
    private JButton btn_save;
    private ArrayList<Rezerv> rezervs=new ArrayList<>();

    private String customers;

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers += customers;
    }
    static String str;
    public RezervGUI() {
        add(panel);
        setSize(400,200);
        setLocation(Helper.screenLocation("x",getSize()),Helper.screenLocation("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PrimaryGUI.names+=lbl_parentName.getText()+":"+txt_parentName.getText()+"-"+txt_tcNo.getText()+" ";
                str=PrimaryGUI.names;
                roomId=PrimaryGUI.room;
                Rezerv rs=new Rezerv(str,roomId);
                dispose();
            }
        });

    }

    public static void showGUI(int number1,int number2)
    {

            for(int i=1;i<=number1;i++)
            {
                RezervGUI rs=new RezervGUI();
                rs.lbl_parentName.setText(i+".Yetişkin Adı: ");
                rs.lbl_tcNo.setText(i+".Yetişkin TC: ");




            }
            for(int i=1;i<=number2;i++)
            {
                RezervGUI rs=new RezervGUI();
                rs.lbl_parentName.setText(i+".Çocuk Adı: ");
                rs.lbl_tcNo.setText(i+".Çocuk TC: ");



            }
    }





}
