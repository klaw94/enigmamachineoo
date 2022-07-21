/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.enigmamachineoo;

import static java.lang.Character.isLetter;

/**
 *
 * @author Gebruiker
 */
public class EnigmaMachineOO {
    Rotor[] rotors = new Rotor[3];
    Reflector reflector = new Reflector("ABCDEFGDIJKGMKMIEBFTCVVJAT");
    
    
    public EnigmaMachineOO(){
       rotors[0] = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQOB", 21); 
       rotors[1] = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 4);        
       rotors[2] = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 16); 
    }
    
    public void setRotorPosition(String input){
        char[] rotorPosition = input.toUpperCase().replace(" ", "").toCharArray();
        
        rotors[0].setInitialPosition(rotorPosition[2]);
        rotors[1].setInitialPosition(rotorPosition[1]);
        rotors[2].setInitialPosition(rotorPosition[0]);
    }

    String encrypt(char[] letters) {
        String encryption = "";
        int p;
        for (char c : letters){
            if (isLetter(c)){
                if (rotors[0].advance()){
                    if (rotors[1].advance()){
                        rotors[2].advance();
                    }
                }  
   
                p = rotors[0].fromLeftToRight(c - 'A');         
                p = rotors[1].fromLeftToRight(p); 
                p = rotors[2].fromLeftToRight(p);                           
                p = reflector.reflect(p);
                p = rotors[2].fromRightToLeft(p);
                p = rotors[1].fromRightToLeft(p);
                p = rotors[0].fromRightToLeft(p);
              encryption += (char)((p % 26) + 'A');
          } else {
              encryption += c;
          } 
        }
      return encryption;  
    }
    
    public static boolean validateRotorPosition(String input) {
        char[] rotorPosition = input.toUpperCase().replace(" ", "").toCharArray();
        
        return (rotorPosition.length == 3 || isLetter(rotorPosition[0]) || isLetter(rotorPosition[1]) || isLetter(rotorPosition[2]));
    }
}
