/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.enigmamachineoo;


class Reflector {
     char[] code;
    
    
    public Reflector(String code){
        this.code = code.toCharArray();
    }

    int reflect(int p) {
        char c = code[p];
        for (int i = 0; i < code.length; i++) {
            if (i != p && code[i] == c) {
                return i;
            }
        }
        return 0;
    }
}
