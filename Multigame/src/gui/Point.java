/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;

/**
 *
 * @author marine
 */
public class Point { // classe Point avec constructeur et Getter/Setter
//la fonction "ToString" renvoie le nom de la classe de l'objet concerné suivi de l'adresse de cet objet
//Quand on redéfinit la méthode to String, on fait en sorte qu'elle renvoie une chaîne de caractères
//servant à décrire l'objet concerné.

    private int x = 0;
    private int y = 0;
    private int size = 20;
    private String type = "rond";
    private Color couleur = Color.black;

    // Constructeurs
    public Point() {
    }

    public Point(Color couleur, int size, int x, int y, String type) {

        this.couleur = couleur;
        this.size = size;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    // Getter et Setter
    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Point{" + "couleur=" + couleur + ", size=" + size + ", x=" + x + ", y=" + y + ", type=" + type + '}';
    }

}
