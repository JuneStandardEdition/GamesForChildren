package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.*;
import questions.Question;
import questions.QuestionsDAO;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class AdminPanelGUI extends JPanel {
    
    QuestionsDAO qu = new QuestionsDAO();

    //Jpanel pour le choix modifier / ajouter / supprimer
    JPanel choixActionBoutton;

    //JComboList pour stocker les questions si l'utilisateur veut modifier ou surrpimer
    JComboBox jcq;

    //Jpanel pour afficher/saisir la question(question/reponse/difficultee)
    JPanel gererQuestion;
    JPanel gererReponse;
    JPanel gererDifficultee;

    //Boutons du Jpanel choixAction
    JButton modifier;
    JButton ajouter;
    JButton supprimer;

    //Composant du Jpanel gererQuestion
    JLabel quest;
    JTextField questions;
    JLabel rep;
    JTextField reponse;
    ButtonGroup selectlvl;
    JLabel difficultee;
    JRadioButton level1;
    JRadioButton level2;

    public AdminPanelGUI() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        choixActionBoutton = new JPanel();

        //initialisation des boutons de choixAction
        modifier = new JButton("Modifier");
        ajouter = new JButton("Ajouter");
        supprimer = new JButton("Supprimer");

        //initialisation des composant de gererQuestion
        gererQuestion = new JPanel();
        quest = new JLabel("Question");
        questions = new JTextField(40);
        gererReponse = new JPanel();
        rep = new JLabel("Reponse");
        reponse = new JTextField(40);
        gererDifficultee = new JPanel();
        selectlvl = new ButtonGroup();
        difficultee = new JLabel();
        level1 = new JRadioButton("Niveau 1");
        level2 = new JRadioButton("Niveau 2");

        //
        initGUI();
    }

    private void initGUI() {
        //definition du component pour le Jpanel choixAction
        choixActionBoutton.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Config label texte pour les intitulés : font
        Font font = new Font("Arial", Font.BOLD, 26);

        // Definition d'une taille par defauts pour tous les boutons
        modifier.setPreferredSize(new Dimension(175, 75));
        ajouter.setPreferredSize(new Dimension(175, 75));
        supprimer.setPreferredSize(new Dimension(175, 75));

        //Ajout des boutons
        choixActionBoutton.add(modifier);
        //ajout de l'ecouteur au bouton modifier

        choixActionBoutton.add(ajouter);
        //ajout de l'ecouteur au bouton ajouter
        ajouter.addActionListener(((ae) -> {
            Question q = new Question();
            q.question = questions.getText();
            q.answer = reponse.getText();
            if (level1.isSelected()) {
                q.difficulty = 1;
            } else {
                q.difficulty = 2;
            }
            
            qu.create(q);
        }));

        choixActionBoutton.add(supprimer);
        
        //ajout de l'ecouteur au bouton supprimer
        supprimer.addActionListener(((ae) -> {

            jcq = new JComboBox(qu.getAll().toArray());

            /*
            for(Question i : qdao2){
                jcq.addItem(qdao2);
            }
             */
        }));

        //Jpanel gererQuestion
        gererQuestion.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ajout du label
        gererQuestion.add(quest);
        //ajout du Jtexfield
        gererQuestion.add(questions);

        //Jpanel gererReponse
        gererReponse.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ajout du label
        gererReponse.add(rep);
        //ajout du Jtextfield
        gererReponse.add(reponse);

        //Jpanel gererDifficultee
        selectlvl.add(level1);
        selectlvl.add(level2);
        difficultee.add(level1);
        difficultee.add(level2);
        gererDifficultee.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ajout des radioButton lvl
        gererDifficultee.add(level1);
        //preselection par defaut au lvl1
        level1.setSelected(true);
        gererDifficultee.add(level2);

        //ajout dans le jpanel
        add(choixActionBoutton);
        add(jcq);
        add(gererQuestion);
        add(gererReponse);
        add(gererDifficultee);
    }

}
