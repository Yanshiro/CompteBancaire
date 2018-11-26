package Banque;

import Compte.ICompte;
import Compte.Utilisateur;

public interface IBanque {
    void cloturer(ICompte compte);
    boolean addCompte(ICompte compte);
    void listerCompte(Utilisateur u);
    void listerCompteetSolde(Utilisateur u);

}
