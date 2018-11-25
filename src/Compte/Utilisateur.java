package Compte;

import java.util.HashSet;
import java.util.Set;

public class Utilisateur {
    private final String nom;//un id n'est pas primordial dans ce cas
    private Set<Integer> numerosCompte;

    public Utilisateur(String nom){
        this.nom=nom;
        numerosCompte=new HashSet<>();
    }
    public String getNom(){
        return nom;
    }
    public Set<Integer> getComptes(){
        return numerosCompte;
    }
    public boolean addCompte(int i){
        return this.numerosCompte.add(i);
    }
}
