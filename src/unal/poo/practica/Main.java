package unal.poo.practica;

import becker.robots.*;

/**
 * Ejercicios con el robot Karel
 * @author Laura Moreno, Hernan Quiroga, Juan Carrero, Juan Cardenas
 */
public class Main {
     public static City objetos;
        public static Robot estudiante;
        
        public static void main(String[] args) {
        objetos = new City("Field2.txt");
	objetos.showThingCounts(true);    
        estudiante = new Robot(objetos,19, 0, Direction.NORTH,0); 
            if(hayFigura()){
                Thing t1=new Thing(objetos, estudiante.getStreet(), estudiante.getAvenue()+1);
            
            System.out.println("Area de la figura: " + recorrerFigura());
            }
}
        
        public static boolean hayFigura(){
            while(estudiante.frontIsClear()&&((estudiante.getAvenue()!=19)||(estudiante.getStreet()!=19))){
                estudiante.move();
                if(estudiante.getStreet()==0){
                    estudiante.turnLeft();
                    estudiante.turnLeft();
                } if(estudiante.getStreet()==19){
                    estudiante.turnLeft();
                    estudiante.move();
                    estudiante.turnLeft();
                }
                
            }
            if(estudiante.frontIsClear()){
                return false;
            }else{
                estudiante.turnLeft();
                return true;
            }
        }

        public static void turnRight(){
            estudiante.turnLeft();
            estudiante.turnLeft();
            estudiante.turnLeft();
        }
        public static void moverVariasVeces(int n){
            for(int i=0; i<n; i++){
                estudiante.move();
            }
        }
        public static int recorrerFigura(){
            int area=0;
            int matriz[][]=new int[20][20];
            for(int i=0; i<20; i++){
                for(int j=0; j<20; j++){
                    matriz[i][j]=0;
                }
            }
            while(estudiante.canPickThing()==false){
                turnRight();
                    while(estudiante.frontIsClear()==false){
                    estudiante.turnLeft();    
                }
                matriz[estudiante.getStreet()][estudiante.getAvenue()]=1;
                estudiante.move();
            }
         
            for(int i=1; i<20; i++){
                boolean karelEstaAdentro=false;
                for(int j=1; j<20; j++){
                    if((matriz[i][j-1]==1)&&(karelEstaAdentro==false)){
                    while(matriz[i][j]!=1){
                        karelEstaAdentro=true;
                        matriz[i][j]=2;
                        if(j<19){
                        j++;
                        }
                    }
                    
                }
            }
            }
            
            for(int i=1; i<20; i++){
                boolean karelEstaAdentro=false;
                for(int j=18; j>0; j--){
                    if((matriz[i][j+1]==1)&&(karelEstaAdentro==false)){
                    while(matriz[i][j]!=1){
                        karelEstaAdentro=true;
                        matriz[i][j]=2;
                        if(j<19){
                        j--;
                        }
                    }
                    
                }
            }
            }
            
            for(int i=0; i<20; i++){
                for(int j=0; j<20; j++){
                    if(matriz[i][j]==2){
                        area++;
                    }
                }
                System.out.print("\n");
            }
            return area;
        }
}
        

