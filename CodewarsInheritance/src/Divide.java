public class Divide extends Operation{
    @Override
    public void Execute(double variable1, double variable2) {
        if (variable2 != 0) {
            Result = variable1 / variable2;  // Division
        } else {
            System.out.println("Erreur: Division par zéro!");
            Result = 0;  // Option de gestion d'erreur pour éviter la division par zéro
        }
    }
}
