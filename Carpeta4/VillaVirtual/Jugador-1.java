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
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MAFER VICAS
 */
public class Jugador extends Personajes{
    
    //Atributos
    public String nombre;
    
    //Constructor
     public Jugador(int vida, int hadas, String nombre){
         super(vida, hadas);
         this.nombre= nombre;
     }
     
    //Gets & Sets
    public String getNombre() {
        return nombre;  }
    public void setNombre(String nombre) {
        this.nombre = nombre; }
     
 
            public static void ConstruirCasas() throws IOException{
                System.out.println("");
                System.out.println("                      εїз   εїз   εїз   εїз   εїз                           ");
                System.out.println("Felicidades acabas de salvar 5 hadas y con esto construiste una casa");
                System.out.println("");
                System.out.println(" .-. ,-.\n" +
                            "'   (%%'`.               __\n" +
                            " `-(%|%)% )             /()\\````\\\n" +
                            "   (%\\K /,             /_\\_\\\n" +
                            "    %.\\V/%.)           |n  n|._|\n" +
                            "   (%\\%`(',            | _ /\\___\\\n" +
                            "     %| ,)   __      | || |n|n_n|\n" +
                            "      | |  /__ \"_     / |\n" +
                            "      | |\" .-. \" \"__,'  /\n" +
                            "     ,| |  |,' |  \"__,...'  ");
                System.out.println();
    
            }
            
          
}
