import java.time.Year;

public class Realisatrice {

    /* attributs */
    private String prenom;
    private String nom;
    private int naissance;
    private int age;

    /* constructeur */
    public Realisatrice(String prenom, String nom, int naissance){
        this.prenom = prenom;
        this.nom = nom;
        this.naissance = naissance;
        this.age = calculateAge(); //pas besoin de passer l'année de naissance en argument
    }

    /* Methodes */
    public int calculateAge(){
        int currentYear = Year.now().getValue(); // méthode qui récupère l'année actuelle
        return currentYear - this.naissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNaissance() {
        return naissance;
    }

    public void setNaissance(int naissance) {
        this.naissance = naissance;
    }
}
