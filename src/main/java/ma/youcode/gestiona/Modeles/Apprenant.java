package ma.youcode.gestiona.Modeles;

public class Apprenant extends Utilisateur{
    private int id;
    private String username;
    private String classe;
    private String promo;
    private String absence;
    private String justifier;

//    Constructeur


    public Apprenant(String userName, String pwd, String type, int id, String username, String classe, String promo, String absence, String justifier) {
        super(userName, pwd, type);
        this.id = id;
        this.username = username;
        this.classe = classe;
        this.promo = promo;
        this.absence = absence;
        this.justifier = justifier;
    }

    public Apprenant(String userName, String pwd, String type, int id, String username, String classe, String promo, String absence) {
        super(userName, pwd, type);
        this.id = id;
        this.username = username;
        this.classe = classe;
        this.promo = promo;
        this.absence = absence;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
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
