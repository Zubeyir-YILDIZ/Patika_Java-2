import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager
{
    Scanner input=new Scanner(System.in);
    private TreeSet<Account> accounts;


    public TreeSet<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(TreeSet<Account> accounts) {
        this.accounts = accounts;
    }
    public void login()
    {
        System.out.println(accounts.size());
        System.out.println("****GİRİŞ****");
        System.out.print("Mail: ");
        String mail=input.next();
        System.out.print("Şifre: ");
        String password=input.next();

        for(Account a:accounts)
        {
            try
            {
                a.login(mail,password);

                if(a.isLogin())
                {
                    a.showUserInfo();
                }

            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
