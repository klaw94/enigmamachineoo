/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.enigmamachineoo;

/**
 *
 * @author Gebruiker
 */
class Rotor {
    char[] code;
    int positie;
    int arrowPosition;
    
    
    public Rotor(String code, int arrow){
        this.code = code.toCharArray();
        arrowPosition = arrow;
    }

    void setInitialPosition(char c) {
        positie = c - 'A';
    }

    int fromLeftToRight(int i) {
        /**     return: first I determine the the ASCII number of the character in the code [with the position 
         * passed by the previous rottor plus the starting position from this rottor]. Then I take -A so 
         * it becomes a number from 1-26 (instead of 90-120 in the ASCII Table). I take the initial 
         * position away and that is the number I send. (+26 so it doesnt't become negative. And %26 
         * so it is never bigger that 26
         */
   
        return (code[(i + positie) % 26] - 'A' - positie + 26) % 26;
    }

    int fromRightToLeft(int p) {
        char c = (char)(((p + positie)  % 26) + 'A');
        for (int i = 0; i < code.length; i++){
           if (i >= positie && code[i] == c){
               return i - positie;
           } else if (i < positie && code[i] == c){
               return (26 - positie + i) % 26;
           }
        }
        return 0;
    }

    boolean advance() {
        positie = (positie + 1) % 26;
        if(positie == arrowPosition + 1){
            return true;
        } 
        return false;
    }
}
