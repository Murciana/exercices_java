public class Main {
    public static void main(String[] args) {

        Add addition = new Add();
        Subtract soustraction = new Subtract();
        Multiply multiplication = new Multiply();
        Divide division = new Divide();

        addition.Execute(2,4);
        soustraction.Execute(2,4);
        multiplication.Execute(2,4);
        division.Execute(2,4);

        System.out.println("Le résultat de l'addition est: " + addition.Result);
        System.out.println("Le résultat de la soustraction est: " + soustraction.Result);
        System.out.println("Le résultat de la multiplication est: " + multiplication.Result);
        System.out.println("Le résultat de la division est: " + division.Result) ;
    }
}