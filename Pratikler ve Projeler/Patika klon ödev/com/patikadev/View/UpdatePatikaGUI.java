package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Patika;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePatikaGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_patikaName;
    private JTextField txt_patikaName;
    private JButton btn_update;
    private Patika patika;

    public UpdatePatikaGUI(Patika patika)
    {
        this.patika=patika;
        add(wrapper);
        setSize(300,150);
        setLocation(Helper.screenCenter("x",getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setVisible(true);

        txt_patikaName.setText(patika.getName());


        btn_update.addActionListener(e -> {
              if(Helper.isEmpty(txt_patikaName))
              {
                  Helper.showMessage("fill");
              }
              else
              {
                  if(Patika.update(patika.getId(),txt_patikaName.getText()))
                  {
                      Helper.showMessage("done");

                  }
                  dispose();


              }
        });
    }



}
