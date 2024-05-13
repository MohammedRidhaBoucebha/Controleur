package capteurs;
import controleur.Observateur;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class CapteurTemperature extends Capteur {
    private List<Observateur> observateurs = new ArrayList<>();

    public void enregistrerObservateur(Observateur observateur) {
        observateurs.add(observateur);
    }

    public void supprimerObservateur(Observateur observateur) {
        observateurs.remove(observateur);
    }
    @Override
    public void mesurer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez la température en °C : ");
        double temperature = scanner.nextDouble();
        setValeur(temperature);
        for (Observateur observateur : observateurs) {
            observateur.actualiser(getValeur(),0);
        }
    }
}
