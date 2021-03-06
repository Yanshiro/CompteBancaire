package Banque;

import Compte.*;



import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Banque implements IBanque {
    private Set<ICompte> ListCompte;


    public Banque(){
        ListCompte=new HashSet<>();
    }
    @Override
    public void cloturer(ICompte compte) {
        if(ListCompte.contains(compte)){
            ListCompte.remove(compte);
        }
    }


    @Override
    public boolean addCompte(ICompte compte) {
        return this.ListCompte.add(compte);
    }

    @Override
    public void listerCompte(Utilisateur u) {
        ListCompte.stream()
                .filter(compte -> compte.getNom()==u.getNom())
                .forEach(compte -> System.out.println("Nom détenteur :" +compte.getNom()+
                "identifiant : "+ compte.getNumero()));
    }

    @Override
    public void listerCompteetSolde(Utilisateur u) {
    ListCompte.stream()
            .filter(compte -> compte.getNom() ==u.getNom())
            .forEach(compte -> System.out.println("Nom détenteur :" +compte.getNom()+
                    "identifiant : "+ compte.getNumero() + "solde " +compte.getSoldes()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banque banque = (Banque) o;
        return Objects.equals(ListCompte, banque.ListCompte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ListCompte);
    }

}
