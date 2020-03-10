package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.09:38
 *
 *************************************************
 */
public class SQLConnection {

    private static final String host = "172.16.0.48";
    private static final String port = "3306";
    private static final String base = "2020devJSEg3";
    private static final String login = "2020devJSEg3";
    private static final String password = "Carina";
    private static final String url = "jdbc:mysql://" + host + ":" + port + "/" + base;
    private static Connection c = null;

    
    private SQLConnection() {
        // Did you expect a needle?
    }

    public static Connection getInstance() {
        if (c == null) {
            try {
                c = DriverManager.getConnection(url, login, password);
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Connecté à la base de données " + base + " avec l'URL " + url);
        return c;
    }
     
}
