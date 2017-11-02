/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopuzzle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class JuegoPuzzle {

    /**
     * @param args the command line arguments
     */
    JFrame frame;
    public JuegoPuzzle(int nivel){
        if(nivel<=6){
            frame=new JFrame("juego puzzle");
            frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);
            frame.setSize(1000, 700);
            frame.setLocationRelativeTo(null);
            frame.setUndecorated(true);
            compomentPane compoment=new compomentPane(frame);
            frame.getContentPane().add(compoment);
            panelJuego juego=new panelJuego(frame,nivel,compoment);//1=3
            frame.getContentPane().add(juego);
            frame.setVisible(true);
        }
        else{JOptionPane.showMessageDialog(null, "juego terminado , estas acha!XD");System.exit(0);}
    }
    public static void main(String[] args) {
        
        JuegoPuzzle jueguito=new JuegoPuzzle(3);
    }
    
}
