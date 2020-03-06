package gui;

import calcul.Calcul;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

    public MathsQuestionsGUI() {

        super();
        setBorder(BorderFactory.createTitledBorder("Maths"));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        initGUI();
    }

    private void initGUI() {

        JPanel afficherCalcul = new JPanel();
        //JPanel boutons = new JPanel();
        JPanel saisie = new JPanel();

        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //this.setBorder(BorderFactory.createTitledBorder("Maths"));
        // Jpanel pour afficher le calcul
        /**
         * **********************************************************
         */
        afficherCalcul.setLayout(new FlowLayout(FlowLayout.LEFT));
        Calcul test = new Calcul();

        String calcul = test.genererCalcul(test.genererNb1(), test.genererNb2(test.genererNb1()));

        JLabel calc = new JLabel(calcul, JLabel.LEFT);
        afficherCalcul.add(calc);
        /**
         * **********************************************************
         */

        //Jpanel pour afficher les boutons d'options
        /**
         * **********************************************************
         */
        //essaie appels fonction creerBoutons
        ButtonsGUI boutons = new ButtonsGUI();
        add(boutons.creerBoutons("calcul"));

        /*
        boutons.setLayout(new GridLayout(0, 3));
        JButton verif = new JButton("Verification");
        JButton solution = new JButton("Solution");
        JButton questionSuivante = new JButton("Autre calcul");
        boutons.add(verif);
        boutons.add(solution);
        boutons.add(questionSuivante);
        
         */
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
}
