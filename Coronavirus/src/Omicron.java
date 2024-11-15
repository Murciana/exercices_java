public class Omicron extends Coronavirus{
    public Omicron(String name) {
        super(name);
    }

    @Override
    public void affiche() {
        System.out.println("L'appellation du variant est: " + name);
    }
}


