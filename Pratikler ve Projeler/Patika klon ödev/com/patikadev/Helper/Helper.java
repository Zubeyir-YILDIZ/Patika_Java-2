package com.patikadev.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper
{
    public static int screenCenter(String axis, Dimension size)
    {
        int point=0;
        switch (axis)
        {
            case "x":
                 point=(Toolkit.getDefaultToolkit().getScreenSize().width-size.width)/2;
                 break;
            case "y":
                point=(Toolkit.getDefaultToolkit().getScreenSize().height-size.height)/2;
                break;
            default:
                point=0;
        }
        return point;
    }
    public static boolean isEmpty(JTextField field)
    {
        return field.getText().trim().isEmpty();
    }
    public static void showMessage(String str)
    {
        optionPaneTR();
        String msg;
        String title;

        switch (str)
        {
            case "fill":
                msg="Lütfen tüm alanları doldurunuz";
                title="HATA!";
                break;
            case "done":
                msg="İşlem başarılı";
                title="sonuç";
                break;
            case "error":
                msg="Bir hata oluştu";
                title="Hata";
                break;
            case "isHave":
                msg="Kullanıcı adı alınmış";
                title="Uyarı";
                break;
            default:
                msg=str;
                title="mesaj";

        }
        JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String str)
    {
        optionPaneTR();
        String msg;
        switch (str)
        {
            case "sure":
                msg="Bu işlemi gerçekleştirme istediğinize emin misiniz?";
                break;
            default:
                msg=str;

        }
        return JOptionPane.showConfirmDialog(null,msg,"Son Kararınız mı?",JOptionPane.YES_NO_OPTION)==0;
    }

    public static void optionPaneTR()
    {
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }
}
