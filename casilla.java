/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class casilla {
    int x,y,tam;
    int valor,max;
    int diametroX,diametroY;
    public casilla(int x,int y,int max,int valor){
        this.x=x;
        this.y=y;
        this.tam=100;
        this.valor=valor;
        this.max=max;
    }
    public void paint(Graphics g){
        if(valor==max){
            g.setColor(new Color(51, 51, 51));
            g.fill3DRect(x, y, tam, tam, true);
        }
        else{
            g.setColor(Color.WHITE);
            g.setFont(new Font("MS Reference Sans Serif",3, 15));
            g.fill3DRect(x, y, tam, tam, true);
            g.setColor(Color.GREEN);
            g.drawString(valor+"",x+45, y+45);
        }
         
    }
    public void mover(int x,int y,int valor){
        this.x=x;this.y=y;this.valor=valor;
    }

    public boolean Pertenece(int x1,int y1) {
        return x1>=x && x1 <=x+100 && y1 >=y && y1<=y+100;        
    }
}
