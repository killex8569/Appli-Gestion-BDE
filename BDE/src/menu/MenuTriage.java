package menu;

import etudiant.Etudiant;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuTriage {
    Tri tri = new Tri();

    public void MenuDeTriage(){

        Scanner sc = new Scanner(System.in);
        int choix = -1;

        while (choix != 0){
            System.out.println("Bienvenue sur l'interface ");
            System.out.println(" 0. Quitter");
            System.out.println(" 1. Afficher la liste des élèves");
            System.out.println(" 2. Trier par Nom (Ordre alphabétique)");
            System.out.println(" 3. Tirer par ID (croissant)");
            System.out.println(" 4. Trier par ID (décroissant)");
            System.out.println(" 5. Trier par Pays (Alphabétique)");

            System.out.println("Veuillez choisir votre nombre : ");
            choix = sc.nextInt();


            if (choix == 0){
                System.out.println("Retour au menu principal");
            }else if (choix == 1){
                for (Etudiant e : Etudiant.getListeEtudiant()){
                    System.out.println("\nID : " + e.getID() + "\nNom : " + e.getNom() + "\nPrénom : " + e.getPrenom() + "\n\n");
                }
            }else if (choix == 2){
                tri.triParNom();
            }else if (choix == 3){
                ArrayList<Etudiant> liste = Etudiant.getListeEtudiant();
                for (int i = 0; i < liste.size() - 1; i++){
                    for (int j = 0; j < liste.size() - 1 - i; j++){
                        if (liste.get(j).getID() > liste.get(j + 1).getID()){
                            Etudiant temp = liste.get(j);
                            liste.set(j, liste.get(j + 1));
                            liste.set(j + 1, temp);
                        }
                    }
                }
                for (Etudiant e2 : liste){
                    System.out.println("ID : " + e2.getID() + " Nom : " + e2.getNom() + " Prenom : " + e2.getPrenom() + "\n");
                }
            }
        }

    }

}
