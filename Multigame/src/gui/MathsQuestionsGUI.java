package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import questions.*;

/**
 * ************************************************
 * @author June.QL
 * @version 0.2.2
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class MathsQuestionsGUI extends JPanel {

    // JPanel pour afficher le problème (question ou calcul)
    JPanel questionPane = new JPanel();
    // JPanel TextField user answer
    JPanel saisiePane = new JPanel();
    // ButtonsGUI boutons = new ButtonsGUI();
    JPanel buttonsPane = new JPanel();
    // Génère une String d'un Calcul ou d'une Question
    JLabel labelQuestion = new JLabel();
    // JButtons
    JButton checker = new JButton("Vérification");
    JButton solution = new JButton("Solution");
    JButton questionSuivante = new JButton("Suivant");
    // Générique pour question ou calcul
    Object o;

    public MathsQuestionsGUI(String title) {
        super();
        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        initGUI();
    }

    private void initGUI() {

        questionPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        Font font = new Font("Arial", Font.BOLD, 50);
        labelQuestion.setFont(font);

        // nb1 = genererNb1();
        // nb2 = genererNb2(nb1);
        // signe = genererSigne();
        // labelProblemString.setText(nb1 + signe + nb2 + " = ");
        // resultat = genererCalcul(nb1, signe, nb2);
        //System.out.println(nb1 + signe + nb2 + " = " + resultat);
        labelQuestion.setText("aa"/*genererQuestion()*/);

        questionPane.add(labelQuestion);

        // JPanel pour afficher les boutons d'options
        // Appel fonction creerBoutons
        buttonsPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        checker.setPreferredSize(new Dimension(200, 75));
        solution.setPreferredSize(new Dimension(200, 75));
        questionSuivante.setPreferredSize(new Dimension(200, 75));

        //ajouts des boutons
        buttonsPane.add(checker);
        buttonsPane.add(solution);
        buttonsPane.add(questionSuivante);

        // Jpanel pour la saisie utilisateur
        saisiePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.CENTER);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        reponse.setFont(font2);
        JTextField saisie_utilisateur = new JTextField(20);

        saisie_utilisateur.setPreferredSize(new Dimension(200, 70));
        saisie_utilisateur.setFont(font2);

        saisiePane.add(reponse);
        saisiePane.add(saisie_utilisateur);
        saisie_utilisateur.requestFocusInWindow();

        // Ecouteur pour le bouton "Suivant"
        questionSuivante.addActionListener((ActionEvent ae) -> {
            //on remet la couleur du bouton par defaut
            checker.setBackground(null);

            //on remet le JTextField vide
            saisie_utilisateur.setText("");
            saisie_utilisateur.requestFocusInWindow();

            //on recreer des un calcul aleatoire
            // nb1 = genererNb1();
            // nb2 = genererNb2(nb1);
            // signe = genererSigne();
            // labelProblemString.setText(nb1 + signe + nb2 + " = ");
            // resultat = genererCalcul(nb1, signe, nb2);
            //System.out.println(nb1 + signe + nb2 + " = " + resultat);
            labelQuestion.setText("a"/*genererQuestion()*/);

        });

        //ecouteur pour le bouton vérification
        checker.addActionListener((ActionEvent ae) -> {
            if (true) {
                if (saisie_utilisateur.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vous n'avez saisis aucun resultat",
                            "ERREUR !", JOptionPane.PLAIN_MESSAGE);
                } else if (Integer.parseInt(saisie_utilisateur.getText()) == 0 /*resultat*/) {
                    checker.setBackground(Color.GREEN);
                } /*
                else if(!Integer.parseInt(saisie_utilisateur.getText()) = resultat){
                    JOptionPane.showMessageDialog (null, "Erreur de saisie !!!",
               "ERREUR !", JOptionPane.PLAIN_MESSAGE);
                 */ else {
                    checker.setBackground(Color.RED);
                    saisie_utilisateur.setText("");
                }
            } else {
                //TODO
            }
        });

        //test evenement entré pour valider
        //ecouteur pour le bouton solution
        solution.addActionListener((ActionEvent ae) -> {
            if (true) {
                // on remet la couleur du bouton par defaut
                checker.setBackground(Color.RED);

                // on remet le JTextField vide
                saisie_utilisateur.setText("La solution était : " /*+ resultat*/);
            } else {
                //TODO
            }
        }
        );

        add(questionPane);
        add(saisiePane);
        add(buttonsPane);

        saisie_utilisateur.requestFocusInWindow();
    }
}
