package gui;

/**
 *
 * @author marine
 */
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @param args the command line arguments
 *
 */
public class ArdoiseGUI extends JPanel implements ActionListener {

    JLabel label; // les variables
    int x;
    int y;
    Color c;
    Integer size = 10;

    String type;
    ArrayList<Point> points = new ArrayList<Point>();// création d'une collection de points

    private void setLabel(int x, int y) { // afficher le label avec les coordonnées de la souris
        label.setText("x=" + x + ", y=" + y);
    }

    public ArdoiseGUI() {
        super();//appelle le constructeur de la classe du dessus

        x = 0;
        y = 0;
        type = "";
        Point p = new Point();
        label = new JLabel();
        setBorder(BorderFactory.createTitledBorder("Ardoise")); // on créer un JLabel Ardoise à notre JFrame
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(initArdoiseGUI()); // on appelle les fonctions initArdoise et initToolBar
        add(initToolBarGUI());

    }

    public JPanel initArdoiseGUI() {
// un JPanel container dans la JFrame et un JPanel dessin dans le JPanel container
        JPanel container = new JPanel();
        JPanel dessin = new JPanel();
        dessin.setBackground(Color.white); // couleur de fond initialisée à blanc

        // les écouteurs
        dessin.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { // on clique sur la souris
                Graphics g = dessin.getGraphics();
                g.setColor(c);// on récupère la couleur, les x et y

                x = e.getX();
                y = e.getY();
                setLabel(x, y);
                if (type.equals("rond")) {// si le type est "rond", on compare la chaine de caractère type à "rond"
                    g.fillOval(x, y, size, size);// alors on trace en rond (coordonnées et taille)
                } else {
                    g.fillRect(x, y, size, size);// sinon on trace en carré
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        }
        );

        dessin.addMouseMotionListener(
                new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e
            ) {// on clique sur la souris sans la lâcher
                Graphics2D g = (Graphics2D) dessin.getGraphics(); // même chose que pour le "pressed"

                g.setColor(c);

                if (type.equals("rond")) {
                    g.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                } else {
                    g.setStroke(new BasicStroke(size, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
                }
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
            }
        }
        );

        container.setLayout(
                new BorderLayout());// ajoute le container qui contient la zone de dessin à notre JPanel
        container.add(label, BorderLayout.SOUTH);

        container.add(dessin, BorderLayout.CENTER);

        return container;
    }

    public JPanel initToolBarGUI() { // initialisation de la barre d'outil

        JPanel tb = new JPanel();
        Graphics g = tb.getGraphics();

        JButton palette = new JButton("palette de couleur");// mettre un écouteur sur le bouton "palette de couleur"
        tb.add(palette, BorderLayout.EAST);// pour ouvrir une palette de couleur dans une fenêtre

        palette.addActionListener(
                (ActionEvent ae) -> {
                    c = JColorChooser.showDialog(this, "Choisissez une couleur", Color.black);
                }// la couleur initiale est noir
        );

        JButton rond = new JButton("rond"); // même chose que pour le bouton carré
        tb.add(rond, BorderLayout.EAST);

        rond.addActionListener(
                (ActionEvent ae) -> {
                    type = "rond";
                }
        );

        JButton carre = new JButton("carré");
        tb.add(carre, BorderLayout.EAST); // ajouter le bouton carré à la barre d'outil

        JSlider tailleCrayon = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);

        tailleCrayon.setMinorTickSpacing(2);
        tailleCrayon.setMajorTickSpacing(10);
        tailleCrayon.setPaintTicks(true);
        tailleCrayon.setPaintLabels(true);

        tb.add(tailleCrayon, BorderLayout.EAST);

        tailleCrayon.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                size = tailleCrayon.getValue();
            }
        });

        carre.addActionListener(
                (ActionEvent ae) -> {
                    type = "carré"; // définir le type du bouton carre "carré" pour gérer la condition dans "pressed" et "dragged"
                }
        );

        JButton effacer = new JButton("Gomme"); // initialiser la couleur de la gomme à "blanc"
        tb.add(effacer, BorderLayout.EAST);
        effacer.setBackground(Color.WHITE);

        effacer.addActionListener(
                (ActionEvent ae) -> {
                    c = Color.WHITE;
                }
        );
        return tb; // retourner la barre d'outil

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
