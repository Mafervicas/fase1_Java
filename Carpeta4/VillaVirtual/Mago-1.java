/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package villavirtual;

import java.io.IOException;

/**
 *
 * @author Vicas Family
 */
public class Mago extends Personajes{
   
    //Atributos
    public int Poder;
    public String ogro;
    
    //Constructor
    public Mago(int vida, int hadas, int Poder, String ogro){
         super(vida, hadas);
         this.Poder= Poder;
         this.ogro= ogro;
     }
    //Gets & Sets:

    public int getPoder() {
        return Poder;
    }

    public void setPoder(int Poder) {
        this.Poder = Poder;
    }

    public String getOgro() {
        return ogro;
    }

    public void setOgro(String ogro) {
        this.ogro = ogro;
    }
    
   public static void OgroAtaque() throws IOException{
       System.out.println("");
       System.out.println("Le has bajado considerablemente al mago la vida y ha mandado a llamar al ogro, cuidado! ");
       System.out.println("Desgraciadamente te bajará 20 niveles de vida");
       System.out.println("   __,='``'=/__                                            \n" +
       "        '//  (o) \\(o) \\ `'         _,-,                             \n" +
"        //|     ,_)   (`\\      ,-'`_,-\\                             \n" +
"      ,-~~~\\  `'==='  /-,      \\==` \\__                          \n" +
"     /        `----'     `\\     \\       \\/                          \n" +
"  ,-`                  ,   \\  ,.-\\       \\                          \n" +
" /      ,               \\,-`\\`,-`\\,..--'\\                         \n" +
",`    ,/,              ,>,   )     \\--`````\\  ");
       System.out.println("");
       
   }
}
