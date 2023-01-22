/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villavirtual;

/**
 *
 * @author Vicas Family
 */
import java.io.*;
import java.io.IOException;
import java.util.Random;
import javax.swing.JOptionPane;



public class Personajes {

//Atributos     
    public int vida;
    public int hadas;

//Constructor del principal
    public Personajes(int vida, int hadas) {
        this.vida = vida;
        this.hadas = hadas;
    }
//Gets & Sets

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getHadas() {
        return hadas;
    }

    public void setHadas(int hadas) {
        this.hadas = hadas;
    }

//Programa Principal
    public static void main(String[] args) throws IOException {
        BufferedReader reader = 
                   new BufferedReader(new InputStreamReader(System.in));
        
        //Variables
         

        System.out.println("          **************");
        System.out.println("              Bienvenidos al juego Villa Virtual      ");
        System.out.println("          **************");
        
        //Dada de información
        System.out.println("");
        System.out.println("Primero daremos de alta la información");
        System.out.print("Cuál es tu nombre? ");
        String nombre= reader.readLine();
        System.out.print("Dale un buen nombre al ogro: ");
        String ogro= reader.readLine();
        System.out.println("Inciarás con un nivel de vida de 100, al igual que el mago");
        int vida= 100;
        System.out.println("En este momento hay 12 hadas repartidas en 4 casas y esperan ser salvadas por ti");
        int hadas= 12;
        int Poder=100;    
        int hadasR= 0; //Hadas Rescatadas
        int golpesOgro= 0; //Para al final mostrar cuántas veces te dio el ogro
        System.out.println("Cuidado con el ogro, que defiende al mago " + nombre);
        
        
        Jugador objeto1= new Jugador(vida, hadas, nombre);
        Mago objeto2= new Mago(vida, hadas, Poder, ogro);
        
        
        System.out.println("Para su comodidad y diversión, nuestro juego está dividido en 3 secciones");
        System.out.println("1) Nivel Fácil");
        System.out.println("2) Nivel Medio");
        System.out.println("3) Nivel avanzado");
        System.out.print("Escoja una opción " + nombre+ ": ");
        int opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opción " + nombre+ ": "));
        
        //Menú
          switch (opcion){
              
          case 1:
                      System.out.println("");
                      System.out.println("-------- REGLAS -------");
                      System.out.println("Este es el nivel fácil, aquí sólo se harán sumas y restas");
                      System.out.println("En este caso por cada respuesta correcta, le bajarás 5 barritas de vida al mago");
                      System.out.println("Podrás recuperar de un hada en una: ");
                      System.out.println("");

                                      //Empieza con ciclo

                     do {                         //Info para el jugador
                                 System.out.println("");
                                 System.out.println("Vidas de "+ nombre+ ": "+ objeto1.vida);
                                 System.out.println("Hadas que faltan por rescatar: " + objeto2.hadas);

                                //Llamar método
                          double resultado=SumasRestas();

                           if (resultado ==1 &&  objeto1.vida==100 && objeto2.hadas ==12){ //Si atinaste, tienes 100 en vida y están todas las hadas
                                        //Vidas
                                        objeto2.vida= objeto2.vida -5 ;
                                        
                                     }
                           else if(resultado==1 && objeto1.vida==100){ //Si atino y tiene 100 en vida
                                        //Vidas
                                        objeto2.vida= objeto2.vida -5 ;
                                        //Hadas
                                        objeto2.hadas= objeto2.hadas - 1;
                                        hadasR= hadasR+1;
                                              }
                
                           else if (resultado ==1 && objeto1.vida<=99){ //Si atinaste y tienes menos de 100 en vida
                                        //Vidas
                                        objeto1.vida= objeto1.vida + 5;
                                        objeto2.vida= objeto2.vida -5 ;
                                        //Hadas
                                        objeto2.hadas= objeto2.hadas -1 ;
                                        hadasR= hadasR+1; }
                           
                           else if (resultado <1 && objeto2.hadas == 12){ //Si fallaste y el mago tiene las 100
                                        //Vidas
                                        objeto1.vida= objeto1.vida -5;
                                        objeto2.vida= objeto2.vida +5;
                                        //Hadas
                                        System.out.println("Oh no, el mago tiene las 12 hadas");
                           }
 
                            else {     //Si fallaste 
                                           //Vidas
                                           objeto1.vida= objeto1.vida -5;
                                           objeto2.vida= objeto2.vida +5;
                                           //Hadas
                                           objeto2.hadas = objeto2.hadas + 1;  
                                     }

                         objeto1.hadas= hadasR; //Para igualar a las hadas rescatadas

                                  if ((hadasR%4) == 0 && hadasR!=0 && resultado==1 ){ //En caso de haber rescatado un trio de hadas
                                  System.out.println("Wooow");
                                  Jugador.ConstruirCasas();      }

                                  else{     System.out.println("Sigue salvando hadas");  }

                          if(objeto2.vida%8==0) {         //Para que aparezca mi ogro
                                   Mago.OgroAtaque();
                                   objeto1.vida= objeto1.vida - 20;
                                   golpesOgro= golpesOgro+ 1; }
                          
                          else{   System.out.println("Tu puedes");  }
                          
                          
                //Cerrar Ciclo 

                               } while ( objeto2.hadas>1 && objeto1.vida>1);
                 System.out.print("");

               break;
              
               
           case 2: 

                  System.out.println("");
                  System.out.println("-------- REGLAS -------");
                  System.out.println("Este es el nivel medio,  aquí sólo se harán multiplicaciones y divisiones");
                  System.out.println("En caso de que te toque una división, unicamente darás los números antes del punto");
                  System.out.println("En este caso por cada respuesta correcta, le bajarás 10 barritas de magia al mago");
                  System.out.println("Podrás recuperar de 6 en 6 hadas: ");
                  System.out.println("");
                  
                                  
              //Empieza con ciclo

                     do {                         //Info para el jugador
                                             System.out.println("");
                                             System.out.println("Vidas de "+ nombre+ ": "+ objeto1.vida);
                                             System.out.println("Hadas que faltan por rescatar: " + objeto2.hadas);
                                             

                                    //Llamar método
                              int resultado=Multiydivision();
                              
                                
                                
                                if(resultado==1 && objeto1.vida==100){ //Si atino y tiene 100 en vida
                                        //Vidas
                                        objeto2.vida= objeto2.vida -10 ;
                                        //Hadas
                                        objeto2.hadas= objeto2.hadas - 6;
                                        hadasR= hadasR + 6;
                                        Jugador.ConstruirCasas();
                                              }

                                
                                else if (resultado ==1 && objeto1.vida<=90){ //Si atinaste y tienes menos o igual de 90 en vida
                                        //Vidas
                                        objeto1.vida= objeto1.vida + 10;
                                        objeto2.vida= objeto2.vida -10 ;
                                        //Hadas
                                        objeto2.hadas= objeto2.hadas - 6;
                                        hadasR= hadasR + 6; 
                                         Jugador.ConstruirCasas();}
                                
                                
                                else if (resultado <1 && objeto2.hadas == 12){ //Si fallaste y el mago tiene las 100
                                        //Vidas
                                        objeto1.vida= objeto1.vida - 10;
                                        objeto2.vida= objeto2.vida + 10;
                                        //Hadas
                                        System.out.println("Oh no, el mago tiene las 12 hadas"); }
                                 

                                 else {    //Si fallaste
                                        //Vidas
                                        objeto1.vida= objeto1.vida -10;
                                        objeto2.vida= objeto2.vida +10;
                                        //Hadas
                                        objeto2.hadas = objeto2.hadas + 6;
                                                                 }

                     objeto1.hadas= hadasR; //Para igualar a las hadas rescatadas

                      if(objeto2.vida%6==0) {         //Para que aparezca mi ogro
                               Mago.OgroAtaque();
                               objeto1.vida= objeto1.vida - 20;
                               golpesOgro= golpesOgro+ 1;
                           }
                   else{   System.out.println("Tu puedes");

                                               }            
                //Cerrar Ciclo 

                                   } while ( objeto2.hadas>1 && objeto1.vida>1 );
                     System.out.print("");

                       break;
              
              
              case 3: 
                  System.out.println("");
                  System.out.println("-------- REGLAS -------");
                  System.out.println("Este es el nivel difícil, aquí sólo se hará una derivada ");
                  System.out.println("Contesta bien, salvas todas las hadas");
                  System.out.println("Contesta mal, gana el mago");
                  System.out.println("Mucha suerte");
                  System.out.println("");
                  
                  //Info para el jugador
                             System.out.println("");
                             System.out.println("Vidas de "+ nombre+ ": "+ objeto1.vida);
                             System.out.println("Hadas que faltan por rescatar: " + objeto2.hadas);
                                             

                       //Llamar método
                      double resultado=Derivadas();
                      
                      if (resultado==1){ //Si atinó
                           //Vidas
                           objeto2.vida= objeto2.vida -100;
                           //Hadas
                           objeto2.hadas= objeto2.hadas -12;
                           hadasR= hadasR+12;
                           Jugador.ConstruirCasas();
                                        }
                      else {
                            objeto1.vida= objeto1.vida - 100;
                         
                            System.out.println("Lo sentimos, perdiste ): ");
                              }
                  
                  
                  break;
          
          
          }
        System.out.println("");
        System.out.println("Resultados Finales:");
        System.out.println("Vida del Jugador: "+ objeto1.vida);
        System.out.println("Poder final del Mago: "+ objeto2.vida);
        System.out.println("Ataques de "+ogro+ ": "+ golpesOgro);
        System.out.println("Hadas rescatadas: "+ hadasR);
        System.out.print("");
        System.out.println("");
        System.out.println("");
        System.out.println("                 εїз   εїз   εїз   εїз   εїз   εїз   εїз                           ");
        System.out.println("                        Muchas gracias por jugar");
        System.out.println("                 εїз   εїз     εїз   εїз   εїз   εїз   εїз                           ");
        

    }
    
    
    //Métodos
    // Nivel Fácil
    public static double SumasRestas() throws IOException{
                     //Para que sea suma o resta
           Random Aleatorio= new Random();
           int SoR =1 + Aleatorio.nextInt(2);
           int punto= 0;

             if (SoR == 1){
                    //Sumas
                    int suma=0;

                    //Para generar sumas randoms
                     int num1 =1 + Aleatorio.nextInt(1000);
                     int num2 =1 + Aleatorio.nextInt(100);
                     suma= num1+num2;

                    System.out.println("A continuación tu reto, una suma ");  
                    int rsuma = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el resultado de la suma: " + num1+ " + " + num2 + ": "));

                         //Sumarle o restarle a la vida
                         if (rsuma== suma){
                             System.out.println("Felicidades, tu respuesta es correcta, atacas al mago y robas una hada");
                            punto= punto+ 1;
                         }
                         else {
                             System.out.println("Noooo, tu respuesta es incorrecta, Te ataca el mago y roba una hada");
                            punto= punto - 2;
                             }
             }

               else {

                    int resta=0;
                    //Para generar sumas randoms
                     int num1 =1 + Aleatorio.nextInt(1000);
                     int num2 =1 + Aleatorio.nextInt(100);
                     resta= num1- num2;

                    System.out.println("A continuación tu reto, una resta ");  
                    int rresta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el resultado de la suma: " + num1+ " - " + num2 + ": "));

                      //Sumarle o restarle a la vida
                         if (rresta== resta){
                             System.out.println("Felicidades, tu respuesta es correcta, atacas al mago y robas una hada");
                            punto= punto+ 1;
                         }
                         else {
                             System.out.println("Noooo, tu respuesta es incorrecta, Te ataca el mago y roba una hada");
                             punto= punto - 2;
                             }
                                             }
            return(punto);
}
    
    
    //Métodos para Mediano
    
    public static int Multiydivision() throws IOException{
        //multiplicacion o divicion 
            Random Aleatorio=new Random();
            int MoD=1+Aleatorio.nextInt(2);
            int punto=0;
            
            if (MoD==1){
                //Multiplicacion
                int multi=0;
                
                //generar multiplicacion random 
                int num1=1+Aleatorio.nextInt(1000);
                int num2=1+Aleatorio.nextInt(100);
                multi=num1*num2;
                
                System.out.println("A continuacion el reto, una multiplicación: ");
                int rmulti = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el resultado de la multiplicación: "+num1+" * "+num2+": "));
                        
                   //Sumar o restar la vida 
                   if(rmulti==multi){
                       System.out.println("Felicidades, tu respuesta es correcta, atacas al mago y robas una hada ");
                       punto=punto+1;
                   }
                   else{
                       System.out.println("Nooo, tu respuesta es incorrecta, te ataca el mago y roba una hada ");
                       punto=punto-2;
                   }
                
            }
            else{
                int divi=0;
                //generar divicion random 
                int num1=Aleatorio.nextInt(1000);
                int num2=Aleatorio.nextInt(100);
                divi=num1/num2;
                
                System.out.print("A continuacion el reto, una Division: ");
                int rdiv = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el resultado de la division: "+num1+" / "+num2+": "));
                        
                    
                    //sumar o restar la vida
                    if (rdiv==divi){
                        System.out.println("Felicidades, tu respuesta es correcta atacas al mago y robas una hada ");
                        punto=punto+1;
                    }
                    else{
                        System.out.println("Nooo, tu respuesta es incorrecta, te ataca el mago y roba una hada ");
                        punto=punto-2;
                    }
                
            }
        return(punto);
    }
    
              //Métodos para derivada
    public static double Derivadas(){
        
    Random Aleatorio=new Random();
    int punto=0;
    int num1=1+Aleatorio.nextInt(100);
    int num2=1+Aleatorio.nextInt(100);
    
    int der=(num1*1);
    
    System.out.println("El reto es una derivada");
    int rder = Integer.parseInt(JOptionPane.showInputDialog("La derivada a elegir es: f(x)= "+num1+"x+ "+num2+"= "));
    
        if (rder==der){
            System.out.println("Felicidades, tu respuesta es correcta atacas al mago y robas una hada ");
            punto=punto+1;
        }
        else{
            System.out.println("Nooo, tu respuesta es incorrecta, te ataca el mago y roba una hada ");
            punto=punto-2;
        }
    
    return(punto);
    }
    
}
    

