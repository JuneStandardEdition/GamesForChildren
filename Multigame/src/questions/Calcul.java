package questions;

import gui.MathsQuestionsGUI;
import java.util.Random;
import static settings.Settings.DIFFICULTE_1;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 09-03-2020.9:33
 *
 *************************************************
 */
public class Calcul extends MathsQuestionsGUI {

    Integer nb1;
    Integer nb2;
    Integer result;
    String signe;

    public Calcul(String title) {
        super(title);
    }
    
    public Calcul(Integer nb1, Integer nb2, Integer resultat, String signe){
        super("Calcul");
        this.nb1 = nb1;
        this.nb2 = nb2;
        this.result = resultat;
        this.signe = signe;
    }

    // Génération du nombre 1 selon la difficulté
    public int genererNb1() {
        int i;
        Random rd = new Random();
        if (DIFFICULTE_1) {
            i = rd.nextInt(10);
        } else {
            i = rd.nextInt(1000);
        }
        return i;
    }

    // Génération du nombre 2 selon la difficulté
    public int genererNb2() {
        int i;
        Random rd = new Random();
        if (DIFFICULTE_1) {
            do {
                i = rd.nextInt(9);
            } while (i > nb1);

        } else {
            i = rd.nextInt(1000);
        }
        return i;
    }

    //fonction pour générer le signe du calcul
    public String genererSigne() {

        String afficherSigne;
        int choixCalcul;
        int addition = 0;
        int soustraction = 1;

        Random rd = new Random();

        if (DIFFICULTE_1) {

            choixCalcul = rd.nextInt(2);

            if (choixCalcul == addition) {
                afficherSigne = " + ";
            } else {
                afficherSigne = " - ";
            }
        } else {

            choixCalcul = rd.nextInt(3);

            if (choixCalcul == addition) {
                afficherSigne = " + ";
            } else if (choixCalcul == soustraction) {
                afficherSigne = " - ";
            } else {
                afficherSigne = " * ";
            }
        }

        return afficherSigne;
    }

    //fonction qui génère le calcul en fonction des 2 nbrs tirés et du signe
    public int genererCalcul() {

        int calcul;

        switch (signe) {
            case " + ":
                calcul = nb1 + nb2;
                break;
            case " - ":
                calcul = nb1 - nb2;
                break;
            default:
                calcul = nb1 * nb2;
                break;
        }

        return calcul;
    }

    @Override
    public String genererQuestion() {
        nb1 = genererNb1();
        nb2 = genererNb2();
        signe = genererSigne();
        
        return nb1 + signe + nb2 + " = ";
    }

    public int getNb1() {
        return nb1;
    }

    public void setNb1(int nb1) {
        this.nb1 = nb1;
    }

    public int getNb2() {
        return nb2;
    }

    public void setNb2(int nb2) {
        this.nb2 = nb2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getSigne() {
        return signe;
    }

    public void setSigne(String signe) {
        this.signe = signe;
    }
    
    

}
