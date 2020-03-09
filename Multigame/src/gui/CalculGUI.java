package gui;

import questions.Calcul;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 09-03-2020.15:10
 *
 *************************************************
 */
public class CalculGUI extends MathsQuestionsGUI {

    Calcul c;

    public CalculGUI(String title) {
        super(title);
        c = new Calcul();
    }

    @Override
    public Calcul genererQuestion() {
        c.setNb1(c.genererNb1());
        c.setNb2(c.genererNb2());
        c.setSigne(c.genererSigne());
        c.setResult(c.genererResult());
        return c;
    }

    @Override
    public String genererIntitule() {
        String s = c.getNb1() + c.getSigne() + c.getNb2() + " = ";
        System.out.println(s);
        return s;
    }

    @Override
    public String getCurrentAnswer() {
        String s = String.valueOf(c.getResult());
        return s;
    }

}
