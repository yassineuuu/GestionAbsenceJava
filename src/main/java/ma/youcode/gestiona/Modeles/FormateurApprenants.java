package ma.youcode.gestiona.Modeles;

public class FormateurApprenants extends Utilisateur{
    private int id_apprenant;
    private String nom_apprenant;
    private String prenom_apprenant;
    private int id_formateur;
    private String classe;
    private String promotion;

//    Constructeur


    public FormateurApprenants(String userName, String pwd, String Role, int id_apprenant, String nom_apprenant, String prenom_apprenant, int id_formateur, String classe, String promotion) {
        super(userName, pwd, Role);
        this.id_apprenant = id_apprenant;
        this.nom_apprenant = nom_apprenant;
        this.prenom_apprenant = prenom_apprenant;
        this.id_formateur = id_formateur;
        this.classe = classe;
        this.promotion = promotion;
    }

    public FormateurApprenants(String nom_apprenant, String prenom_apprenant, int id_formateur, String classe, String promotion) {
        this.nom_apprenant = nom_apprenant;
        this.prenom_apprenant = prenom_apprenant;
        this.id_formateur = id_formateur;
        this.classe = classe;
        this.promotion = promotion;
    }

    public FormateurApprenants(String userName, String pwd, String type, int id_apprenant, String nom_apprenant, String prenom_apprenant, int id_formateur) {
        super(userName, pwd, type);
        this.id_apprenant = id_apprenant;
        this.nom_apprenant = nom_apprenant;
        this.prenom_apprenant = prenom_apprenant;
        this.id_formateur = id_formateur;
    }

    public int getId_apprenant() {
        return id_apprenant;
    }

    public void setId_apprenant(int id_apprenant) {
        this.id_apprenant = id_apprenant;
    }

    public String getNom_apprenant() {
        return nom_apprenant;
    }

    public void setNom_apprenant(String nom_apprenant) {
        this.nom_apprenant = nom_apprenant;
    }

    public String getPrenom_apprenant() {
        return prenom_apprenant;
    }

    public void setPrenom_apprenant(String prenom_apprenant) {
        this.prenom_apprenant = prenom_apprenant;
    }

    public int getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(int id_formateur) {
        this.id_formateur = id_formateur;
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
