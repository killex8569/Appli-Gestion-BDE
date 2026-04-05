package bancaire;

import java.util.ArrayList;

public class Banque {
    private double solde;
    private static int compteur = 0;
    private int ID;
    private ArrayList<String> historiqueDepense = new ArrayList<>();

    public Banque(){
        this.ID = ++compteur;
        this.solde = 0;
    }

    // Getter
    public double getSolde(){
        return this.solde;
    }
    public int getID(){
        return this.ID;
    }
    public ArrayList<String> gethistoriqueDepense(){
        return this.historiqueDepense;
    }

    // Setter
    public void setSolde(double Newsolde){
        this.solde = Newsolde;
    }

    public void addDepense(double depense){
        double newSolde = this.getSolde() - depense;
        if (verifCompte(this.getSolde(), depense)){
            this.setSolde(newSolde);
        }else{
            System.out.println("Vous n'avez pas assez de fond");
        }
    }

    public boolean verifCompte(double solde, double depense){
        if (solde - depense > 0){
            return true;
        }else{
            return false;
        }
    }





}
