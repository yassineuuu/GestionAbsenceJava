package ma.youcode.gestiona.Modeles;

public class Utilisateur {

//    Variables
    private int id;
    private String userName;
    private String pwd;
    private String type;


//    Constructeur

    public Utilisateur(String userName,String pwd, String type) {
        this.userName = userName;
        this.pwd = pwd;
        this.type = type;
    }


//    Getters/Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


//    Autre Methodes


}
