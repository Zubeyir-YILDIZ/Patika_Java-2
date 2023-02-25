package com.patikadev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exemple extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbot;
    private JLabel lblTitle;
    private JLabel lblUsername;
    private JTextField fldUsername;
    private JLabel lblPassword;
    private JPasswordField fldPassword;
    private JButton btnLogin;

    public Exemple()
    {
        setContentPane(wrapper);
        setSize(300,300);
        setTitle("Patika DEV");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        int x=(Toolkit.getDefaultToolkit().getScreenSize().width-getSize().width)/2;
        int y=(Toolkit.getDefaultToolkit().getScreenSize().height-getSize().height)/2;
        setLocation(x,y);


        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(fldUsername.getText().length()==0 || fldPassword.getText().length()==0)
                {
                    JOptionPane.showMessageDialog(null,"Tüm alanları doldurun!","HATA",JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });
    }

}
