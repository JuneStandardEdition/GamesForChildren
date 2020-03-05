package gui;

/**
 *
 * @author marine
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @param args the command line arguments
 *
 */
public class ArdoiseGUI extends JPanel {

    int x = 0, y = 0;
    JPanel drawing = new JPanel();
    JLabel label = new JLabel();
    JPanel dessin = new JPanel();
    Button nettoyer;
    Choice couleurs;

    private JComboBox liste1;

    private void setLabel(int x, int y) { // afficher le JPanel en bas à gauche
        //label.setText("Barre outils ");
        label.setText("x=" + x + ", y=" + y);
    }

    public ArdoiseGUI() {
        dessin.setBackground(Color.white);
        drawing.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // récupérer les nouvelles positions de la souris et les afficher

                x = e.getX();
                y = e.getY();
                setLabel(x, y);
            }

        });

        drawing.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { // tracer le mouvement
                Graphics g = dessin.getGraphics();
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
                setLabel(x, y);
            }
        });
        setLabel(x, y);
        drawing.setLayout(new BorderLayout()); // initialiser et positionner le container drawing
        drawing.add(label, BorderLayout.SOUTH);
        drawing.add(dessin, BorderLayout.CENTER);
        drawing.setBorder(BorderFactory.createTitledBorder("Ardoise magique"));
        drawing.setSize(800, 600);

        drawing.add(nettoyer, BorderLayout.CENTER);

        nettoyer = new Button("effacer");
        nettoyer.setForeground(Color.black);
        nettoyer.setBackground(Color.lightGray);
        liste1.add(couleurs);
        couleurs = new Choice();
        couleurs.addItem("noir");
        couleurs.addItem("rouge");
        couleurs.addItem("jaune");
        couleurs.addItem("vert");
        couleurs.addItem("gris");
        couleurs.addItem("orange");
        couleurs.addItem("marron");
        couleurs.addItem("rose");

        couleurs.setForeground(Color.black);
        couleurs.setBackground(Color.lightGray);

        //JFrame.setContentPane(drawing);
        drawing.setVisible(true);

    }

}
