/*package ardoise;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * ************************************************
 * @author June.QL
 * @version 0.1.1
 * @date 05-03-2020.09:38
 *
 *************************************************

public class Ardoise {

    public class Gribouille3 extends Applet {

        int xd, yd, x, y;
        Color c = Color.black;
        Button nettoyer;
        Choice couleurs;

        public Gribouille3() {
            setBackground(Color.blue);
            nettoyer = new Button("effacer");
            nettoyer.setForeground(Color.black);
            nettoyer.setBackground(Color.lightGray);
            couleurs = new Choice();
            couleurs.addItem("black");
            couleurs.addItem("red");
            couleurs.addItem("yellow");
            couleurs.addItem("green");
            couleurs.setForeground(Color.black);
            couleurs.setBackground(Color.lightGray);
        }

        class Appuyeur extends MouseAdapter {

            public void mousePressed(MouseEvent e) {
                xd = e.getX();
                yd = e.getY();
            }
        }

        class Dragueur extends MouseMotionAdapter {

            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        }

        class Nettoyeur implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                Graphics g = getGraphics();
                g.clearRect(0, 0, getSize().width,
                        getSize().height);
                g.dispose();
            }
        }

        class Coloreur implements ItemListener {

            public void itemStateChanged(ItemEvent e) {
                String a = (String) e.getItem();
                if (a.equals("black")) {
                    c = Color.black;
                } else if (a.equals("red")) {
                    c = Color.red;
                } else if (a.equals("yellow")) {
                    c = Color.yellow;
                } else if (a.equals("green")) {
                    c = Color.green;
                } else {
                    c = Color.pink;
                }
            }
        }

        public void init() {
            add(nettoyer);
            add(new Label("coloris: "));
            add(couleurs);
            addMouseListener(new Appuyeur());
            addMouseMotionListener(new Dragueur());
            nettoyer.addActionListener(new Nettoyeur());
            couleurs.addItemListener(new Coloreur());
        }

    }
}*/

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ardoise;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @param args the command line arguments
 *
 */
public class Ardoise extends JFrame {

    int x = 0, y = 0;
    JPanel container = new JPanel();
    JLabel label = new JLabel();
    JPanel dessin = new JPanel();

    public Ardoise() {
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
        setLabel(x, y);
        container.setLayout(new BorderLayout());
        container.add(label, BorderLayout.SOUTH);
        container.add(dessin, BorderLayout.CENTER);
        this.setTitle("Dessinons");
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(container);
        this.setVisible(true);
    }

    private void setLabel(int x, int y) {
        label.setText("x=" + x + ", y=" + y);
    }

}
