package gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static settings.Settings.DIFFICULTEE_1;

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

    //Fonction pr la gestion des evenements
    private void initGUI() {

        JPanel afficherCalcul = new JPanel();
        JPanel boutons = new JPanel();
        JPanel saisie = new JPanel();

        // Jpanel pour afficher le calcul
        /**
         * **********************************************************
         */
        afficherCalcul.setLayout(new FlowLayout(FlowLayout.LEFT));

        String calcul = genererCalcul(genererNb1(), genererNb2(genererNb1()));

        JLabel calc = new JLabel(calcul, JLabel.LEFT);
        afficherCalcul.add(calc);
        /**
         * **********************************************************
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
        
       
        //Jpanel pour afficher les boutons d'options
        /**
         * **********************************************************
         */
        //essaie appels fonction creerBoutons
        //ButtonsGUI boutons = new ButtonsGUI();
        //add(boutons.creerBoutons("calcul"));
        boutons.setLayout(new GridLayout(0, 3));
        JButton verif = new JButton("Verification");
        verif.addActionListener((ActionEvent ae) -> {
            
            if(saisie_utilisateur.getText().equals(genererCalculETResultat(5, 3))){
                verif.setBackground(Color.GREEN);
            }
            else{
                verif.setBackground(Color.RED);
            }
        });
        
        JButton solution = new JButton("Solution");
        JButton questionSuivante = new JButton("Autre calcul");

        boutons.add(verif);
        boutons.add(solution);
        boutons.add(questionSuivante);
        
        

        

        add(afficherCalcul);
        add(boutons);
        add(saisie);
    }

}
