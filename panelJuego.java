/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegopuzzle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user eduardo perez j informatica
 */
public class panelJuego extends JPanel{
    JFrame frame;
    casilla[][]matriz;
    tablero a;compomentPane compoment;
    int nivel;
    int movimientos;
    time t;int min,seg;
    JPanel panel;
    ArrayList<JButton>botons;
    public panelJuego(JFrame j,int nivel,compomentPane compoment){
        frame=j;
        this.setBounds(300,0,700,700);
        this.setLayout(null);
        this.setBackground(Color.GRAY);
        crearEvento();
        this.nivel=nivel;
        matriz=new casilla[nivel][nivel];
        a=new tablero(nivel);
        a.run();
        this.setEnabled(true);
        crearCasillas(nivel);
        this.compoment=compoment;
        movimientos=0;
        min=nivel;seg=0;
        configurarBotones();
        cargarNivel();
        t=new time();
    }
    private void crearEvento() {
        this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e){
            mover(e.getX(),e.getY());
        }});
    }
    void cargarNivel(){
        compoment.labels.get(compoment.labels.size()-1).setText(
                compoment.labels.get(compoment.labels.size()-1).getText().substring(0,21)+ (nivel-2));
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                matriz[i][j].paint(g);
            }
        }
        this.repaint();
    }

    private void crearCasillas(int nivel) {
        int v=nivel*100;
        v=((700*100)/v)-50;
        int vv=(v/2)+(v/2);
        int aux=vv;
        int [][]aa=a.getTablero();
        int max=nivel*nivel;
        for(int i=0;i<matriz.length;i++){
            vv=aux;
            for(int j=0;j<matriz.length;j++){
                matriz[i][j]=(new casilla(v,vv,max,aa[i][j]));
                vv=vv+100;
            }
            v=v+100;
        }
    }
    private void mover(int x,int y){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if(matriz[i][j].Pertenece(x, y)){
                    int dato=matriz[i][j].valor;
                    moverDatos(i+1,j,dato,i,j);moverDatos(i,j+1,dato,i,j);
                    moverDatos(i-1,j,dato,i,j);moverDatos(i,j-1,dato,i,j);
                    validarEstado();
                    i=matriz.length;
                    break;
                }
            }
        }
    }
    void validarEstado(){
        if(a.tester(matriz)){JOptionPane.showConfirmDialog(null, "ganaste pasa al siguiente nivel: con tiempo de :"+min+":"+seg);
        time.interrupted();
        botons.get(botons.size()-2).setEnabled(true);
        new JuegoPuzzle(nivel+1);frame.dispose();
        }
    }
     void moverDatos(int i, int j,int dato,int x,int y) {
        if(valida(i,j)){
            int val=matriz[i][j].valor;
            if(val==nivel*nivel){
                matriz[i][j].mover(matriz[i][j].x,matriz[i][j].y,dato);
                matriz[x][y].mover(matriz[x][y].x,matriz[x][y].y,val);
                contar();
            }
        }
    }
    boolean valida(int x,int y){
        return x>=0 && x<matriz.length && y>=0 && y<matriz.length ;
    }
    void contar(){
        movimientos++;
        compoment.labels.get(compoment.labels.size()-2).setText(
                compoment.labels.get(compoment.labels.size()-2).getText().substring(0,17)+ movimientos);
    }
    
    private void configurarBotones() {
        botons=compoment.botons;
        botons.get(botons.size()-4).setEnabled(false);
        botons.get(botons.size()-3).setEnabled(false);
        botons.get(botons.size()-2).setEnabled(false);
        for(int i=0;i<botons.size();i++){
            crearEvento(botons.get(i));
        }
        
    }
    private void crearEvento(JButton b){
        b.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e){
            //"Empesar","Reiniciar","Anterior","Posterior","Siguiente","Salir"};
            switch(b.getText()){
                case "Empesar":;t.start();movimientos=0;compoment.labels.get(compoment.labels.size()-2).setText(
                compoment.labels.get(compoment.labels.size()-2).getText().substring(0,17)+ movimientos);break;
                case "Reiniciar":new JuegoPuzzle(nivel);frame.dispose();break;
                case "Anterior":break;
                case "Posterior":break;
                case "Siguiente":if(b.isEnabled()){new JuegoPuzzle(nivel+1);frame.dispose();}break;
                case "Salir":System.exit(0);
                
                    
            }
            
        }});
    }
    class time extends Thread{
        @Override
        public void run(){
            while(min>0 && seg>=0){
                if(seg==0){
                    min--;
                    seg=59;
                }
                else{
                    seg--;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    
                }
                compoment.labels.get(0).setText(
                compoment.labels.get(0).getText().substring(0,16)+ min+" : "+seg);
            }
           compoment.labels.get(0).setText(
                compoment.labels.get(0).getText().substring(0,16)+ 0+" : "+0);
           int re=JOptionPane.showOptionDialog(null, "Time Limit exceeded","desea volver a intentar?",1,2,null,null,"");
           if(re==0){new JuegoPuzzle(nivel);frame.dispose();}else{
           if(re==1){System.exit(0);}}
        }
    }
}
