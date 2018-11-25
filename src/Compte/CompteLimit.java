package Compte;

public abstract class CompteLimit implements ICompte  {
    private final double depot;
    private double soldes;
    private final int numero;
    private final String nom;

    public CompteLimit(double soldes,int numero,String nom,double depot)
    {
        if (soldes>depot) throw new IllegalArgumentException("Dépot atteint");
        this.nom=nom;
        this.numero=numero;
        this.soldes=soldes;
        this.depot=depot;
    }

    public double getDepot() {
        return depot;
    }

    public double getSoldes() {
        return soldes;
    }

    public int getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public void setSoldes(double soldes) {
        this.soldes = soldes;
    }
}

