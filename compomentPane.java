
package juegopuzzle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class compomentPane extends JPanel{
    JFrame j;
    JButton boton;
    JLabel label;
    ArrayList<JLabel>labels;
    ArrayList<JButton>botons;
    
    public compomentPane(JFrame j){
        this.j=j;
        this.setLayout(null);
        this.setBounds(0,0,300,700);
        this.setBackground(Color.DARK_GRAY);
        labels=new ArrayList<JLabel>();
        botons=new ArrayList<JButton>();
        agregarObjetos();
        
        
    }

    private void agregarObjetos() {
        label=new JLabel("PUZZLE DINAMICO");
        label.setBounds(40,40,250,50);
        label.setFont(new Font("MS Reference Sans Serif", 2, 23));
        label.setForeground(Color.WHITE);
        this.add(label);
        String[]s={"Empesar","Reiniciar","Anterior","Posterior","Siguiente","Salir"};
        int posX=80;
        int posY=100;
        int ancho=150;
        int alto=40;
        for(int i=0; i<6;i++){
            boton=new JButton(s[i]);
            boton.setBounds(posX,posY,ancho, alto);
            boton.setBackground(Color.GRAY);
            boton.setFont(new Font("MS Reference Sans Serif", 1, 12));
            boton.setForeground(new Color(0, 51, 51));
            //crearEvento(boton);
            posY=posY+50;
            botons.add(boton);
            this.add(boton);
        }
        
        String []ss={"Tiempo Limite : ","Movimiento     : ","Nivel              : "};
        ancho=200;
        for(int i=0;i<3;i++){
            label=new JLabel(ss[i]);
            label.setBounds(posX,posY,ancho,alto);
            label.setFont(new Font("MS Reference Sans Serif", 1, 12));
            label.setForeground(new Color(0, 51, 51));
            posY=posY+50;
            labels.add(label);
            this.add(label);
        }
    }
    
    
}
