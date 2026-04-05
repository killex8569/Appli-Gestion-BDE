package menu;
import java.util.ArrayList;
import java.util.Scanner;

// import des ressourecs java
import bancaire.Banque;
import etudiant.Etudiant;

public class Menu {
    MenuTriage menuTri = new MenuTriage();
    public Menu(){}

    public void MainMenu() {
        Scanner sc = new Scanner(System.in);
        int choix = -1;

        while (choix != 0) {
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

            try {
                choix = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Veuillez entrer un nombre valide.");
                continue;
            }

            if (choix == 1) {
                System.out.println("Veuillez renseigner son nom : ");
                String nom = sc.nextLine();

                System.out.println("Veuillez renseigner son prénom : ");
                String prenom = sc.nextLine();

                Etudiant etudiant = new Etudiant(nom, prenom);
                Etudiant.addEtudiantToList(etudiant);

            } else if (choix == 2) {
                menuTri.MenuDeTriage();

            } else if (choix == 3) {
                System.out.println("test");


            } else if (choix == 4) {
                System.out.println("Veuillez renseigner l'ID de la banque : ");
                try {
                    int searchId = Integer.parseInt(sc.nextLine());
                    System.out.println("Veuillez renseigner le montant à déposer : ");
                    double newSolde = Double.parseDouble(sc.nextLine());
                    ModifCompteUtilisateur(searchId, newSolde);
                } catch (NumberFormatException e) {
                    System.out.println("Valeur invalide, retour au menu.");
                }

            } else if (choix == 5) {
                System.out.println("Veuillez renseigner l'ID du compte : ");
                try {
                    int searchId = Integer.parseInt(sc.nextLine());
                    getSoldeUser(searchId);
                } catch (NumberFormatException e) {
                    System.out.println("ID invalide, retour au menu.");
                }

            } else if (choix == 6) {
                System.out.println("Veuillez renseigner le solde à ajouter : ");
                try {
                    double newSolde = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Montant invalide, retour au menu.");
                }

            } else if (choix != 7) {

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
