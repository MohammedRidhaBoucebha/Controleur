package controleur;
import capteurs.CapteurCO2;
import capteurs.CapteurTemperature;

public class Controleur implements Observateur {
    private final double TEMPERATURE_CIBLE = 22.0;
    private final double CONCENTRATION_CO2 = 1000.0;

    private CapteurTemperature capteurTemperature;
    private CapteurCO2 capteurCO2;

    public Controleur(CapteurTemperature capteurTemperature, CapteurCO2 capteurCO2) {
        this.capteurTemperature = capteurTemperature;
        this.capteurCO2 = capteurCO2;

        // Enregistre le contrôleur comme observateur auprès des capteurs
        this.capteurTemperature.enregistrerObservateur(this);
        this.capteurCO2.enregistrerObservateur(this);
    }
    public void actualiser(double temperature, double co2) {
        System.out.printf("Controleur: nouvelle valeur reçue: mesure de température = %.2f°C%n", temperature);
        if (temperature > TEMPERATURE_CIBLE) {
            System.out.println("Controleur: Climatisation démarrée.");
        } else if (temperature < TEMPERATURE_CIBLE) {
            System.out.println("Controleur: Chauffage démarrée.");
        } else {
            System.out.println("Controleur: Température optimale.");
        }

        System.out.printf("Controleur: nouvelle valeur reçue: mesure de CO2 = %.2fppm%n", co2);
        if (co2 > CONCENTRATION_CO2) {
            System.out.println("Controleur: Ventilation démarrée");
        }
    }
}
