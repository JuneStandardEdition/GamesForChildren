package questions;

import java.util.Random;
import static settings.Settings.DIFFICULTE_1;

/**
 * ************************************************
 * @author will.i.am
 * @version 0.1.2
 * @date 09-03-2020.9:33
 *
 *************************************************
 */
public class Calcul {

    Integer nb1;
    Integer nb2;
    Integer result;
    String signe;

    public Calcul() {
        nb1 = 0;
        nb2 = 0;
        result = 0;
        signe = " + ";
    }

    public Calcul(Integer nb1, Integer nb2, Integer resultat, String signe) {
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

    // Fonction qui calcule le résultat en fonction des 2 nbrs tirés et du signe
    public Integer genererResult() {
        switch (signe) {
            case " + ":
                result = nb1 + nb2;
                break;
            case " - ":
                result = nb1 - nb2;
                break;
            default:
                result = nb1 * nb2;
                break;
        }
        return result;
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
