import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    public Menu(){}

    public void MainMenu(){
        Scanner sc = new Scanner(System.in);
        int choix = -1;

        while (choix != 0){
            System.out.println("Bienvenue sur l'interface ");
            System.out.println(" 0. Quitter");
            System.out.println(" 1. Ajouter un élève");
            System.out.println(" 2. Lire la liste des élèves");
            System.out.println(" 3. Voir le solde du compte du BDE");
            System.out.println(" 4. ");

            System.out.println("Veuillez choisir votre nombre : ");


            choix = sc.nextInt();

            if (choix == 0){
                System.out.println("Au revoir !");
                break;
            }else if (choix == 1){
                String nom;
                String prenom;
                Scanner ScNom = new Scanner(System.in);
                Scanner ScPrenom = new Scanner(System.in);
                System.out.println("Veuillez renseignez son nom : ");;
                nom = ScNom.nextLine();

                System.out.println("Veuillez renseignez son prénom : ");;
                prenom = ScPrenom.nextLine();

                Etudiant etudiant = new Etudiant(nom, prenom);
                Etudiant.addEtudiantToList(etudiant);
            }else if (choix == 2){
                for (Etudiant e : Etudiant.getListeEtudiant()){
                    System.out.println("\nID : " + e.getID() + "\nNom : " + e.getNom() + "\nPrénom : " + e.getPrenom() + "\n\n");
                }
            }
        }
        sc.close();
    }

    public void createStudent(String nom, String prenom){
        Etudiant etudiant = new Etudiant(nom, prenom);
        System.out.println("Etudiant créer");
    }
}
