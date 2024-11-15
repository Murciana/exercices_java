public class Delta extends Coronavirus{
    public Delta(String name) {
        super(name);
    }

    @Override
    public void affiche() {
        System.out.println("L'appellation du variant est: " + name);
    }
}
