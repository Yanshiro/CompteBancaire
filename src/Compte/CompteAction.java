package Compte;

public class CompteAction extends CompteNoLimite {
    private final double plafondCredit;
    private final double versementMinimal;



    public CompteAction(double plafondCredit, double versementMinimal,int numero, String nom) {
        super(versementMinimal,numero,nom);
        this.plafondCredit = plafondCredit;
        this.versementMinimal = versementMinimal;

    }

    @Override
    public void debiter(double montant) {
    if(montant!=this.getSoldes()) throw new IllegalArgumentException("Montant ponctuel");
    if(getSoldes()-montant<versementMinimal) throw new IllegalArgumentException("Versement minimal atteint");
    else{
        setSoldes(0);
        throw new ClotureException();
    }

    }

    @Override
    public void crediter(double montant) {
        if(getSoldes()+montant>plafondCredit) throw new IllegalArgumentException("Plafond crédit atteint");
        else {
            setSoldes(getSoldes()+montant);
        }
    }

    @Override
    public void virement(ICompte compte, double montant) {
    if(compte instanceof CompteCourant || compte instanceof CompteEpargne){
        this.debiter(montant);
        compte.crediter(montant);
    }
    else{
        throw new IllegalArgumentException("Unvalid compte");
    }
    }

}
