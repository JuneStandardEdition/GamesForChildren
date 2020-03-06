package gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
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

    // generation du nombre 1 selon la difficultee 
    int genererNb1() {

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
    int genererNb2(int nb1) {

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

    int genererCalculETResultat(int nb1, int nb2) {

        int calcul, choixCalcul;
        int min = 0;
        int addition = 0;
        int soustraction = 1;
        

        if (DIFFICULTEE_1) {
            
            int max = 1;
            choixCalcul = min + (int) (Math.random() * ((max - min) + 1));
            
            if(choixCalcul == addition){
                calcul = nb1 + nb2;
            }
            else{
                calcul = nb1 - nb2;
            }
        }else{
            
           int max = 2;
           choixCalcul = min + (int) (Math.random() * ((max - min) + 1));
           
           if(choixCalcul == addition){
               calcul = nb1 + nb2;
           }
           else if(choixCalcul == soustraction){
               calcul = nb1 - nb2;
           }
           else{
               calcul = nb1 * nb2;
           }
        }

        return calcul;
    }

    String generCalcul(int nb1, int nb2) {

        String afficherCalcul = "";
        int choixCalcul;
        int min = 0;
        int addition = 0;
        int soustraction = 1;
        if (DIFFICULTEE_1) {
            
            int max = 1;
            choixCalcul = min + (int) (Math.random() * ((max - min) + 1));
            
            if(choixCalcul == addition){
                afficherCalcul = nb1 + "+" + nb2;
            }
            else{
                afficherCalcul = nb1 + "-" + nb2;
            }
        }else{
            
           int max = 2;
           choixCalcul = min + (int) (Math.random() * ((max - min) + 1));
           
           if(choixCalcul == addition){
               afficherCalcul = nb1 + "+" + nb2;
           }
           else if(choixCalcul == soustraction){
               afficherCalcul = nb1 + "-" + nb2;
           }
           else{
               afficherCalcul = nb1 + "*" + nb2;
           }
        }

        return afficherCalcul;
    }

}
