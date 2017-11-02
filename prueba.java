
package juegopuzzle;

import java.util.Random;

public class tablero {
    Random r=new Random();
    int[][]matriz;
    int limite;
    public tablero(int n){
           matriz=new int[n][n];
           limite=(n*n)+1;
    }
    public void run(){
        int aux;
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                    aux=getNumero();
                    matriz[i][j]=aux;
            }
        }
    }
    public int getNumero(){
        int dato=r.nextInt(limite);
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                if(dato==matriz[i][j]){
                    dato=getNumero();
                }
            }
        }
        return dato;
    }
    public int[][] getTablero(){
        return matriz;
    } 
        
    public void mostrar(){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    public boolean tester(casilla[][]casillas){
        boolean res=true;
        int valor=1;
        for(int i=0;i<casillas.length;i++){
            for(int j=0;j<casillas.length;j++){
                if(valor!=casillas[j][i].valor){
                    res=false;
                    break;
                }
                valor++;
            }
      
        }
        return res;
    }
}
