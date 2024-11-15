public class Film implements FilmsDetails{
    /* attributs */
    private String titre;
    private int sortie;
    private Realisatrice realisatrice;
    private Categorie categorie;

    /* constructeur */
    public Film(String titre, int sortie, Realisatrice realisatrice, Categorie categorie){
        this.titre = titre;
        this.sortie = sortie;
        this.realisatrice = realisatrice;
        this.categorie = categorie;
    }

    /* Methodes */
    @Override
    public void showDescription(){
        System.out.println("Le film " + this.getTitre() + "(" + this.getCategorie() + ")" + " est sorti en " + this.getSortie() +
                " et est réalisé par " + this.realisatrice.getPrenom() + " " + this.realisatrice.getNom() +" agée de " +
                this.realisatrice.getAge() +" ans (née en " + this.realisatrice.getNaissance() + ").");
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getSortie() {
        return sortie;
    }

    public void setSortie(int sortie) {
        this.sortie = sortie;
    }

    public Realisatrice getRealisatrice() {
        return realisatrice;
    }

    public void setRealisatrice(Realisatrice realisatrice) {
        this.realisatrice = realisatrice;
    }
}
