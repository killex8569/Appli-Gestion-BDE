package menu;
import java.util.ArrayList;
import java.util.Scanner;

// import des ressourecs java
import etudiant.Etudiant;

public class Menu {
    public Menu(){}

    public void MainMenu(){
        Scanner sc = new Scanner(System.in);
        int choix = -1;

        while (choix != 0){
            System.out.println("Bienvenue sur l'interface ");
            System.out.println(" 0. Quitter");
            System.out.println(" 1. Ajouter un élève");
            System.out.println(" 2. Triage (Menu)");
            System.out.println(" 3. Voir le solde du compte du BDE");
            System.out.println(" 4. ");

            System.out.println("Veuillez choisir votre nombre : ");

            choix = sc.nextInt();

            if (choix == 1){
                String nom;
                String prenom;
                Scanner ScNom = new Scanner(System.in);
                Scanner ScPrenom = new Scanner(System.in);
                System.out.println("Veuillez renseignez son nom : ");
                nom = ScNom.nextLine();

                System.out.println("Veuillez renseignez son prénom : ");;
                prenom = ScPrenom.nextLine();

                Etudiant etudiant = new Etudiant(nom, prenom);
                Etudiant.addEtudiantToList(etudiant);
            }else if (choix == 2){
                this.MenuTriage();
            }else if (choix == 3){
                System.out.println("test");
            }
        }
        System.out.println("Aurevoir mon chef!");
        sc.close();
    }


    public void MenuTriage(){

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
            triParNom();
        }else if (choix == 3){

        }


        }

    }

    public ArrayList<Etudiant> triParNom(){
        // Utilisation de compareTo
        int index = 0;
        ArrayList<Etudiant> liste = Etudiant.getListeEtudiant();
        for (int i = 0; i<liste.size() - 1; i++){
            for (int j = 0; j<liste.size() - 1 - i; j++){
                if (liste.get(j).compareTo(liste.get(j + 1)) > 0){
                    Etudiant temp = liste.get(j);
                    liste.set(j, liste.get(j + 1));
                    liste.set(j + 1, temp);
                }
            }
        }
        for (Etudiant e : liste){
            System.out.println((e.getNom()));
        }
        return liste;
    }

    public void createStudent(String nom, String prenom){
        Etudiant etudiant = new Etudiant(nom, prenom);
        System.out.println("Etudiant créer");
    }
}
