package gui;

import java.util.Random;
import questions.Question;
import questions.QuestionsDAO;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 09-03-2020.15:10
 *
 *************************************************
 */
public class QuestionGUI extends MathsQuestionsGUI {

    Question q;

    public QuestionGUI(String title) {
        super(title);
        q = new Question();
    }

    @Override
    public Question genererQuestion() {
        QuestionsDAO qdao = new QuestionsDAO();
        q = qdao.find(new Random().nextInt(30));
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
