import java.util.ArrayList;
import java.util.Objects;

public abstract class Account implements Comparable<Account>
{
    public enum  AuthenticationStatus{SUCCESS,FAIL};
    private User user;
    private ArrayList<Insurance> insurances;
    private boolean isLogin;

    public Account(User user, ArrayList<Insurance> insurances) {
        this.user = user;
        this.insurances = insurances;
    }

    public final void showUserInfo()
    {
        System.out.println("\n--Müşteri Bilgileri--");
        System.out.println("İsim: "+user.getUserName()+"\nSoyisim: "+user.getUserSurname()+"\nMail: "+user.getUserMail()+"\nMeslek: "
                            +user.getUserJob()+"\nYaş: "+user.getUserAge()
                            +"\nAdres(ler): "+user.getUserAdress()+"\nSon Giriş Tarihi: "+user.getUserLastLogin());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public void setInsurances(ArrayList<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void login(String mail, String password) throws InvalidAuthenticationException {
        AuthenticationStatus status = null;
        if(user.getUserMail().equals(mail))
        {
            if(password.equals(user.getUserPassword()))
            {
                status=AuthenticationStatus.SUCCESS;

            }
            else
            {
                status = AuthenticationStatus.FAIL;

            }
        }
        else
        {
            System.out.println("Mail Adresi Hatalı!");
            status=AuthenticationStatus.FAIL;
        }
        if(AuthenticationStatus.FAIL == status)
        {
            throw new InvalidAuthenticationException();
        }
        else
        {
            System.out.println("Giriş Başarılı");
            isLogin=true;
        }
    }

    public boolean isLogin()
    {
        if(isLogin)
        {
            System.out.println("Oturum Açık");
            return true;
        }
        else
        {
            System.out.println("Oturum açık değil son giriş tarihi: "+user.getUserLastLogin());
            return false;
        }
    }

    public abstract void addInsurance();

    @Override
    public int compareTo(Account o) {
        return this.hashCode() - o.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(user);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return  true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account=(Account) obj;
        return Objects.equals(user,account.user);
    }

}

