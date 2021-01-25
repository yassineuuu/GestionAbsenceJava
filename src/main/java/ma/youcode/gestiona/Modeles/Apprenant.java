package ma.youcode.gestiona.Modeles;

public class Apprenant extends Utilisateur{

    private int idApprenant;
    private String promotion;
    private String classe;

//    Constructeur

    public Apprenant(int id, String userName, String nom, String prenom, String pwd, String type) {
        super(id, userName, nom, prenom, pwd, type);
    }
}
