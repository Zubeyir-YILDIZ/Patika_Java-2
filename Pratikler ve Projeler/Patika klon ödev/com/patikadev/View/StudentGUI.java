package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.Educator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame
{
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTable table2;
    private JTextField textField1;
    private JButton kayıtOlButton;
    private JButton çıkışYapButton;
    private JButton sorularıGetirButton;
    private JScrollPane tbl_ques;
    private DefaultTableModel mdl_quest;
    private Object[] row_quest;

    public StudentGUI()
    {
        add(wrapper);
        setSize(400,400);
        setLocation(Helper.screenCenter("x", getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        çıkışYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        mdl_quest=new DefaultTableModel();
        Object[] col_quest={"Sorular"};
        mdl_quest.setColumnIdentifiers(col_quest);
        row_quest=new Object[col_quest.length];
        table2.setModel(mdl_quest);












    }
    public void loadQuest()
    {

    }
}
