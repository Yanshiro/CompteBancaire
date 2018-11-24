package Compte;

public interface ICompte {
    void debiter(double montant);
    void crediter(double montant);
    void virement(ICompte compte,double montant);
    double interet();
    void afficherSolde();
}
