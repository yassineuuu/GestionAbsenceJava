package ma.youcode.gestiona.Modeles;

public class Formateur extends Utilisateur{

    private int idFormateur;
    private String promotion;
    private String classe;


//    Constructeur

    public Formateur(int id, String userName, String nom, String prenom, String pwd, String type) {
        super(id, userName, nom, prenom, pwd, type);
    }
}
