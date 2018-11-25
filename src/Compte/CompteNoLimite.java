package Compte;

public abstract class CompteNoLimite implements ICompte {
    private double soldes;
    private final int numero;
    private final String nom;

    public CompteNoLimite(double soldes, int numero, String nom) {
        this.soldes = soldes;
        this.numero = numero;
        this.nom = nom;
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
