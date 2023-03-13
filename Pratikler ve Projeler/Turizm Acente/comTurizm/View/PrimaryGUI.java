package comTurizm.View;

import comTurizm.Helper.Config;
import comTurizm.Helper.Helper;
import comTurizm.Model.Connection;
import comTurizm.Model.Otels;
import comTurizm.Model.Rezerv;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class PrimaryGUI extends JFrame
{
    public JPanel panel;
    private JLabel lbl_welcome;
    private JLabel lbl_city;
    private JCheckBox chk_wifi;
    private JCheckBox chk_tv;
    private JCheckBox chk_mBar;
    private JCheckBox chk_safe;
    private JCheckBox chk_console;
    private JCheckBox chk_projection;
    private JComboBox cmb_inDay;
    private JComboBox cmb_inMon;
    private JComboBox cmb_outMon;
    private JComboBox cmb_outDay;
    private JComboBox cmb_parent;
    private JComboBox cmb_child;
    private JComboBox cmb_bedCount;
    static private DefaultTableModel mdl_otels;
    private JTable tbl_hotelList;

    public static String link="";

    public JCheckBox getChk_wifi() {
        return chk_wifi;
    }

    public void setChk_wifi(JCheckBox chk_wifi) {
        this.chk_wifi = chk_wifi;
    }

    public JCheckBox getChk_tv() {
        return chk_tv;
    }

    public void setChk_tv(JCheckBox chk_tv) {
        this.chk_tv = chk_tv;
    }

    public JCheckBox getChk_mBar() {
        return chk_mBar;
    }

    public void setChk_mBar(JCheckBox chk_mBar) {
        this.chk_mBar = chk_mBar;
    }

    public JCheckBox getChk_safe() {
        return chk_safe;
    }

    public void setChk_safe(JCheckBox chk_safe) {
        this.chk_safe = chk_safe;
    }

    public JCheckBox getChk_console() {
        return chk_console;
    }

    public void setChk_console(JCheckBox chk_console) {
        this.chk_console = chk_console;
    }

    public JCheckBox getChk_projection() {
        return chk_projection;
    }

    public void setChk_projection(JCheckBox chk_projection) {
        this.chk_projection = chk_projection;
    }

    public JTable getTbl_hotelList() {
        return tbl_hotelList;
    }

    public void setTbl_hotelList(JTable tbl_hotelList) {
        this.tbl_hotelList = tbl_hotelList;
    }

    public JCheckBox getChk_park() {
        return chk_park;
    }

    public void setChk_park(JCheckBox chk_park) {
        this.chk_park = chk_park;
    }

    public JCheckBox getChk_serviceRoom() {
        return chk_serviceRoom;
    }

    public void setChk_serviceRoom(JCheckBox chk_serviceRoom) {
        this.chk_serviceRoom = chk_serviceRoom;
    }

    public JCheckBox getChk_fitness() {
        return chk_fitness;
    }

    public void setChk_fitness(JCheckBox chk_fitness) {
        this.chk_fitness = chk_fitness;
    }

    private Object[] row_otels;
    private JCheckBox chk_park;
    private JCheckBox chk_serviceRoom;
    private JCheckBox chk_fitness;
    private JButton btn_search;
    private JButton btn_getHotel;
    private JButton btn_exit;
    private JButton btn_admin;
    private JTextField txt_cityName;
    private JLabel lbl_link;
    private JTextField txt_options;
    private JScrollPane scrl_otelList;
    private JLabel lbl_childPrice;
    private JLabel lbl_price;

    public JLabel getLbl_link() {
        return lbl_link;
    }
    private int salary=0;

    public void setLbl_link(JLabel lbl_link) {
        this.lbl_link = lbl_link;
    }
    static int count=0;
    static int room=0;
    static String names="";

    public static void setNames(String names) {
        PrimaryGUI.names = names;
    }

    public static String getNames() {
        return names;
    }

    public PrimaryGUI()
    {
        add(panel);
        setSize(900,700);
        setLocation(Helper.screenLocation("x",getSize()),Helper.screenLocation("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        Helper.showMessage("Lütfen otelleri görüntülemek için şehir adı giriniz \nSeçili otele ait özellikleri yan taraftan kontrol edebilirsiniz");
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AdminGUI.createPanel();
            }
        });
        btn_search.addActionListener(e ->
        {
            mdl_otels=new DefaultTableModel()
            {
                @Override
                public boolean isCellEditable(int a,int b)
                {
                    if(b==0 || b==1)
                        return false;
                    return super.isCellEditable(a,b);
                }
            };
            Object[] col_otels={"name","address"};
            mdl_otels.setColumnIdentifiers(col_otels);
            row_otels=new Object[col_otels.length];
            tbl_hotelList.setModel(mdl_otels);
            tbl_hotelList.getTableHeader().setReorderingAllowed(false);
            loadModel();


        });



        tbl_hotelList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getButton()==1)
                    loadDetails();
            }
        });

        btn_getHotel.addActionListener(e ->
        {
            int parentCount=Integer.parseInt(Objects.requireNonNull(cmb_parent.getSelectedItem()).toString());
            int childCount=Integer.parseInt(Objects.requireNonNull(cmb_child.getSelectedItem()).toString());
            int badCount=Integer.parseInt(Objects.requireNonNull(cmb_bedCount.getSelectedItem()).toString());

            int inMon=cmb_inDay.getSelectedIndex()+1;
            int inDay=Integer.parseInt((cmb_inMon.getSelectedItem()).toString());
            int outMon=cmb_outMon.getSelectedIndex()+1;
            int outDay=Integer.parseInt((cmb_outDay.getSelectedItem()).toString());
            int price=0;
            if(inMon>=6 && inMon<=9)
                price=(Integer.parseInt(lbl_price.getText().split(" ")[0]))-(Integer.parseInt(lbl_price.getText().split(" ")[0])*salary)/100;
            else
                price=Integer.parseInt(lbl_price.getText().split(" ")[0]);

            String in=inDay+"/"+inMon;
            String out=outDay+"/"+outMon;
            String otelName=tbl_hotelList.getValueAt(tbl_hotelList.getSelectedRow(),0).toString();
            int roomId=--room;
            int totalPrice=(price*parentCount+(price*childCount*70)/100)+((badCount-1)*50);

            Helper.showMessage("Toplam Fiyat: "+totalPrice);
            if(Helper.confirm("sure"))
            {
                RezervGUI.showGUI(parentCount,childCount);

                Connection.setRoomCount(roomId,otelName,row_otels[1].toString().split("-")[0]);

                Rezerv rs=new Rezerv(otelName,roomId,totalPrice,in,out);


            }

        });
    }

    public void loadModel()
    {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_hotelList.getModel();
        clearModel.setRowCount(0);
        for(Otels obj:Otels.getList(txt_cityName.getText()))
        {
            row_otels[0]=obj.getName();
            row_otels[1]=obj.getAddress();
            mdl_otels.addRow(row_otels);
        }
    }
    public void loadDetails()
    {
        Helper.showMessage("Rezervasyon için yan taraftan seçiminizi yapınız");
        for(Otels obj:Otels.getList(txt_cityName.getText()))
        {
            if(tbl_hotelList.getValueAt(tbl_hotelList.getSelectedRow(),0).toString().equals(""))
                tbl_hotelList.setRowSelectionInterval(0, 0);
            if(obj.getName().equals(tbl_hotelList.getValueAt(tbl_hotelList.getSelectedRow(),0).toString()))
            {
                chk_wifi.setSelected(obj.getWifi() == 1);
                chk_mBar.setSelected(obj.getMinibar() == 1);
                chk_tv.setSelected(obj.getTv() == 1);
                chk_safe.setSelected(obj.getCase1()==1);
                chk_console.setSelected(obj.getConsole()==1);
                chk_projection.setSelected(obj.getProjection()==1);
                chk_park.setSelected(obj.getAutoPark()==1);
                chk_serviceRoom.setSelected(obj.getRoomService()==1);
                chk_fitness.setSelected(obj.getFitnessCenter()==1);

                cmb_bedCount.setEnabled(true);
                cmb_parent.setEnabled(true);
                cmb_child.setEnabled(true);
                cmb_inDay.setEnabled(true);
                cmb_inMon.setEnabled(true);
                cmb_outMon.setEnabled(true);
                cmb_outDay.setEnabled(true);

                lbl_link.setText(obj.getLink());
                int price=obj.getPrice();
                salary=obj.getSalary();
                room=obj.getRoomCount();

                lbl_price.setText(String.valueOf(price)+" TL");
                lbl_childPrice.setText(String.valueOf((price/100)*70)+" TL");


            }


        }






    }




}
