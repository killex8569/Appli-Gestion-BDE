package bancaire;

public class Banque {
    private double solde;
    private static int compteur = 0;
    private int ID;

    public Banque(){
        this.ID = ++compteur;
        this.solde = 0;
    }

    public double getSolde(){
        return this.solde;
    }
    public int getID(){
        return this.ID;
    }

    // Setter
    public void setSolde(double Newsolde){
        this.solde = Newsolde;
    }



}
