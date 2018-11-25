package Compte;

public interface ICompte {
    void debiter(double montant);
    void crediter(double montant);
    void virement(ICompte compte,double montant);
    int getNumero();
    double getSoldes();
    String getNom();

    default void afficherSolde(){
        System.out.println(getSoldes());
    }

}
