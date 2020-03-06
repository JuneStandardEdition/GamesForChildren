package gui;

/**
 *
 * @author marine
 */
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @param args the command line arguments
 *
 */
public class ArdoiseGUI extends JPanel {

    JLabel label;
    int x;
    int y;

    public ArdoiseGUI() {
        super();

        x = 0;
        y = 0;
        label = new JLabel();
        setBorder(BorderFactory.createTitledBorder("Ardoise"));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(initArdoiseGUI());
        add(initToolbarGUI());

    }

    public JPanel initArdoiseGUI() {

        JPanel container = new JPanel();
        JPanel dessin = new JPanel();
        dessin.setBackground(Color.white);

        dessin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                x = e.getX();
                y = e.getY();
                setLabel(x, y);
            }
        });
        dessin.addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = dessin.getGraphics();

                g.setColor(Color.black);
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
                setLabel(x, y);

            }
        });
        setLabel(x, y);
        container.setLayout(new BorderLayout());
        container.add(label, BorderLayout.SOUTH);
        container.add(dessin, BorderLayout.CENTER);
        return container;
    }

    public JPanel initToolbarGUI() {
        JPanel x = new JPanel();
        Choice couleurs;
        couleurs = new Choice();
        JButton carre = new JButton("Forme Carrée");
        x.add(carre, BorderLayout.EAST);

        JButton rond = new JButton("Forme Ronde");
        x.add(rond, BorderLayout.EAST);

        JButton palette = new JButton("palette de couleur");
        x.add(palette, BorderLayout.EAST);
        JColorChooser jcc = new JColorChooser();
        jcc.getColor();

        x.add(jcc, BorderLayout.EAST);

        JButton effacer = new JButton("Gomme");
        x.add(effacer, BorderLayout.EAST);
        return x;
    }

    private void setLabel(int x, int y) {
        label.setText("x=" + x + ", y=" + y);
    }

    class Couleur implements ItemListener {

        public void itemStateChanged(ItemEvent e) {
            Color couleur;
            String a = (String) e.getItem();
            if (a.equals("noir")) {
                couleur = Color.black;
            } else if (a.equals("rouge")) {
                couleur = Color.red;
            } else if (a.equals("jaune")) {
                couleur = Color.yellow;
            } else if (a.equals("vert")) {
                couleur = Color.green;
            } else {
                couleur = Color.pink;
            }
        }

    }

}
