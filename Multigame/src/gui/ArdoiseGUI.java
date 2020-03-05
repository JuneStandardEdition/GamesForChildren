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
