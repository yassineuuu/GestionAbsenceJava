package ma.youcode.gestiona.Modeles;

public class Formateur extends Utilisateur{
    private int id_formateur;
    private String nom_formateur;
    private String prenom_formateur;
    private String classe;
    private String promotion;

// constructeur


    public Formateur(String userName, String pwd, String type, int id_formateur, String nom_formateur, String prenom_formateur, String classe, String promotion) {
        super(userName, pwd, type);
        this.id_formateur = id_formateur;
        this.nom_formateur = nom_formateur;
        this.prenom_formateur = prenom_formateur;
        this.classe = classe;
        this.promotion = promotion;
    }

    public Formateur(String nom_formateur, String prenom_formateur, String classe, String promotion) {
        this.nom_formateur = nom_formateur;
        this.prenom_formateur = prenom_formateur;
        this.classe = classe;
        this.promotion = promotion;
    }

    public Formateur(int id, String userName, String nom, String prenom, String pwd, String Role, int id_formateur, String nom_formateur, String prenom_formateur, String classe, String promotion) {
        super(id, userName, nom, prenom, pwd, Role);
        this.id_formateur = id_formateur;
        this.nom_formateur = nom_formateur;
        this.prenom_formateur = prenom_formateur;
        this.classe = classe;
        this.promotion = promotion;
    }

    public Formateur(int id_formateur, String nom_formateur, String prenom_formateur, String classe, String promotion) {
        this.id_formateur = id_formateur;
        this.nom_formateur = nom_formateur;
        this.prenom_formateur = prenom_formateur;
        this.classe = classe;
        this.promotion = promotion;
    }

    public int getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(int id_formateur) {
        this.id_formateur = id_formateur;
    }

    public String getNom_formateur() {
        return nom_formateur;
    }

    public void setNom_formateur(String nom_formateur) {
        this.nom_formateur = nom_formateur;
    }

    public String getPrenom_formateur() {
        return prenom_formateur;
    }

    public void setPrenom_formateur(String prenon_formateur) {
        this.prenom_formateur = prenon_formateur;
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




