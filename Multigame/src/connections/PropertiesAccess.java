package connections;

import java.nio.file.Paths;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 10-03-2020.11:00
 *
 *************************************************
 */
public class PropertiesAccess {

    private static final String pathToPropFile = "Settings.properties";
    private static Paths p = null;

    private PropertiesAccess() {
        // Did you expect a needle?
    }

    public static Paths getPropertiesPaths() {
        System.out.println("Settings file " + pathToPropFile + " access: OK");
        return p;
    }

}
