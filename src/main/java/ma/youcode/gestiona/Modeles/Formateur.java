package ma.youcode.gestiona.Modeles;

public class Formateur extends Utilisateur{


    private int idFormateur;
    private String classe;
    private String promotion;

    public Formateur(int id, String userName, String nom, String prenom, String pwd, String role, int idFormateur, String classe, String promotion) {
        super(id, userName, nom, prenom, pwd, role);
        this.idFormateur = idFormateur;
        this.classe = classe;
        this.promotion = promotion;
    }

    public int getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
}
