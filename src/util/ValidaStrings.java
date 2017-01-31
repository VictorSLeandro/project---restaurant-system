/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author victor
 */
public class ValidaStrings {
     public static boolean isNome(String Nome) {
         if ((Nome.equals(" "))||(Nome.equals(" "))||(Nome.equals("  "))
          ||(Nome.equals("  "))||(Nome.equals("   "))||(Nome.equals("    "))
          ||(Nome.equals("     "))||(Nome.equals("     "))||(Nome.equals("     "))
           ||(Nome.equals("       "))||(Nome.equals("                 "))||(Nome.equals("  "))
                 ||(Nome.equals("                   "))){
             return false;
     }
         else {
             return  true;
         }
   }
}
