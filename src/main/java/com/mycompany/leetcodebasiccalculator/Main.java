/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leetcodebasiccalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lubo Terifaj
 */
public class Main {
    public static void main(String[] args) {
        System.out.print("Enter expression: ");
        
        String str = null;
        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            str = input.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Solution solution = new Solution();                
        
        System.out.println("Result of expression is: " + solution.calculate(str));
    }
}
