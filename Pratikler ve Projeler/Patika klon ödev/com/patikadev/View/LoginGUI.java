package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Operator;
import com.patikadev.Model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wrapperTop;
    private JPanel wrapperBottom;
    private JLabel lbl_userLogin;
    private JLabel lbl_name;
    private JTextField txt_userNameLogin;
    private JPasswordField txt_passwordLogin;
    private JLabel lbl_userNameLogin;
    private JLabel lbl_passwordLogin;
    private JButton btn_login;
    private JButton öğrenciKayıtButton;
    private JTextField textField1;
    private JButton ekleButton;

    public LoginGUI()
    {
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);




        btn_login.addActionListener(e -> {

            if(Helper.isEmpty(txt_userNameLogin)||Helper.isEmpty(txt_passwordLogin))
            {
                Helper.showMessage("fill");
            }
            else
            {
                User u=User.getFetchByUName(txt_userNameLogin.getText(),txt_passwordLogin.getText());
                if(u==null)
                {
                    Helper.showMessage("Kullanıcı Bulunamadı!");
                }
                else
                {
                    Helper.showMessage("Giriş Başarılı");
                    switch (u.getUserType())
                    {
                        case "operator":
                            OperatorGUI opGUI=new OperatorGUI((Operator) u);
                            break;
                        case "educator":
                            EducatorGUI eduGUI=new EducatorGUI();
                            break;
                        case "student":
                            StudentGUI stGUI=new StudentGUI();
                            break;

                    }
                    dispose();
                }




            }
        });
        öğrenciKayıtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Yukarıdaki Alanlara bilgilerinizi giriniz ve giriş butonuna basınız");
                textField1.setEnabled(true);
            }
        });
        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User.add(textField1.getText(),txt_userNameLogin.getText(),"student",txt_passwordLogin.getText());
                JOptionPane.showMessageDialog(null,"Eklendiniz :) ");
            }
        });
    }

    public static void main(String[] args)
    {
        LoginGUI login=new LoginGUI();

    }
}
