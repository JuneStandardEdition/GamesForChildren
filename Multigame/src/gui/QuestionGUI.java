package gui;

import java.util.Random;
import questions.Question;
import questions.QuestionsDAO;
import settings.Settings;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.2
 * @date 09-03-2020.15:10
 *
 *************************************************
 */
public class QuestionGUI extends MathsQuestionsGUI {

    Question q;

    public QuestionGUI(String title) {
        super(title);
        q = genererQuestion();
        labelQuestion.setText(q.getQuestion());
    }

    @Override
    public Question genererQuestion() {
        Settings s = new Settings();
        QuestionsDAO qdao = new QuestionsDAO();
        do {
            q = qdao.find(new Random().nextInt(qdao.getAll().size()));
        } while (s.getQuestionsDifficulty() != q.difficulty);
        return q;
    }

    @Override
    public String genererIntitule() {
        return q.getQuestion();
    }

    @Override
    public String getCurrentAnswer() {
        return q.getAnswer();
    }

}
