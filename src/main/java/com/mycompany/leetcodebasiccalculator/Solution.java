/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leetcodebasiccalculator;

import java.util.Stack;
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
        
        int number = 0;
        int sum = 0;
        int sign = 1;
        
        Stack<Integer> stack = new <Integer>Stack();
        
        for(int i=0;i<s.length();i++) {
            if(Character.isDigit(s.charAt(i))) {
                    number = (number << 3) + (number << 1) + Character.getNumericValue(s.charAt(i));
                if(i==s.length()-1 || !Character.isDigit(s.charAt(i+1))) {
                    sum = sum + number * sign;
                    number = 0;
                }
            } else {
                switch (s.charAt(i)) {
                    case '+' : sign = 1; break;
                    case '-' : sign = -1; break;
                    case '(' : 
                        stack.push(sum);
                        stack.push(sign);
                        sum = 0;
                        sign = 1;
                        break;
                    case ')' : 
                        sum = sum * stack.pop() + stack.pop();
                        break;
                }
            }            
        }
        return sum;        
    }    
}
