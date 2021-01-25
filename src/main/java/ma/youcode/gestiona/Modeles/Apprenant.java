package ma.youcode.gestiona.Modeles;

public class Apprenant extends Utilisateur {


//    Constructeur


    private int idApprenant;
    private String classe;
    private String promotion;
    private String absence;
    private String justifier;

    public Apprenant(int id, int idApprenant, String nom, String prenom, String classe, String promotion, String absence, String justifier) {
        super(id, nom, prenom);
        this.idApprenant = idApprenant;
        this.classe = classe;
        this.promotion = promotion;
        this.absence = absence;
        this.justifier = justifier;
    }


    public int getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
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

    public String getAbsence() {
        return absence;
    }

    public void setAbsence(String absence) {
        this.absence = absence;
    }

    public String getJustifier() {
        return justifier;
    }

    public void setJustifier(String justifier) {
        this.justifier = justifier;
    }
}
