package menu;
import java.util.ArrayList;
import java.util.Scanner;

// import des ressourecs java
import bancaire.Banque;
import etudiant.Etudiant;

public class Menu {
    MenuTriage menuTri = new MenuTriage();
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
            System.out.println(" 4. Modifier le compte d'un user");
            System.out.println(" 5. Voir le solde d'un user");
            System.out.println(" 6. Ajouter un solde à un compte");
            System.out.println(" 7. Ajouter une dépense au solde d'un compte");

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
                menuTri.MenuDeTriage();
            }else if (choix == 3){
                System.out.println("test");
            }else if (choix == 4){
                int searchId;
                double newsolde;
                System.out.println(" Veuillez renseignez l'ID de la banque : ");
                Scanner scId = new Scanner(System.in);
                searchId = scId.nextInt();

                System.out.println("Veuillez renseignez le montant à déposer : ");
                Scanner scSolde = new Scanner(System.in);
                newsolde = scSolde.nextDouble();

                ModifCompteUtilisateur(searchId, newsolde);
            }else if (choix == 5){

                int searchId;
                System.out.println("Veuillez renseignez l'ID du compte");
                Scanner scId = new Scanner(System.in);
                searchId = scId.nextInt();
                getSoldeUser(searchId);
            }else if (choix == 6){
                double newSolde;
                Scanner nbSolde = new Scanner(System.in);
                newSolde = nbSolde.nextDouble();
            }
        }
        System.out.println("Aurevoir mon chef!");
        sc.close();
    }

    public void ModifCompteUtilisateur(int ID, double newSolde){
        ArrayList<Etudiant> listeEtudiant = Etudiant.getListeEtudiant();

        for (Etudiant e : listeEtudiant){
            int recherche = e.getID();
            if (recherche == ID){
                e.getCompte().setSolde(newSolde);
            }
        }
    }

    public void getSoldeUser(int ID){
        ArrayList<Etudiant> listeEtudiant = Etudiant.getListeEtudiant();

        for (Etudiant e : listeEtudiant){
            int recherche = e.getID();
            if (recherche == ID){
                System.out.println("Solde sur le compte de : " + e.getNom() + " Solde : " + e.getCompte().getSolde());
            }
        }
    }




    public void createStudent(String nom, String prenom){
        Etudiant etudiant = new Etudiant(nom, prenom);
        System.out.println("Etudiant créer");
    }
}
