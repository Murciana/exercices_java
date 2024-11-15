public class Alpha extends Coronavirus {
    public Alpha(String name) {
        super(name);
    }

    @Override
    public void affiche() {
        System.out.println("L'appellation du variant est: " + name);
    }
}
