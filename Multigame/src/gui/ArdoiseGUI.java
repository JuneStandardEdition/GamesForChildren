package gui;

/**
 *
 * @author marine
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @param args the command line arguments
 *
 */
public class ArdoiseGUI extends JPanel {

    JLabel label;
    int x = 0, y = 0;

    public ArdoiseGUI() {
        super();
        x = 0;
        y = 0;
        label = new JLabel();
        setBorder(BorderFactory.createTitledBorder("Ardoise"));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(initGUI());
    }

    public JPanel initGUI() {

        JPanel container = new JPanel();
        JPanel dessin = new JPanel();
        dessin.setBackground(Color.cyan);
        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                x = e.getX();
                y = e.getY();
                setLabel(x, y);
            }
        });
        container.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics g = dessin.getGraphics();
                g.drawLine(x, y, e.getX(), e.getY());
                x = e.getX();
                y = e.getY();
                setLabel(x, y);
            }
        });
        setLabel(1, 2);
        container.setLayout(new BorderLayout());
        container.add(label, BorderLayout.SOUTH);
        container.add(dessin, BorderLayout.CENTER);
        return container;
    }

    private void setLabel(int x, int y) {
        label.setText("x=" + x + ", y=" + y);
    }
}
