package AbdulMalikKarimAJmartMR;


/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;

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