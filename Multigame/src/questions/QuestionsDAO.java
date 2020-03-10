package questions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 06-03-2020.8:45
 *
 *************************************************
 */
public class QuestionsDAO implements DAO<Question> {

   public ArrayList<Question> qdao = new ArrayList<>();

    public List<Question> getAll() {
        String sqlQuery = "SELECT * FROM questions";
        try (Statement stmt = CONNEXION.createStatement()) {
            ResultSet resSetQuestion = stmt.executeQuery(sqlQuery);
            while (resSetQuestion.next()) {
                qdao.add(new Question(resSetQuestion.getInt("id"), resSetQuestion.getString("question"), resSetQuestion.getString("answer"), resSetQuestion.getInt("difficulty")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qdao;
    }

    @Override
    public Question find(Integer id) {
        Question qst = null;
        try {
            String req = "SELECT * FROM questions WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                qst = new Question(result.getInt("id"), result.getString("question"), result.getString("answer"), result.getInt("difficulty"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qst;
    }

    @Override
    public void create(Question q) {
        try {
            String req = "INSERT INTO questions (question, answer, difficulty) VALUES (?,?,?)";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, q.getQuestion());
            pstmt.setString(2, q.getAnswer());
            pstmt.setInt(3, q.getDifficulty());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM questions WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Question q) {
        try {
            String req = "UPDATE questions SET question = ?, answer = ?, difficulty = ? WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, q.getQuestion());
            pstmt.setString(2, q.getAnswer());
            pstmt.setInt(3, q.getDifficulty());
            pstmt.setInt(4, q.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
