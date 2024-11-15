public class LocalisationDecorator implements FilmsDetails {
    private FilmsDetails film;
    private String pays;
    private String ville;

    public LocalisationDecorator(FilmsDetails film, String pays, String ville) {
        this.film = film;
        this.pays = pays;
        this.ville = ville;
    }

    @Override
    public void showDescription() {
        film.showDescription();
        System.out.println("Localisation: " + ville + ", " + pays);
    }
}