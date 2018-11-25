package Compte;


public class CompteCourant extends CompteNoLimite {
    private double plancher;



    public CompteCourant(double soldes, int numero, String nom) {

        super(soldes,numero,nom);
        plancher=0;
    }

    public CompteCourant(double soldes, int numero, String nom,double plancher) {
        super(soldes,numero,nom);
        this.plancher = plancher;

    }

    public void setPlancher(double plancher){
        if(getSoldes()<0) throw new DecouvertException();
        else {
            this.plancher=plancher;
        }

    }

    @Override
    public void debiter(double montant) {
        if(getSoldes()-montant<plancher)  throw new DecouvertException("Plancher atteint");
        else{
            setSoldes(getSoldes()-montant);
        }
    }

    @Override
    public void crediter(double montant) {
        setSoldes(getSoldes()+montant);
    }

    @Override
    public void virement(ICompte compte, double montant) {
        this.debiter(montant);
        compte.crediter(montant);
    }

    }
