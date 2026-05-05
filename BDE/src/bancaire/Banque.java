package bancaire;

import etudiant.Etudiant;

import java.util.ArrayList;

public class Banque {
    private double solde;
    private static int compteur = 0;
    private static ArrayList<Banque> listeBanque;
    private int ID;
    private ArrayList<String> historiqueDepense;

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

    public static void addBanqueToList(Banque banque){
        listeBanque.add(banque);
    }


    public void AjoutDepenseHistorique(String nomUtilisateur, String nomDestinataire, double nbMontant, String descriptionVirement){
        if (nomUtilisateur.equals(null) || nomUtilisateur.isEmpty()){
            System.out.println("Nom de l'envoyeur vide");
        } else if (nomDestinataire.equals(null) || nomDestinataire.isEmpty()){
            System.out.println("Nom du destinataire vide");
        }else if (descriptionVirement.equals(null) || descriptionVirement.isEmpty()){
            System.out.println("Description vide");
        }else if (nbMontant <= 0){
            System.out.println("Un montant ne peux pas être négatif ou vide");
        }else{
            String historique = StringDepense(nomUtilisateur, nomDestinataire, nbMontant, descriptionVirement);
            this.historiqueDepense.add(historique);
            System.out.println("Voici le résumer de l'opération effectuer : \n" + historique);
        }
    }

    public static ArrayList<Banque> listeBanque(){
        for (Banque b : listeBanque){
            System.out.println(b);
        }

    }

    public String StringDepense(String nomUtilisateur, String nomDestinataire, double nbMontant, String descriptionVirement){
        return "L'envoie d'argent du compte de : " + nomUtilisateur + " à destination du compte de : " + nomDestinataire + " d'une montant de : " + nbMontant + " à bien été effectuer avec le moditf suivant : " + descriptionVirement;
    }





}
