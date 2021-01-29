package ma.youcode.gestiona.Modeles;


public class ClasseAbsence {
    private int id_absence;
    private String nom;
    private String prenom;
    private String type_absence;
    private String date_absence;

    //Constructor

    public ClasseAbsence(String nom, String prenom, String type_absence, String date_absence) {

        this.nom = nom;
        this.prenom = prenom;
        this.type_absence = type_absence;
        this.date_absence = date_absence;
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
}
