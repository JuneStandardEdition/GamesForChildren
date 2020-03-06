package gui;

import java.awt.FlowLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import questions.Questions;
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
            labelProblemString.setText(genererCalcul(genererNb1(), genererNb2(genererNb1())));
        } else {
            labelProblemString.setText(genererQuestion());
        }
        problemLabelPane.add(labelProblemString);

        // JPanel pour afficher les boutons d'options
        // Appel fonction creerBoutons
        ButtonsGUI boutons = new ButtonsGUI();
        if (this.mathsOrQuestion) {
            add(boutons.creerBoutons("calcul"));
        } else {
            add(boutons.creerBoutons("question"));
        }

        // Jpanel pour la saisie utilisateur
        saisiePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.CENTER);
        JTextField saisie_utilisateur = new JTextField(30);
        saisiePane.add(reponse);
        saisiePane.add(saisie_utilisateur);

        add(problemLabelPane);
        add(saisiePane);
        add(boutons);
    }

    // generation du nombre 1 selon la difficulté
    public int genererNb1() {

        int nb1, Max, Min;

        if (DIFFICULTE_1) {
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

    // generation du nombre 2 selon la difficulté
    public int genererNb2(int nb1) {

        int nb2, Max, Min;

        if (DIFFICULTE_1) {
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

    public String genererQuestion() {
        QuestionsDAO qdao = new QuestionsDAO();

        return qdao.find(5).getQuestion();
    }

}
