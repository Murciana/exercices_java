public class Beta extends Coronavirus{
    public Beta(String name) {
        super(name);
    }

    @Override
    public void affiche() {
        System.out.println("L'appellation du variant est: " + name);
    }
}
