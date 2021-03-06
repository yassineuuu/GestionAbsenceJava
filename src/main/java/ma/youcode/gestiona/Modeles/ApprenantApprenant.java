package ma.youcode.gestiona.Modeles;

import java.sql.Date;

public class ApprenantApprenant extends Utilisateur {


    private Date date;
    private int idApprenant;
    private String classe;
    private String promotion;
    private String absence;
    private String justifier;
    private int id_formateur;

//    Constructeur


    public ApprenantApprenant(int idApprenant, int id, String nom, String prenom, int id_formateur, String classe, String promotion) {
        super(id, nom, prenom);
        this.idApprenant = idApprenant;
        this.classe = classe;
        this.promotion = promotion;
        this.id_formateur = id_formateur;
    }

    public ApprenantApprenant(int id, Date date, int idapprenant, String nom, String prenom, String classe, String promotion, String absence, String justifier) {
        super(id, nom, prenom);
        this.date = date;
        this.idApprenant = idApprenant;
        this.classe = classe;
        this.promotion = promotion;
        this.absence = absence;
        this.justifier = justifier;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(int id_formateur) {
        this.id_formateur = id_formateur;
    }
}
