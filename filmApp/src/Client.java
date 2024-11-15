import java.util.ArrayList;

public class Client {

    /* attributs */
    private String nom;
    private String prenom;
    private ArrayList<Film> listeFilms = new ArrayList<>(); //contiendra la liste des films loués

    /* constructeur */
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    /* Methodes */

    //méthode pour ajouter un film à la liste des films loués
    public void addFilms(Film film){
        listeFilms.add(film);
    }
    public void showFilmList(){
        if (listeFilms.size() > 2) {
            System.out.println("Vous ne pouvez louer que 2 films à la fois");
        } else {
            System.out.println("Liste des films en location pour " + prenom + " " + nom + " :");
            //boucle pour afficher chaque film ajouté à la liste
            for (Film film : listeFilms) {
                System.out.println("- " + film.getTitre());
            }
        }

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

}
