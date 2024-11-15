public class FilmApp {

    public static void main(String[] args) {

        Realisatrice real1 = new Realisatrice("Greta", "Gerig", 1980);
        Realisatrice real2 = new Realisatrice("Justine", "Triet", 1979);
        Realisatrice real3 = new Realisatrice("Helena", "Williams", 1968);

        Film Barbie = new Film("Barbie", 2023, real1, Categorie.fiction) ;
        Film AnatomieChute = new Film("Anatomie d'une chute", 2023, real2, Categorie.documentaire);
        Film Anon = new Film("Anon", 2003, real3, Categorie.romance);

        Barbie.showDescription();
        AnatomieChute.showDescription();
        Anon.showDescription();

        Client Mike = new Client("Dumont", "Mike");

        Mike.addFilms(Barbie);
        Mike.addFilms(Anon);
        Mike.showFilmList();
        Mike.addFilms(AnatomieChute);
        Mike.showFilmList();
    }
}