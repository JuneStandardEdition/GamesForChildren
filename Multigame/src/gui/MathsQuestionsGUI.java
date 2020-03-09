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

        questionPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        Font font = new Font("Arial", Font.BOLD, 50);
        labelQuestion.setFont(font);

        questionPane.add(labelQuestion);
        // JPanel pour afficher les boutons d'options
        // Appel fonction creerBoutons
        buttonsPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        checker.setPreferredSize(new Dimension(200, 75));
        solution.setPreferredSize(new Dimension(200, 75));
        questionSuivante.setPreferredSize(new Dimension(200, 75));
        //labelQuestion.setText(genererIntitule());

        // Ajout des boutons
        /**
         * Bouton VERIFICATION
         */
        buttonsPane.add(checker);
        //ecouteur pour le bouton vérification
        checker.addActionListener((ActionEvent ae) -> {
            if (saisie_utilisateur.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Vous n'avez saisi aucun resultat",
                        "ERREUR !", JOptionPane.PLAIN_MESSAGE);
            } else if (saisie_utilisateur.getText().equals(getCurrentAnswer())) {
                checker.setBackground(Color.GREEN);
            } else {
                checker.setBackground(Color.RED);
                saisie_utilisateur.setText("");
            }
        });

        /**
         * Bouton SOLUTION
         */
        buttonsPane.add(solution);
        //test evenement entré pour valider
        //TODO
        //ecouteur pour le bouton solution
        solution.addActionListener((ActionEvent ae) -> {
            // on remet la couleur du bouton par defaut
            checker.setBackground(Color.RED);

            // on remet le JTextField vide
            saisie_utilisateur.setText("La solution était : " + getCurrentAnswer());
        });

        /**
         * Bouton SUIVANT
         */
        buttonsPane.add(questionSuivante);
        // Ecouteur pour le bouton "Suivant"
        questionSuivante.addActionListener((ActionEvent ae) -> {
            //on remet la couleur du bouton par defaut
            checker.setBackground(null);

            //on remet le JTextField vide
            saisie_utilisateur.setText("");
            saisie_utilisateur.requestFocusInWindow();
            labelQuestion.setText(genererIntitule());
        });

        // Jpanel pour la saisie utilisateur
        saisiePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.CENTER);
        Font font2 = new Font("Arial", Font.BOLD, 25);
        reponse.setFont(font2);

        saisie_utilisateur.setPreferredSize(new Dimension(200, 70));
        saisie_utilisateur.setFont(font2);

        saisiePane.add(reponse);
        saisiePane.add(saisie_utilisateur);
        saisie_utilisateur.requestFocusInWindow();

        add(questionPane);
        add(saisiePane);
        add(buttonsPane);

        saisie_utilisateur.requestFocusInWindow();
    }

    public abstract Object genererQuestion();

    public abstract String genererIntitule();

    public abstract String getCurrentAnswer();
}
