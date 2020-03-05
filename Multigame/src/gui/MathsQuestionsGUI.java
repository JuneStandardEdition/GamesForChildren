package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class MathsQuestionsGUI extends JPanel {

    JPanel afficherCalcul, boutons, saisie;

    public MathsQuestionsGUI() {

        super();
        setBorder(BorderFactory.createTitledBorder("Maths"));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        initGUI();
    }

    private void initGUI() {

        JPanel afficherCalcul = new JPanel();
        JPanel boutons = new JPanel();
        JPanel saisie = new JPanel();

        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //this.setBorder(BorderFactory.createTitledBorder("Maths"));
        // Jpanel pour afficher le calcul
        /**
         * **********************************************************
         */
        afficherCalcul.setLayout(new FlowLayout(FlowLayout.LEFT));
        String calcul = generateCalcul();
        JLabel calc = new JLabel(calcul, JLabel.LEFT);
        afficherCalcul.add(calc);
        /**
         * **********************************************************
         */

        //Jpanel pour afficher les boutons d'options
        /**
         * **********************************************************
         */
        boutons.setLayout(new GridLayout(0, 3));
        JButton verif = new JButton("Verification");
        JButton solution = new JButton("Solution");
        JButton questionSuivante = new JButton("Suivante");
        boutons.add(verif);
        boutons.add(solution);
        boutons.add(questionSuivante);
        /**
         * **********************************************************
         */

        //Jpanel pour la saisie utilisateur
        /**
         * **********************************************************
         */
        saisie.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.LEFT);
        JTextField saisie_utilisateur = new JTextField(15);
        saisie.add(reponse);
        saisie.add(saisie_utilisateur);
        /**
         * ***********************************************************
         */

        add(afficherCalcul);
        add(boutons);
        add(saisie);
    }

    String generateCalcul() {
        int Max = 9;
        int Min = 0;
        int nb1 = 0;
        int nb2 = 0;

        int addition = 0;
        int soustraction = 1;

        nb1 = addition + (int) (Math.random() * ((soustraction - addition) + 1));

        String calcul = "";

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

        //System.out.println(calcul);
        return calcul;
    }

}
