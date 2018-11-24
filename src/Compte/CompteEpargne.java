package Compte;

public final class CompteEpargne extends CompteLimit {
    private final double minimumCredit;
    private final double versementMinimal;
    private int numero;
    private String nom;
    private double tauxRemuneration;
    private double depot;
    private double soldes;

    public CompteEpargne(String nom,int numero,double minimumCredit,double versementMinimal,double tauxRemuneration,double depot){
        super(depot);
        this.nom=nom;
        this.numero=numero;
        this.minimumCredit=minimumCredit;
        this.versementMinimal=versementMinimal;
        this.tauxRemuneration=tauxRemuneration;
        this.soldes = depot;

    }
    public void setTaux(double taux){
        this.tauxRemuneration = taux;
    }

    @Override
    public void debiter(double montant){
        if(soldes -montant<0){
            throw new DecouvertException("Découvert");
        }
        if(soldes-montant<versementMinimal){
            throw new SoldeMinimalException("Solde minimal");
        }
        else{
            soldes-=montant;
        }
    }

    @Override
    public void crediter(double montant) {
        soldes+=montant;
    }

    @Override
    public void virement(ICompte compte, double montant) {
        this.debiter(montant);
        compte.crediter(montant);
    }


    @Override
    public double interet() {
        return 0;
    }

    @Override
    public void afficherSolde() {
        System.out.println("Soldes " +soldes);
    }


}
