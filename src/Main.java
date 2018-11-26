import Banque.Banque;
import Compte.*;
import Exception.*;
public class Main {

    public static void main(String[] args) {
        Banque banque = new Banque();
        Utilisateur u = new Utilisateur("Mr A");
        try{
            ICompte compte = new CompteCourant(20,3,"Mr A");
            u.addCompte(3);
            ICompte compte2 = new CompteEpargne(50,"Mr A",2,20,20,2.4,200);
            u.addCompte(2);
            ICompte compte3 = new CompteAction(30,20,1,"Mr A");
            u.addCompte(1);
            banque.addCompte(compte);
            banque.addCompte(compte2);
            banque.addCompte(compte3);
            banque.listerCompteetSolde(u);
        }catch (IllegalArgumentException | DecouvertException e){
            System.out.println(e.getMessage());

        }catch (ClotureException e){
            banque.cloturer(e.getCompte());
        }

    }
}

