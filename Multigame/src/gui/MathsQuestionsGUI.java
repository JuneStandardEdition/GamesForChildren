package gui;

<<<<<<< HEAD
import javax.swing.*;
=======
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
>>>>>>> william2

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class MathsQuestionsGUI extends JPanel {
<<<<<<< HEAD
=======

    JPanel afficherCalcul, boutons, saisie;

    public MathsQuestionsGUI() {

        afficherCalcul = new JPanel();
        boutons = new JPanel();
        saisie = new JPanel();
    }
>>>>>>> william2

    void initGUI() {

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Maths"));

        afficherCalcul.setLayout(new BorderLayout());
        String calcul = generateCalcul();
        afficherCalcul.add(calcul, this);

    }

    String generateCalcul() {
        int Max = 9;
        int Min = 0;
        int nb1 = 0;
        int nb2 = 0;

        int addition = 0;
        int soustraction = 1;

        nb1 = addition + (int) (Math.random() * ((soustraction - addition) + 1));

        String calcul = null;

        if (nb1 == 1) {
            do {
                nb1 = Min + (int) (Math.random() * ((Max - Min) + 1));
                nb2 = Min + (int) (Math.random() * ((Max - Min) + 1));
            } while (nb2 > nb1);

            calcul = nb1 + " - " + nb2 + " = ";
        } else {
            nb1 = Min + (int) (Math.random() * ((Max - Min) + 1));
            nb2 = Min + (int) (Math.random() * ((Max - Min) + 1));

            calcul = nb1 + " + " + nb2 + " = ";
        }
        return calcul;
    }

}
