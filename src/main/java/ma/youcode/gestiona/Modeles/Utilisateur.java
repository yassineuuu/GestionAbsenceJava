package ma.youcode.gestiona.Modeles;

public class Utilisateur {

//    Variables
    private int id;
    private String userName;
    private String nom;
    private String prenom;
    private String pwd;
    private String role;


//    Constructeur

    public Utilisateur(int id, String userName,String nom, String prenom, String pwd, String type) {
        this.id = id;
        this.userName = userName;
        this.nom = nom;
        this.prenom = prenom;
        this.pwd = pwd;
        this.role = type;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
//    Autre Methodes


}
