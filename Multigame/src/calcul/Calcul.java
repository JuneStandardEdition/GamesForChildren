package calcul;

import static settings.Settings.DIFFICULTEE_1;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.09:38
 *
 *************************************************
 */
public class Calcul{

    // generation du nombre 1 selon la difficultee 
    public int genererNb1() {

        int nb1, Max, Min;

        if (DIFFICULTEE_1) {
            Max = 9;
            Min = 0;

            nb1 = Min + (int) (Math.random() * ((Max - Min) + 1));
        } else {
            Max = 999;
            Min = 0;

            nb1 = Min + (int) (Math.random() * ((Max - Min) + 1));
        }

        return nb1;
    }

    // generation du nombre 2 selon la difficultee 
    public int genererNb2(int nb1) {

        int nb2, Max, Min;

        if (DIFFICULTEE_1) {
            Max = 9;
            Min = 0;

            do {
                nb2 = Min + (int) (Math.random() * ((Max - Min) + 1));
            } while (nb2 > nb1);
        } else {
            Max = 999;
            Min = 0;

            nb2 = Min + (int) (Math.random() * ((Max - Min) + 1));
        }

        return nb2;
    }

    public int genererCalculETResultat(int nb1, int nb2) {

        int calcul, choixCalcul;
        int min = 0;
        int addition = 0;
        int soustraction = 1;

        if (DIFFICULTEE_1) {

            int max = 1;
            choixCalcul = min + (int) (Math.random() * ((max - min) + 1));

            if (choixCalcul == addition) {
                calcul = nb1 + nb2;
            } else {
                calcul = nb1 - nb2;
            }
        } else {

            int max = 2;
            choixCalcul = min + (int) (Math.random() * ((max - min) + 1));

            if (choixCalcul == addition) {
                calcul = nb1 + nb2;
            } else if (choixCalcul == soustraction) {
                calcul = nb1 - nb2;
            } else {
                calcul = nb1 * nb2;
            }
        }

        return calcul;
    }

    public String genererCalcul(int nb1, int nb2) {

        String afficherCalcul = "";
        int choixCalcul;
        int min = 0;
        int addition = 0;
        int soustraction = 1;
        if (DIFFICULTEE_1) {

            int max = 1;
            choixCalcul = min + (int) (Math.random() * ((max - min) + 1));

            if (choixCalcul == addition) {
                afficherCalcul = nb1 + " + " + nb2 + " = ";
            } else {
                afficherCalcul = nb1 + " - " + nb2 + " = ";
            }
        } else {

            int max = 2;
            choixCalcul = min + (int) (Math.random() * ((max - min) + 1));

            if (choixCalcul == addition) {
                afficherCalcul = nb1 + " + " + nb2 + " = ";
            } else if (choixCalcul == soustraction) {
                afficherCalcul = nb1 + " - " + nb2 + " = ";
            } else {
                afficherCalcul = nb1 + " * " + nb2 + " = ";
            }
        }

        return afficherCalcul;
    }
}
