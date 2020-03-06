package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import questions.QuestionsDAO;
import static settings.Settings.DIFFICULTE_1;

/**
 * ************************************************
 * @author June.QL
 * @version 0.2.1
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class MathsQuestionsGUI extends JPanel {

    // True = Maths Tab, False = QnA Tab
    boolean mathsOrQuestion;

    public MathsQuestionsGUI(String title, boolean whichIsTheTab) {

        super();
        this.mathsOrQuestion = whichIsTheTab;
        setBorder(BorderFactory.createTitledBorder(title));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        initGUI();
    }

    private void initGUI() {

        // JPanel pour afficher le problème (question ou calcul)
        JPanel problemLabelPane = new JPanel();
        // JPanel TextField user answer
        JPanel saisiePane = new JPanel();
        problemLabelPane.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Génère une String d'un Calcul ou d'une Question
        JLabel labelProblemString = new JLabel();
        if (this.mathsOrQuestion) {
            int nb1 = genererNb1();
            int nb2 = genererNb2(nb1);
            labelProblemString.setText(genererCalcul(nb1, nb2));
        } else {
            labelProblemString.setText(genererQuestion());
        }
        problemLabelPane.add(labelProblemString);

        // JPanel pour afficher les boutons d'options
        // Appel fonction creerBoutons
        // ButtonsGUI boutons = new ButtonsGUI();
        JPanel buttonsPane = new JPanel();
        buttonsPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton verif = new JButton("Verification");
        JButton solution = new JButton("Solution");
        JButton questionSuivante = new JButton("Suivant");
        verif.setPreferredSize(new Dimension(200, 75));
        solution.setPreferredSize(new Dimension(200, 75));
        questionSuivante.setPreferredSize(new Dimension(200, 75));
        questionSuivante.addActionListener((ActionEvent ae) -> {
            if (this.mathsOrQuestion) {
                int nb1 = genererNb1();
                int nb2 = genererNb2(nb1);
                labelProblemString.setText(genererCalcul(nb1, nb2));
            } else {
                labelProblemString.setText(genererQuestion());
            }
        });
        buttonsPane.add(verif);
        buttonsPane.add(solution);
        buttonsPane.add(questionSuivante);

        // Jpanel pour la saisie utilisateur
        saisiePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.CENTER);
        JTextField saisie_utilisateur = new JTextField(30);
        saisiePane.add(reponse);
        saisiePane.add(saisie_utilisateur);

        add(problemLabelPane);
        add(saisiePane);
        add(buttonsPane);
    }

    public String genererQuestion() {
        QuestionsDAO qdao = new QuestionsDAO();
        return qdao.find(new Random().nextInt(17)).getQuestion();

    }

    // Génération du nombre 1 selon la difficulté
    public int genererNb1() {
        int i;
        if (DIFFICULTE_1) {
            Random rd = new Random();
            i = rd.nextInt(9);
        } else {
            Random rd = new Random();
            i = rd.nextInt(999);
        }
        return i;
    }

    // Génération du nombre 2 selon la difficulté
    public int genererNb2(int nb1) {
        int i;
        if (DIFFICULTE_1) {
            do{
                Random rd = new Random();
            i = rd.nextInt(9);
            }while(i > nb1);
            
        } else {
            Random rd = new Random();
            i = rd.nextInt(999);
        }
        return i;
    }

    public int genererCalcull(int nb1, int nb2) {

        int calcul, choixCalcul;
        int min = 0;
        int addition = 0;
        int soustraction = 1;

        if (DIFFICULTE_1) {

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
        if (DIFFICULTE_1) {

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

    
    /*
   
    //Fonction pr la gestion des evenements
    private void initGUIMath() {

        JPanel afficherCalcul = new JPanel();
        JPanel boutons = new JPanel();
        JPanel saisie = new JPanel();

        // Jpanel pour afficher le calcul
       
        afficherCalcul.setLayout(new FlowLayout(FlowLayout.LEFT));

        String calcul = genererCalcul(genererNb1(), genererNb2());

        JLabel calc = new JLabel(calcul, JLabel.LEFT);
        afficherCalcul.add(calc);
       
        //Jpanel pour la saisie utilisateur
        
        saisie.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.LEFT);
        JTextField saisie_utilisateur = new JTextField(15);
        saisie.add(reponse);
        saisie.add(saisie_utilisateur);
        

        //Jpanel pour afficher les boutons d'options
        
        //essaie appels fonction creerBoutons
        //ButtonsGUI boutons = new ButtonsGUI();
        //add(boutons.creerBoutons("calcul"));
        boutons.setLayout(new GridLayout(0, 3));
        JButton verif = new JButton("Verification");
        verif.addActionListener((ActionEvent ae) -> {

            if (saisie_utilisateur.getText().equals(genererCalcull(5, 3))) {
                verif.setBackground(Color.GREEN);
            } else {
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

    */

}
