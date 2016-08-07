/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leetcodebasiccalculator;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Lubo Terifaj
 */
public class Solution {
    /**
    * Implemented a basic calculator to evaluate a simple expression string.
    * The expression string may contain open ( and closing parentheses ),
    * the plus + or minus sign -, non-negative integers and empty spaces.
    * Assume that the given expression is always valid.
    * 
    * @param s expression string which may contain '(', ')', ' ', '+', '-' and integers
    * @return  result of expression
    * 
    */    
    public int calculate(String s) {
        
        if (s == null) {
            throw new NullPointerException();
        }      
        
        if(!s.contains("(")) {
            return this.calculateWithoutParenthesis(s);
        }
        
        int openIndex = s.lastIndexOf('(');
        int closeIndex = s.indexOf(')', s.lastIndexOf('('));
        
        int subResult = this.calculateWithoutParenthesis(s.substring(openIndex + 1, closeIndex));        
        
        String str = s.replace(s.substring(openIndex, closeIndex + 1), Integer.toString(subResult));
        
        return this.calculate(str);
    }
    
    private int calculateWithoutParenthesis (String s) {
        char sign = '+';
        int number = 0;
        int sum = 0;
        
        for(int i=0;i<s.length();i++) {
                if(Character.isDigit(s.charAt(i))) {
                    number = (number << 3) + (number << 1) + Character.getNumericValue(s.charAt(i));
                    if(i==s.length()-1 || !Character.isDigit(s.charAt(i+1))) {
                        
                        switch(sign) {
                            case '+' : sum += number;
                                       number = 0;
                                       break;
                            case '-' : sum -= number;
                                       number = 0;
                                       break;
                        }
                        sign = '+';
                    }
                } else if (s.charAt(i) == '-') {
                           if(sign == '-') {
                               sign = '+'; 
                            } else { sign = '-'; }                     
                    }                
            }            
        return sum;
    }
}
