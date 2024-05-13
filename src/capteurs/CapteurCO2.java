package capteurs;
import controleur.Observateur;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class CapteurCO2 extends Capteur {
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
        System.out.print("Entrez le niveau de CO2 en ppm : ");
        double co2 = scanner.nextDouble();
        setValeur(co2);
        for (Observateur observateur : observateurs) {
            observateur.actualiser(getValeur(),co2);
        }
    }
}
