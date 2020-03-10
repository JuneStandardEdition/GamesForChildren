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
import questions.Question;

/**
 * ************************************************
 * @author June.QL
 * @version 0.2.2
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public abstract class MathsQuestionsGUI extends JPanel {

    // JPanel pour afficher le problème (question ou calcul)
    JPanel questionPane;
    // JPanel TextField user answer
    JPanel saisiePane;
    // ButtonsGUI boutons = new ButtonsGUI();
    JPanel buttonsPane;
    // Génère une String d'un Calcul ou d'une Question
    protected JLabel labelQuestion;
    // JTF user entry
    JTextField saisie_utilisateur = new JTextField(30);
    // JButtons
    JButton checker;
    JButton solution;
    JButton questionSuivante;

    public abstract Question genererQuestion();

    public abstract String genererIntitule();

    public abstract String getCurrentAnswer();

    // Générique pour question ou calcul
    Object o;

    public MathsQuestionsGUI(String title) {
        super();
        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        questionPane = new JPanel();
        saisiePane = new JPanel();
        buttonsPane = new JPanel();
        labelQuestion = new JLabel();
        checker = new JButton("Vérification");
        solution = new JButton("Solution");
        questionSuivante = new JButton("Suivant");

        initGUI();
    }

    /**
     * Inits base GUI for Calcul and Question
     */
    private void initGUI() {

        // JPanel pour les intitulés
        questionPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // JPanel pour les boutons
        buttonsPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        // JPanel pour la saisie
        saisiePane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Config label texte pour les intitulés : font
        Font font = new Font("Arial", Font.BOLD, 26);
        labelQuestion.setFont(font);

        
        // Ajout de l'emplacement pour l'intitulé du problème (question ou calcul)
        questionPane.add(labelQuestion);

        // Appel fonction creerBoutons
        checker.setPreferredSize(new Dimension(175, 75));
        solution.setPreferredSize(new Dimension(175, 75));
        questionSuivante.setPreferredSize(new Dimension(175, 75));

        // Ajout des boutons
        /**
         * Bouton VERIFICATION
         */
        buttonsPane.add(checker);
        buttonsPane.add(solution);
        buttonsPane.add(questionSuivante);

        //ecouteur pour le bouton vérification
        checker.addActionListener((ActionEvent ae) -> {

            if (true) {
                if (saisie_utilisateur.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vous n'avez saisi aucun resultat",
                            "ERREUR !", JOptionPane.PLAIN_MESSAGE);
                } else if ((saisie_utilisateur.getText().equals(getCurrentAnswer()))) {
                    checker.setBackground(Color.GREEN);
                } /*
                else if(!Integer.parseInt(saisie_utilisateur.getText()) = resultat){
                    JOptionPane.showMessageDialog (null, "Erreur de saisie !!!",
               "ERREUR !", JOptionPane.PLAIN_MESSAGE);
                 */ else {
                    checker.setBackground(Color.RED);
                    saisie_utilisateur.setText("");
                }
            }
        });

        //test evenement entré pour valider
        //TODO
        //ecouteur pour le bouton solution
        solution.addActionListener((ActionEvent ae) -> {
            // on remet la couleur du bouton par defaut
            checker.setBackground(Color.RED);

            // on remet le JTextField vide
            saisie_utilisateur.setText("La solution était : " + getCurrentAnswer());
        });

       
        // Ecouteur pour le bouton "Suivant"
        questionSuivante.addActionListener((ActionEvent ae) -> {
            // On remet la couleur du bouton "Verifier" par défaut
            checker.setBackground(null);

            // On remet le JTextField de saisie utilisateur vide + Focus
            saisie_utilisateur.setText("");
            saisie_utilisateur.requestFocusInWindow();
            genererQuestion();
            labelQuestion.setText(genererIntitule());
            
        });

        // Jpanel pour la saisie utilisateur
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.CENTER);
        reponse.setFont(new Font("Arial", Font.BOLD, 22));

        saisie_utilisateur.setPreferredSize(new Dimension(150, 75));
        saisie_utilisateur.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));

        saisiePane.add(reponse);
        saisiePane.add(saisie_utilisateur);
        saisie_utilisateur.requestFocusInWindow();

        add(questionPane);
        add(saisiePane);
        add(buttonsPane);
    }
}
