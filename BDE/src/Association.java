import bancaire.Banque;

public class Association {
    private String nom;
    private int nbMaxAdherents = 20;
    private int nbadherent;
    private Banque compte;

    // Constructeur
    public Association(){}

    public Association(String nom, int nbMaxAdherents){
        this.setNom(nom);
        this.setNbMaxAdherents(nbMaxAdherents);

    }

    // Setter
    public int getNbMaxAdherents(){
        return this.nbMaxAdherents;
    }

    public int getNbadherent(){
        return this.nbadherent;
    }

    public String getNom(){
        return this.nom;
    }

    public Banque getCompte(){
        return this.compte;
    }


    // Setter
    public void setNbMaxAdherents(int nbMaxAdherents){
        this.nbMaxAdherents = nbMaxAdherents;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setNbadherent(int nbadherent){
        this.nbadherent = nbadherent;
    }



}
