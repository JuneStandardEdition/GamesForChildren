package gui;

import questions.Calcul;
import questions.Question;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 09-03-2020.15:10
 *
 *************************************************
 */
public class CalculGUI extends MathsQuestionsGUI {

    Calcul c = new Calcul();
    Question q = new Question();

    public CalculGUI(String title) {
        super(title);
        c.genererNb1();
        c.genererNb2();
        c.genererSigne();
        c.genererResult();
        q.setQuestion(Integer.toString(c.nb1));
    }

    @Override
    public Question genererQuestion() {
        return q;
    }

    @Override
    public String genererIntitule() {
        String s = q.getQuestion();
        return s;
    }

    @Override
    public String getCurrentAnswer() {
        String s = String.valueOf(c.getResult());
        return s;
    }

}
