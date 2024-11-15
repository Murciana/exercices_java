public class Gamma extends Coronavirus {
    public Gamma(String name) {
        super(name);
    }

    @Override
    public void affiche() {
        System.out.println("L'appellation du variant est: " + name);
    }
}


