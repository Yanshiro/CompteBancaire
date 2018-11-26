package Exception;

import Compte.ICompte;

public class ClotureException extends RuntimeException {
    private ICompte compte;
    public ClotureException(){}
    public ClotureException(String message){
        super(message);
    }
    public ClotureException(String message, ICompte compte){
        super(message);
        this.compte = compte;
    }
    public ICompte getCompte(){
        return this.compte;
    }
}
