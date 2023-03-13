package comTurizm.View;

import comTurizm.Helper.Config;
import comTurizm.Helper.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame
{
    private JPanel panel;
    private JTextField txt_userName;
    private JPasswordField txt_password;
    private JButton btn_login;
    private JButton kapatButton;

    public AdminGUI()
    {
        add(panel);
        setSize(500,500);
        setLocation(Helper.screenLocation("x",getSize()),Helper.screenLocation("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);


        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt_userName.getText().equals("admin") && txt_password.getText().equals("admin"))
                {
                    adminPGUI.createPanel();
                }
                else
                    Helper.showMessage("hatalı giriş");
            }
        });
        kapatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void createPanel()
    {
        AdminGUI gui=new AdminGUI();
    }


}
