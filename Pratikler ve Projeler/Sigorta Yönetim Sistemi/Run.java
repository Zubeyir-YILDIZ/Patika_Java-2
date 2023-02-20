import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Run
{
    static Scanner input=new Scanner(System.in);
    public static void run()
    {
        TreeSet<Account> accounts=new TreeSet<>();
        while (true)
        {


            System.out.println("1-Kayıt Ol\n2-Giriş Yap\n3-Çıkış ");
            int key=input.nextInt();
            if(key==1)
            {
                System.out.println("1-Kurum\n2-Kişi");
                int key3=input.nextInt();
                System.out.print("İsim: ");
                String userName=input.next();
                System.out.print("Soyisim: ");
                String userSurname=input.next();
                System.out.print("Mail: ");
                String userMail=input.next();
                System.out.print("Şifre: ");
                String userPassword=input.next();
                System.out.println("Meslek: ");
                String userJob=input.next();
                System.out.println("Yaş: ");
                int userAge=input.nextInt();
                System.out.println("1-Ev Adresi\n2-İş Adresi");
                int key2=input.nextInt();
                ArrayList<Address> addresses=new ArrayList<>();
                if(key2==1)
                {
                    System.out.print("Adres: ");
                    String address=input.next();
                    HomeAddress address1=new HomeAddress(address);
                    addresses.add(address1);
                }
                else if(key2==2)
                {
                    System.out.print("Adres: ");
                    String address=input.next();
                    BusinessAddress address1=new BusinessAddress(address);
                    addresses.add(address1);
                }
                else
                {
                    HomeAddress address1=new HomeAddress(" ");
                    addresses.add(address1);
                }
                User user=new User(userName,userSurname,userMail,userPassword,userJob,userAge,addresses,null);
                if(key3==1)
                {
                    System.out.print("Kurum Adı: ");
                    String enterpriseName=input.next();
                    Enterprise enterprise=new Enterprise(user,null,enterpriseName);
                    accounts.add(enterprise);
                }
                else
                {
                    Individual person=new Individual(user,null);
                    accounts.add(person);
                }

            }
            else if (key==2)
            {
                AccountManager mngr1=new AccountManager();
                mngr1.setAccounts(accounts);
                mngr1.login();
            }
            else
                break;
        }


    }
}
