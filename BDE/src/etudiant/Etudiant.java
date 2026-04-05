package etudiant;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Period;


import bancaire.Banque;
import model.Origine;

public class Etudiant {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private Origine origine;
    private static int compteur;
    private int ID;
    private static ArrayList<Etudiant> listeEtudiant = new ArrayList<>();
    private Banque compte;
    private boolean isBde = false;
    private String mail;


    public Etudiant(){
        this.ID = ++compteur;
        this.compte = new Banque();
    }

    public Etudiant(String nom, String prenom){
        this();
        this.nom = nom;
        this.prenom = prenom;
    }

    public Etudiant(String nom, String prenom, LocalDate dateNaissance, Origine origine){
        this(nom, prenom);
        this.dateNaissance = dateNaissance;
        this.origine = origine;
    }


    // Getter
    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public int getAge(){
        return Period.between(dateNaissance, LocalDate.now()).getYears();
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

    public boolean getIsBde(){
        return isBde;
    }

    public String getMail(){
        return this.mail;
    }

    // Setter


    public void setNom(String Newnom){
        if (!(Newnom == null || Newnom.equals(""))){
            System.out.println("Le nom ne peux pas être vide!");
        }else {
            this.nom = Newnom;
        }
    }

    public void setPrenom(String Newprenom){
        this.prenom = Newprenom;
    }

    public void setDateNaissance(int jour, int mois, int annee) {
        LocalDate date = LocalDate.of(annee, mois, jour);

        if (date.isAfter(LocalDate.now())) {
            System.out.println("La date ne peut pas être dans le futur !");
        } else {
            this.dateNaissance = date;
        }
    }


    public void setOrigine(Origine NewOrigine){
        this.origine = NewOrigine;
    }

    public int compareTo(Etudiant autre) {
        return this.nom.compareTo(autre.nom);
    }

    public void setBde(boolean isBde){
        this.isBde = isBde;
    }

    public void setMail(String mail){
        this.mail = mail;
    }


    // Méthode
    public static void addEtudiantToList(Etudiant etudiant){
        listeEtudiant.add(etudiant);
    }

    public boolean dossierEtudiantComplet(Etudiant etudiant){
        if (etudiant.getNom() != null || etudiant.getPrenom() != null || etudiant.getAge() > 10 || etudiant.getID() > 0){
            return true;
        }else{
            return false;
        }
    }



}
