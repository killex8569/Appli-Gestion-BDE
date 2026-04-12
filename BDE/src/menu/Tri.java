package menu;

import etudiant.Etudiant;

import java.util.ArrayList;

public class Tri {

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

    // Ajouter le tri par ID (croissant et déscroissant)

    // Ajouter le tri par solde (Croissant et décroissant)

    // Ajouter le tri par mail (Alphabétique et inversement de l'ordre alphabétique)

    //
}
