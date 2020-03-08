package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
    public static boolean mathsOrQuestion;
    int resultat;
    int nb1;
    int nb2;
    String signe;

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
        Font font = new Font("Arial",Font.BOLD,80);
        labelProblemString.setFont(font);
        if (this.mathsOrQuestion) {
            nb1 = genererNb1();
            nb2 = genererNb2(nb1);
            signe = genererSigne();
            labelProblemString.setText(nb1 + signe + nb2 + " = ");
            resultat = genererCalcul(nb1, signe, nb2);
            //System.out.println(nb1 + signe + nb2 + " = " + resultat);
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

        //ajouts des boutons
        buttonsPane.add(verif);
        buttonsPane.add(solution);
        buttonsPane.add(questionSuivante);

        
        // Jpanel pour la saisie utilisateur
        saisiePane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel reponse = new JLabel("Saisir la réponse : ", JLabel.CENTER);
        Font font2 = new Font("Arial",Font.BOLD,30);
        reponse.setFont(font2);
        JTextField saisie_utilisateur = new JTextField(20);
        saisie_utilisateur.setPreferredSize(new Dimension(200, 70));
        saisie_utilisateur.setFont(font2);
        saisiePane.add(reponse);
        saisiePane.add(saisie_utilisateur);

        
        
        //ecouteur pour le bouton calcul suivant
        questionSuivante.addActionListener((ActionEvent ae) -> {
            if (this.mathsOrQuestion) {
                //on remet la couleur du bouton par defaut
                verif.setBackground(null);

                //on remet le JTextField vide
                saisie_utilisateur.setText("");

                //on recreer des un calcul aleatoire
                nb1 = genererNb1();
                nb2 = genererNb2(nb1);
                signe = genererSigne();
                labelProblemString.setText(nb1 + signe + nb2 + " = ");
                resultat = genererCalcul(nb1, signe, nb2);
                //System.out.println(nb1 + signe + nb2 + " = " + resultat);
            } else {
                labelProblemString.setText(genererQuestion());
            }
        });

        
        
        //ecouteur pour le bouton vérification
        verif.addActionListener((ActionEvent ae) -> {
            if (this.mathsOrQuestion) {
                if (Integer.parseInt(saisie_utilisateur.getText()) == resultat) {
                    verif.setBackground(Color.GREEN);
                } else {
                    verif.setBackground(Color.RED);
                }
            } else {
                //TODO
            }

        });

        
        
        //ecouteur pour le bouton solution
        solution.addActionListener((ActionEvent ae) -> {
            if (this.mathsOrQuestion) {
                //on remet la couleur du bouton par defaut
                verif.setBackground(Color.RED);

                //on remet le JTextField vide
                saisie_utilisateur.setText("La soluton était : " + resultat);
            } else {
                labelProblemString.setText(genererQuestion());
            }
        });

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
        Random rd = new Random();
        //DIFFICULTE_1 = !DIFFICULTE_1;
        if (DIFFICULTE_1) {
            i = rd.nextInt(10);
        } else {          
            i = rd.nextInt(1000);
        }
        return i;
    }

    // Génération du nombre 2 selon la difficulté
    public int genererNb2(int nb1) {
        int i;
        Random rd = new Random();
        if (DIFFICULTE_1) {
            do {              
                i = rd.nextInt(9);
            } while (i > nb1);

        } else {           
            i = rd.nextInt(1000);
        }
        return i;
    }

    
    
    //fonction pour générer le signe du calcul
    public String genererSigne() {

        String afficherSigne;
        int choixCalcul;
        int addition = 0;
        int soustraction = 1;

        Random rd = new Random();

        if (DIFFICULTE_1) {

            choixCalcul = rd.nextInt(2);

            if (choixCalcul == addition) {
                afficherSigne = " + ";
            } else {
                afficherSigne = " - ";
            }
        } else {

            choixCalcul = rd.nextInt(3);

            if (choixCalcul == addition) {
                afficherSigne = " + ";
            } else if (choixCalcul == soustraction) {
                afficherSigne = " - ";
            } else {
                afficherSigne = " * ";
            }
        }

        return afficherSigne;
    }
    
    
    
     //fonction qui génère le calcul en fonction des 2 nbrs tirés et du signe
    public int genererCalcul(int nb1, String signe, int nb2) {

        int calcul;

        if (signe.equals(" + ")) {
            calcul = nb1 + nb2;
        } else if (signe.equals(" - ")) {
            calcul = nb1 - nb2;
        } else {
            calcul = nb1 * nb2;
        }

        return calcul;
    }
}
