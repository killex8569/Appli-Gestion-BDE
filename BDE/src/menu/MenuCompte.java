package menu;

import etudiant.Etudiant;

import bancaire.Banque;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuCompte {
    public void MenuDuCompte() {
        Scanner sc = new Scanner(System.in);
        int choix = -1;

        while (choix != 0) {
            System.out.println("Bienvenue sur l'interface de gestion de compte ");
            System.out.println("0. Quitter");
            System.out.println("1. Voir la liste des comptes existant");
            System.out.println("2. Visualiser un compte");
            System.out.println("3. Faire une dépense");
            System.out.println("4. Créer un compte (OOBE)");
            System.out.println("5. Créditer un compte");
            System.out.println("6. Autres");
            System.out.println("Veuillez choisir votre nombre : ");

            try {
                choix = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
                continue;
            }

            if (choix == 1) {
                voirCompte();
            }else if (choix == 2){
                Scanner scSolde = new Scanner(System.in);
                Scanner scPrenom = new Scanner(System.in);

                System.out.println("Veuillez renseignez le PRENOM du propriétaire du compte : ");
                String prenom = scPrenom.nextLine();

                System.out.println("Veuillez choisir le nouveau montant à attribuer : ");
                double solde = scSolde.nextInt();

                int IDproprietaireCompte = rechercheParPrenom(prenom);

                voirUnCompte(prenom);
            }else if (choix == 3) {
                continue;
            }else if (choix == 4){
                continue;
            }else if (choix == 5){
                Scanner scSolde = new Scanner(System.in);
                Scanner scPrenom = new Scanner(System.in);

                System.out.println("Veuillez renseignez le PRENOM du propriétaire du compte : ");
                String prenom = scPrenom.nextLine();

                System.out.println("Veuillez choisir le nouveau montant à attribuer : ");
                double solde = scSolde.nextInt();

                int IDproprietaireCompte = rechercheParPrenom(prenom);
                crediterCompte(IDproprietaireCompte, solde);

            }
        }
    }

    public int rechercheParPrenom(String prenom){
        int IDCompte = -1;
        for (Etudiant e : Etudiant.getListeEtudiant()){
            if (e.getPrenom().equals(prenom)){
                System.out.println("L'ID du compte de l'utilisateur est le : " + e.getID());
                IDCompte = e.getID();
            }
        }

        if(IDCompte == -1){
            System.out.println("Une erreur s'est produit !");
            return -1;
        }else{
            return IDCompte;
        }
    }

    public void voirCompte(){
        int index = 0;
        for (Etudiant e : Etudiant.getListeEtudiant()){
            index++;
            Banque banqueUser = e.getCompte();
            System.out.println("Compte numéro : " + index + " Solde : " + banqueUser.getSolde());
        }
    }

    public void crediterCompte(int IDCompte, double newSolde){

        for (Etudiant e : Etudiant.getListeEtudiant()){
            if (e.getID() == (IDCompte)){
                System.out.println("Le compte de l'utilisateur : " + e.getNom() + " Vasêtre créditer de : " + newSolde);
                Banque banqueUser = e.getCompte();
                banqueUser.setSolde(newSolde);
            }
        }
    }

    public Banque voirUnCompte(String prenom){
        Etudiant tmp = new Etudiant();
        for (Etudiant e : Etudiant.getListeEtudiant()){
            if (e.getPrenom().equals(prenom)){
                tmp = e;
            }
        }

        return tmp.getCompte();
    }
}
