package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import questions.Question;
import questions.QuestionsDAO;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.3
 * @date 05-03-2020.10:00
 *
 *************************************************
 */
public class AdminPanelGUI extends JPanel {

    QuestionsDAO qu = new QuestionsDAO();

    private Integer ID;

    //Jpanel pour le choix modifier / ajouter / supprimer
    JPanel choixActionBoutton;

    //JComboList pour stocker les questions si l'utilisateur veut modifier ou surrpimer
    JComboBox jcq;

    //Jpanel pour afficher/saisir la question(question/reponse/difficultee)
    JPanel gererQuestion;
    JPanel gererReponse;
    JPanel gererDifficultee;
    JPanel gererId;

    //Boutons du Jpanel choixAction
    JButton modifier;
    JButton ajouter;
    JButton supprimer;

    //Composant du Jpanel gererQuestion
    JLabel quest;
    JTextField questions;
    JLabel rep;
    JTextField reponse;
    JLabel id;
    JTextField idtext;
    ButtonGroup selectlvl;
    JLabel difficultee;
    JRadioButton level1;
    JRadioButton level2;

    public AdminPanelGUI() {
        super();

        jcq = new JComboBox(qu.getAll().toArray());

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
        gererId = new JPanel();
        id = new JLabel("ID");
        idtext = new JTextField(5);
        gererDifficultee = new JPanel();
        selectlvl = new ButtonGroup();
        difficultee = new JLabel();
        level1 = new JRadioButton("Niveau 1");
        level2 = new JRadioButton("Niveau 2");

        // Inits GUI
        initGUI();
    }

    // Inits GUI for Admin Pane
    private void initGUI() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createTitledBorder("Administration"));

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

        //action listener pour la jcombo box
        jcq.addActionListener(e -> {
            Question q = (Question) jcq.getSelectedItem();
            //on recupere la question dans le textfield question
            questions.setText(q.getQuestion());
            //on recupere la reponse dans le textfield question
            reponse.setText(q.getAnswer());
            idtext.setText(q.getId().toString());
            ID = Integer.parseInt(idtext.getText());
        });

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
            Question q = new Question();
            qu.delete(ID);
        }));

        //ajout de l'ecouteur au bouton modifier
        modifier.addActionListener(((ae) -> {
            Question q = new Question();
            q.question = questions.getText();
            q.answer = reponse.getText();
            if (level1.isSelected()) {
                q.difficulty = 1;
            } else {
                q.difficulty = 2;
            }
            q.id = ID;

            qu.update(q);
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

        //JPanel gererID
        gererId.setLayout(new FlowLayout(FlowLayout.CENTER));
        //ajout du label
        gererId.add(id);
        //ajout du JTextfield
        gererId.add(idtext);

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

        jcq.setMaximumSize(new Dimension(500, 200));

        //ajout dans le jpanel
        add(jcq);
        add(gererQuestion);
        add(gererReponse);
        add(gererId);
        add(gererDifficultee);
        add(choixActionBoutton);
    }

}
