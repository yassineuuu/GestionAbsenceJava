package ma.youcode.gestiona.Modeles;


public class Absence {
    private int id_absence;
    private String full_name;
    private String type_absence;
    private String date_absence;

    //Constructor

    public Absence(String full_name, String type_absence, String date_absence) {
        this.full_name = full_name;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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
}
