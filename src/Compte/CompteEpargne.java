package Compte;
import Exception.*;
public final class CompteEpargne extends CompteLimit {
    private final double minimumCredit;
    private final double versementMinimal;
    private double tauxRemuneration;

    public CompteEpargne(double soldes,String nom,int numero,double minimumCredit,double versementMinimal
            ,double tauxRemuneration,double depot)throws IllegalArgumentException{
        super(soldes,numero,nom,depot);
        if(soldes<versementMinimal){
            throw new IllegalArgumentException("soldes insuffisant");
        }
        else{
            this.minimumCredit=minimumCredit;
            this.versementMinimal=versementMinimal;
            this.tauxRemuneration=tauxRemuneration;
        }
    }
    public void setTaux(double taux){
        this.tauxRemuneration = taux;
    }

    @Override
    public void debiter(double montant){
        if(getSoldes()-montant<0){
            throw new DecouvertException("Découvert");
        }
        if(getSoldes()-montant<versementMinimal){
            throw new ClotureException("Solde minimal", this);
        }
        else{
            setSoldes(getSoldes()-montant);
        }
    }

    @Override
    public void crediter(double montant) throws IllegalArgumentException {
        if(montant<minimumCredit){
            throw new IllegalArgumentException("Versement insuffisant");
        }
        if(montant>getDepot()){
            throw new IllegalArgumentException("Plafond de depot atteint");
        }
        else {
            setSoldes(getSoldes()+montant);
        }
    }

    @Override
    public void virement(ICompte compte, double montant) {
        this.debiter(montant);
        compte.crediter(montant);
    }

    public double interet() {
        //TO DO
        return 0;
    }


}
