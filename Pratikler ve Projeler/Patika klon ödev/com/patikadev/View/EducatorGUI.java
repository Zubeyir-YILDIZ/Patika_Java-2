package com.patikadev.View;

import com.patikadev.Helper.Config;
import com.patikadev.Helper.Helper;
import com.patikadev.Model.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class EducatorGUI extends JFrame
{
    private JPanel wrapper;
    private JTable tbl_educationList;
    private JLabel lbl_details;
    private JScrollPane scrl_eduList;
    private JLabel lbl_lesName;
    private JLabel lbl_lesLink;
    private JTable tbl_questions;
    private JScrollPane scrl_question;
    private JLabel lbl_educatorWell;
    private JButton btn_search;
    private JTextField txt_lessonSearch;
    private JLabel lbl_search;
    private JButton btn_addQues;
    private JButton btn_delQues;
    private JButton btn_exit;
    private JTextArea tbl_info;
    private JButton btn_addLink;
    private JTextField txt_addLink;
    private JButton btn_getDetails;
    private JButton btn_getQues;
    private JTable tbl_lessons;
    static private DefaultTableModel mdl_eduList;
    private Object[] row_eduList;
    private Educator educator;
    private String educatorName;
    private Map<String,String> links;
    private String link;
    private String question;
    private int id;
    private String name;
    private String[] list;
    static private DefaultTableModel mdl_quesList;
    private Object[] row_quesList;

    public static DefaultTableModel getMdl_eduList() {
        return mdl_eduList;
    }

    public EducatorGUI()
    {

        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenCenter("x", getSize()),Helper.screenCenter("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);

        mdl_eduList = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if(column == 0 || column==1)
                {
                    return false;
                }
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_educatorList={"ID","Patika","İçerk Adı","Programlama dili"};
        mdl_eduList.setColumnIdentifiers(col_educatorList);
        row_eduList=new Object[col_educatorList.length];
        tbl_educationList.setModel(mdl_eduList);
        loadEduModel();
        lbl_educatorWell.setText("Hoşgeldin "+educatorName);
        tbl_educationList.getTableHeader().setReorderingAllowed(false);
        updateLesson();

        btn_exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_addLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_lesLink.setText(txt_addLink.getText());
            }
        });
        btn_getDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Educator.setUdu(id,id,name,tbl_info.getText(),txt_addLink.getText());
            }
        });
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel clearModel= (DefaultTableModel) tbl_educationList.getModel();
                clearModel.setRowCount(0);
                mdl_eduList=Educator.searchList(txt_lessonSearch.getText(),col_educatorList.length,mdl_eduList);
            }
        });
        btn_addQues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                question=tbl_info.getText();
            }
        });
        btn_addLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                link=txt_addLink.getText();
            }
        });


        btn_delQues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_getQues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mdl_quesList =new DefaultTableModel();
                Object[] col_questionList={"Question"};
                mdl_quesList.setColumnIdentifiers(col_questionList);
                row_quesList=new Object[col_questionList.length];
                loadQuestion();
                tbl_questions.setModel(mdl_quesList);



            }
        });
    }

    public void loadEduModel()
    {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_educationList.getModel();
        clearModel.setRowCount(0);
        for(Course obj: Course.getList())
        {
            int i=0;
            row_eduList[i++]=obj.getId();
            educatorName=obj.getEducator().getName();
            row_eduList[i++]=obj.getPatika().getName();
            row_eduList[i++]=obj.getName();
            row_eduList[i++]=obj.getLanguage();
            mdl_eduList.addRow(row_eduList);
        }

    }
    public void updateLesson()
    {
        tbl_educationList.getModel().addTableModelListener(e -> {
            String lesLang=null;
            if(e.getType()== TableModelEvent.UPDATE)
            {
                name= tbl_educationList.getValueAt(tbl_educationList.getSelectedRow(),2).toString();
                lesLang=tbl_educationList.getValueAt(tbl_educationList.getSelectedRow(),3).toString();
                id=Integer.parseInt(tbl_educationList.getValueAt(tbl_educationList.getSelectedRow(),0).toString());

            }
                if(Educator.updateEdu(name,lesLang,id))
                {
                    Helper.showMessage("done");
                }

        });
    }
    public void getDetails()
    {
        tbl_educationList.getModel().addTableModelListener(e -> {
            if(e.getType()== TableModelEvent.UPDATE) {
                lbl_lesName.setText(tbl_educationList.getValueAt(tbl_educationList.getSelectedRow(), 2).toString());
                lbl_lesLink.setText(txt_addLink.getText());
                links.get((tbl_educationList.getValueAt(tbl_educationList.getSelectedRow(),0).toString()));
            }
        });
    }
    public void loadQuestion()
    {
        DefaultTableModel clearModel= (DefaultTableModel) tbl_questions.getModel();
        clearModel.setRowCount(0);
        String[] s=Educator.getQues(Integer.parseInt(tbl_educationList.getValueAt(tbl_educationList.getSelectedRow(),0).toString()));

            int i=0;
            row_quesList[i++]=s[0];
            lbl_lesLink.setText(s[1]);
            mdl_quesList.addRow(row_quesList);
    }

}



