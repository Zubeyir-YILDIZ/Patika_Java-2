package com.patikadev.View;

import com.patikadev.Helper.*;
import com.patikadev.Model.Course;
import com.patikadev.Model.Operator;
import com.patikadev.Model.Patika;
import com.patikadev.Model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGUI extends JFrame
{
    private final Operator operator;
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JPanel panel1;
    private JLabel lbl_welcome;
    private JButton btn_exit;
    private JPanel panel_userList;
    private JScrollPane scrl_userList;
    private JTable tbl_userList;
    private JPanel pnl_userForm;
    private JLabel lbl_userName;
    private JTextField txt_userName;
    private JLabel lbl_uUserName;
    private JTextField txt_uUserName;
    private JLabel lbl_password;
    private JPasswordField txt_password;
    private JLabel lbl_userType;
    private JComboBox cmb_userType;
    private JButton btn_userAdd;
    private JLabel lbl_userId;
    private JTextField txt_userId;
    private JButton btn_delete;
    private JTextField txt_nameSrc;
    private JLabel lbl_nameSrc;
    private JTextField txt_userNameSrc;
    private JLabel lbl_userNameSrc;
    private JLabel lbl_userTypeSrc;
    private JComboBox cmb_userTypeSrc;
    private JButton btn_Search;
    private JScrollPane scrl_patikaList;
    private JTable tbl_patikaList;
    private JPanel pnl_patikaAdd;
    private JTextField txt_patikaName;
    private JButton btn_patikaAdd;
    private JScrollPane scrl_courseList;
    private JTable tbl_courseList;
    private JPanel pnl_courseAdd;
    private JTextField txt_courseName;
    private JLabel lbl_courseName;
    private JTextField txt_courseLang;
    private JComboBox cmb_patikaList;
    private JLabel lbl_courselang;
    private JLabel lbl_patikaList;
    private JComboBox cmb_courseEducator;
    private JLabel lbl_courseEducator;
    private JButton btn_add;
    private DefaultTableModel mdl_userList;
    private static Object[] row_userList;
    private DefaultTableModel mdl_patikaList;
    private Object[] row_patikaList;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_courseList;
    private Object[] row_courseList;


    public OperatorGUI(Operator operator)
    {
        this.operator = operator;


        add(panel1);

        setSize(1000,500);

        int x= Helper.screenCenter("x",getSize());
        int y=Helper.screenCenter("y",getSize());
        setLocation(x,y);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);


        lbl_welcome.setText("Hoşgeldin "+operator.getName());

        //Model user list
        mdl_userList=new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0) return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_userList={"ID","Ad Soyad","kullanıcı Adı","Üyelik Türü","Şifre"};
        mdl_userList.setColumnIdentifiers(col_userList);
        row_userList=new Object[col_userList.length];

        loadUserMode();

        tbl_userList.setModel(mdl_userList);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

        tbl_userList.getSelectionModel().addListSelectionListener(e -> {
            try{
                String selectedRow=tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString();
                txt_userId.setText(selectedRow);
            }
            catch (Exception ex)
            {

            }

        });
        tbl_userList.getModel().addTableModelListener(e -> {

            if(e.getType()==TableModelEvent.UPDATE)
            {
                int userId=Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(),0).toString());
                String userName=tbl_userList.getValueAt(tbl_userList.getSelectedRow(),1).toString();
                String uUserName=tbl_userList.getValueAt(tbl_userList.getSelectedRow(),2).toString();
                String password=tbl_userList.getValueAt(tbl_userList.getSelectedRow(),3).toString();
                String userType=tbl_userList.getValueAt(tbl_userList.getSelectedRow(),4).toString();

                if(User.update(userId,userName,uUserName,password,userType))
                {
                    Helper.showMessage("done");
                    loadUserMode();
                }


                loadUserMode();
            }
        });

        //PatikaList ****************************************************************************************************

        patikaMenu=new JPopupMenu();
        JMenuItem updateMenu=new JMenuItem("Güncelle");
        JMenuItem deleteMenu=new JMenuItem("Sil");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        updateMenu.addActionListener(e -> {
            int selectId=Integer.parseInt(tbl_patikaList.getValueAt(tbl_patikaList.getSelectedRow(),0).toString());
            UpdatePatikaGUI updateGUI =new UpdatePatikaGUI(Patika.getFetch(selectId));
            updateGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadpatikaModel();
                    loadPatikaCmb();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
                if(Helper.confirm("sure"))
                {
                    int selectId=Integer.parseInt(tbl_patikaList.getValueAt(tbl_patikaList.getSelectedRow(),0).toString());
                    if(Patika.delete(selectId))
                    {
                        Helper.showMessage("done");
                        loadpatikaModel();
                        loadPatikaCmb();
                    }
                    else
                    {
                        Helper.showMessage("error");
                    }

                }
        });


        mdl_patikaList=new DefaultTableModel();
        Object[] col_patikaList={"ID","Patika Adı"};
        mdl_patikaList.setColumnIdentifiers(col_patikaList);
        row_patikaList=new Object[col_patikaList.length];
        loadpatikaModel();
        loadPatikaCmb();

        tbl_patikaList.setModel(mdl_patikaList);
        tbl_patikaList.setComponentPopupMenu(patikaMenu);
        tbl_patikaList.getTableHeader().setReorderingAllowed(false);
        tbl_patikaList.getColumnModel().getColumn(0).setMaxWidth(70);

        tbl_patikaList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point =e.getPoint();
                int selected_row=tbl_patikaList.rowAtPoint(point);
                tbl_patikaList.setRowSelectionInterval(selected_row,selected_row);
            }
        });

        //CourseList *****************************************************************************************************************
        mdl_courseList =new DefaultTableModel();
        Object[] col_courseList={"ID","Eğitmen","Patika","Adı","Programlama dili"};
        mdl_courseList.setColumnIdentifiers(col_courseList);
        row_courseList=new Object[col_courseList.length];
        loadCourseModel();

        tbl_courseList.setModel(mdl_courseList);
        tbl_courseList.getTableHeader().setReorderingAllowed(false);

        loadPatikaCmb();
        loadEducatorCmb();









        btn_userAdd.addActionListener(e -> {
            if (Helper.isEmpty(txt_userName)|| Helper.isEmpty(txt_uUserName) || Helper.isEmpty(txt_password))
            {
                Helper.showMessage("fill");
            }
            else
            {
                String name=txt_userName.getText();
                String userName=txt_uUserName.getText();
                String password=txt_password.getText();
                String userType=cmb_userType.getSelectedItem().toString();
                if(User.add(name,userName,userType,password))
                {
                    Helper.showMessage("done");
                    loadUserMode();
                    loadEducatorCmb();
                    txt_userName.setText(null);
                    txt_uUserName.setText(null);
                    txt_password.setText(null);
                }

            }


        });
        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isEmpty(txt_userId))
                {
                    Helper.showMessage("fill");
                }
                else
                {
                    if(Helper.confirm("sure"))
                    {
                        int id=Integer.parseInt(txt_userId.getText());
                        if(User.delete(id))
                        {
                            Helper.showMessage("done");
                            loadUserMode();
                            loadEducatorCmb();
                            txt_userId.setText(null);
                        }
                        else
                        {
                            Helper.showMessage("error");
                        }
                    }


                }
            }
        });
        btn_Search.addActionListener(e -> {

            String name=txt_nameSrc.getText();
            String userName=txt_userNameSrc.getText();
            String userType=cmb_userTypeSrc.getSelectedItem().toString();

            String query=User.query(userName,name,userType);
            ArrayList<User> searching=User.searchUserList(query);
            loadUserMode(searching);

        });
        btn_exit.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI=new LoginGUI();
        });

        btn_patikaAdd.addActionListener(e -> {
                if(Helper.isEmpty(txt_patikaName))
                {
                    Helper.showMessage("fill");
                }
                else
                {
                    if(Patika.add(txt_patikaName.getText()))
                    {
                        Helper.showMessage("done");
                        loadpatikaModel();
                        loadPatikaCmb();
                        txt_patikaName.setText(null);
                    }
                    else
                    {
                        Helper.showMessage("error");
                    }

                }

        });
        btn_add.addActionListener(e -> {
            Item patikaItem= (Item) cmb_patikaList.getSelectedItem();
            Item educatorItem= (Item) cmb_courseEducator.getSelectedItem();
            if(Helper.isEmpty(txt_courseName) || Helper.isEmpty(txt_courseLang))
            {
                Helper.showMessage("fill");
            }
            else
            {
                if(Course.addCourse(educatorItem.getKey(),patikaItem.getKey(),txt_courseName.getText(),txt_courseLang.getText()))
                {
                    Helper.showMessage("done");
                    loadCourseModel();
                    txt_courseName.setText(null);
                    txt_courseLang.setText(null);
                }
                else
                {
                    Helper.showMessage("error");
                }


            }
        });
    }

    private void loadCourseModel()
    {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_courseList.getModel();
        clearModel.setRowCount(0);
        for(Course obj: Course.getList())
        {
            int i=0;
            row_courseList[i++]=obj.getId();
            row_courseList[i++]=obj.getEducator().getName();
            row_courseList[i++]=obj.getPatika().getName();
            row_courseList[i++]=obj.getName();
            row_courseList[i++]=obj.getLanguage();
            mdl_courseList.addRow(row_courseList);
        }


    }

    private void loadpatikaModel()
    {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_patikaList.getModel();
        clearModel.setRowCount(0);
        for(Patika obj: Patika.getList())
        {
            int i=0;
            row_patikaList[i++]=obj.getId();
            row_patikaList[i++]=obj.getName();
            mdl_patikaList.addRow(row_patikaList);
        }

    }

    public void loadUserMode(ArrayList<User> users)
    {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        for(User obj: users)
        {
            int i=0;
            row_userList[i++]=obj.getId();
            row_userList[i++]=obj.getName();
            row_userList[i++]=obj.getUserName();
            row_userList[i++]=obj.getUserType();
            row_userList[i++]=obj.getPassword();
            mdl_userList.addRow(row_userList);

        }

    }
    public void loadUserMode()
    {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);
        for(User obj: User.getList())
        {
            int i=0;
            row_userList[i++]=obj.getId();
            row_userList[i++]=obj.getName();
            row_userList[i++]=obj.getUserName();
            row_userList[i++]=obj.getUserType();
            row_userList[i++]=obj.getPassword();
            mdl_userList.addRow(row_userList);

        }

    }

    public void loadPatikaCmb()
    {
        cmb_patikaList.removeAllItems();
        for(Patika obj:Patika.getList())
        {
            cmb_patikaList.addItem(new Item(obj.getId(),obj.getName()));
        }

    }
    public void loadEducatorCmb()
    {
        cmb_courseEducator.removeAllItems();
        for (User obj:User.getList())
        {
            if(obj.getUserType().equals("educator"))
            {
                cmb_courseEducator.addItem(new Item(obj.getId(),obj.getName()));
            }
        }


    }

}
