package ma.youcode.gestiona.Modeles;

public class Utilisateur {

//    Variables
    private int id;
    private String userName;
    private String nom;
    private String prenom;
    private String pwd;
    private String Role;


//    Constructeur

    public Utilisateur(int id, String userName, String nom, String prenom, String pwd, String Role) {
        this.id = id;
        this.userName = userName;
        this.nom = nom;
        this.prenom = prenom;
        this.pwd = pwd;
        this.Role = Role;
    }

    public Utilisateur(String userName, String pwd, String Role) {
        this.userName = userName;
        this.pwd = pwd;
        this.Role = Role;
    }

    public Utilisateur(int id, String nom, String prenom) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
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
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
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
