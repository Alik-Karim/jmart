package AbdulMalikKarimAJmartMR;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^(?!\\.)(?!.*?\\.\\.)[a-zA-Z0-9&_*~.]+@(?!\\-)[a-zA-Z0-9-]+.(?!.*\\.$)[a-zA-Z0-9.]+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d](\\S){8,}$";
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public String toString(){
        return
        "Name : "+this.name+
        "\nemail : "+this.email+
        "\npassword : "+this.password;
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher2 = pattern2.matcher(password);

        if (matcher.find() == true && matcher2.find()==true){
            return true;
        }else {
            return false;
        }
    }
    
    @Override
    public boolean read(String content){
        return false;
    }

    @Override
    public Object write(){
        return null;
    }

    public static Object newInstance(String content) {
        return null;
    }
}
