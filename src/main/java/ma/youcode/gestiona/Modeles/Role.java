package ma.youcode.gestiona.Modeles;

public class Role {

    private int id;
    private  String role_Nom;


    public Role( String role) {
        this.role_Nom = role;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role_Nom;
    }

    public void setRole(String role) {
        this.role_Nom = role;
    }
}
