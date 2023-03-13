package comTurizm.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper
{

    public static int screenLocation(String axis, Dimension size)
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
    public static void showMessage(String key)
    {
        String message;
        String title;

        switch (key)
        {
            case "fill":
                message="Lütfen tüm alanları doldurun";
                title="Eksik Bilgi";
                break;
            case "done":
                message="İşlem Başarılı";
                title="Sonuç";
                break;
            default:
                message=key;
                title="Mesaj";
        }
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
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
