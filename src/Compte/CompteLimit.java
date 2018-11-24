package Compte;

public abstract class CompteLimit implements ICompte  {
    private final double depot;

    public CompteLimit(double depot){
        this.depot=depot;
    }
}
