package gui;

import java.util.Random;
import questions.Question;
import questions.QuestionsDAO;
import settings.Settings;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.3: added userEntryCheck
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
            q = qdao.find(new Random().nextInt(32));
        } while (s.getQuestionsDifficulty() != q.getDifficulty());
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

    @Override
    public boolean userEntryCheck(String userEntry) {
        return userEntry.toLowerCase()
                .replaceAll("[â ä à]", "a")
                .replaceAll("[é è ê ë]", "e")
                .replaceAll("[î ï]", "i")
                .replaceAll("[ö ô]", "o")
                .replaceAll("[û ü]", "u")
                .replaceAll("[ÿ]", "y")
                .replaceAll("[ç]", "c")
                .equals(q.answer);
    }

}
