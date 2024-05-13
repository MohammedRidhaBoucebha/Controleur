package main;

import controleur.Controleur;
import capteurs.CapteurTemperature;
import capteurs.CapteurCO2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        // Créer des instances de capteurs de température et de CO2
        CapteurTemperature capteurTemperature = new CapteurTemperature();
        CapteurCO2 capteurCO2 = new CapteurCO2();

        // Créer une instance de Contrôleur
        Controleur controleur = new Controleur(capteurTemperature,capteurCO2);

        // Enregistrer le contrôleur comme observateur auprès des capteurs
        capteurTemperature.enregistrerObservateur(controleur);
        capteurCO2.enregistrerObservateur(controleur);

        // Boucle pour mesurer les valeurs de température et de CO2 jusqu'à ce que 0 soit saisi
        Scanner scanner = new Scanner(System.in);
        double temperature;
        double co2;
        do {
            // Mesurer la température
            System.out.print("Entrez la température en °C (ou 0 pour arrêter) : ");
            temperature = scanner.nextDouble();
            if (temperature != 0) {
                controleur.actualiser(temperature, 0); // Actualiser le contrôleur avec la température actuelle
            } else {
                break; // Sortir de la boucle si 0 est saisi
            }

            // Mesurer le CO2
            System.out.print("Entrez le niveau de CO2 en ppm : ");
            co2 = scanner.nextDouble();
            controleur.actualiser(temperature, co2); // Actualiser le contrôleur avec la température actuelle et le CO2
        } while (true);
    }
}
