package capteurs;

import java.util.Scanner;


//Classe abstraite pour les capteurs
abstract class Capteur {

    private double valeur;

    //Methode utilisee pour mesurer la valeur du capteur
    abstract void mesurer();

    // Méthode pour obtenir la valeur mesurée
    double getValeur() {
        return valeur;
    }

    // Méthode pour définir la valeur mesurée
    void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
