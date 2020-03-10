package gui;

import questions.Calcul;
import questions.Question;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.2
 * @date 09-03-2020.15:10
 *
 *************************************************
 */
public class CalculGUI extends MathsQuestionsGUI {

    public Calcul c;
    public Question q;

    public CalculGUI(String title) {
        super(title);
        genererQuestion();
        labelQuestion.setText(q.getQuestion());
    }

    @Override
    public Question genererQuestion() {
        c = new Calcul();
        q = new Question();
        q.setId(0);
        q.setQuestion(String.valueOf(c.nb1 + c.signe + c.nb2) + " = ");
        q.setAnswer(String.valueOf(c.result));
        return q;
    }

    @Override
    public String genererIntitule() {
        return q.getQuestion();
    }

    @Override
    public String getCurrentAnswer() {
        String s = String.valueOf(c.getResult());
        return s;
    }

    @Override
    public boolean userEntryCheck(String userEntry) {
        return userEntry.equals(q.answer);
    }

}
