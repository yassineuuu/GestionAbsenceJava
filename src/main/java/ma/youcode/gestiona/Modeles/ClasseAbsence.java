package ma.youcode.gestiona.Modeles;


public class ClasseAbsence {
    private int id_absence;
    private int id_user;
    private String nom;
    private String prenom;
    private String type_absence;
    private String date_absence;
    private String classe;
    private String promotion;
    private String justif;
    private int id_formateur;


    public ClasseAbsence(int id_user, String nom, String prenom, String classe, String promotion, String type_absence, String date_absence, int id_formateur) {
        this.id_user = id_user;
        this.nom = nom;
        this.prenom = prenom;
        this.type_absence = type_absence;
        this.date_absence = date_absence;
        this.classe = classe;
        this.promotion = promotion;
        this.id_formateur = id_formateur;
    }

    public ClasseAbsence(int id_absence, String nom, String prenom, String type_absence, String date_absence, String classe, String promotion) {
        this.id_absence = id_absence;
        this.nom = nom;
        this.prenom = prenom;
        this.type_absence = type_absence;
        this.date_absence = date_absence;
        this.classe = classe;
        this.promotion = promotion;
    }
    public ClasseAbsence(String nom, String prenom, String classe, String promotion,String type_absence, String date_absence) {
        this.nom = nom;
        this.prenom = prenom;
        this.type_absence = type_absence;
        this.date_absence = date_absence;
        this.classe = classe;
        this.promotion = promotion;
    }


    //Constructor

    public ClasseAbsence(String nom, String prenom, String type_absence, String date_absence) {

        this.nom = nom;
        this.prenom = prenom;
        this.type_absence = type_absence;
        this.date_absence = date_absence;
    }

    public ClasseAbsence(int id_absence,String prenom, String nom, String classe, String promotion, String absence, String date, String justifier) {
        this.id_absence=id_absence;
        this.prenom=prenom;
        this.nom=nom;
        this.classe=classe;
        this.promotion=promotion;
        this.type_absence = absence;
        this.date_absence=date;
        this.justif=justifier;
    }


    //Getters and Setters

    public int getId_absence() {
        return id_absence;
    }

    public void setId_absence(int id_absence) {
        this.id_absence = id_absence;
    }


    public String getType_absence() {
        return type_absence;
    }

    public void setType_absence(String type_absence) {
        this.type_absence = type_absence;
    }

    public String getDate_absence() {
        return date_absence;
    }

    public void setDate_absence(String date_absence) {
        this.date_absence = date_absence;
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

    public String getJustif() {
        return justif;
    }

    public void setJustif(String justif) {
        this.justif = justif;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_formateur() {
        return id_formateur;
    }

    public void setId_formateur(int id_formateur) {
        this.id_formateur = id_formateur;
    }
}
