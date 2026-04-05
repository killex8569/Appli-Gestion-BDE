package etudiant;

import java.util.ArrayList;

import bancaire.Banque;
import model.Origine;

public class Etudiant {
    private String nom;
    private String prenom;
    private int age;
    private Origine origine;
    private static int compteur;
    private int ID;
    private static ArrayList<Etudiant> listeEtudiant = new ArrayList<>();
    private Banque compte;


    public Etudiant(){

        this.ID = ++compteur;
        this.compte = new Banque();
    }

    public Etudiant(String nom, String prenom){
        this();
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant(String nom, String prenom, int age, Origine origine){
        this(nom, prenom);
        this.age = age;
        this.origine = origine;
    }
    public static void addEtudiantToList(Etudiant etudiant){
        listeEtudiant.add(etudiant);
    }

    // Getter
    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public int getAge(){
        return this.age;
    }

    public int getID(){
        return this.ID;
    }

    public Origine getOrigine(){
        return this.origine;
    }
    public static ArrayList<Etudiant> getListeEtudiant(){
        return listeEtudiant;
    }

    public Banque getCompte(){
        return this.compte;
    }

    // Setter


    public void setNom(String Newnom){
            this.nom = Newnom;
    }

    public void setPrenom(String Newprenom){
        this.prenom = Newprenom;
    }

    public void setAge(int Newage){
        this.age = Newage;
    }

    public void setOrigine(Origine NewOrigine){
        this.origine = NewOrigine;
    }

    public int compareTo(Etudiant autre) {
        return this.nom.compareTo(autre.nom);
    }

}
