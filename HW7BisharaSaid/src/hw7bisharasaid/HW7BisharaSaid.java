package hw7bisharasaid;

/*
course: CSC190
project: HW Assignment 7
due date: 10/27/22
author: Bishara Said
purpose: Write a Java program that will encode plain text into cipher text and 
    decode cipher text into plain text.
*/

import java.util.Scanner;
public class HW7BisharaSaid {
    
    //method to encode string p using a key
    public static String encode(String p, int key){
        //variable declarations
        String e = "";
        
        //type cast back to char
        for(int i=0; i < p.length(); i++){
            if((p.charAt(i) >= 97) && (p.charAt(i) <= 122 - key))
                e += (char)(p.charAt(i) + key);
            else if((p.charAt(i)+key) == 123)
                    e += (char)(p.charAt(i)+key-91);
            else if(p.charAt(i)+key > 123)
                e += (char)(p.charAt(i)+key-27);
            else{
                e += (char)(' ' + 64 + key);
            }  
        }
        return e;
    }
    
    //method to decode a string c using the key
    public static String decode(String c, int key){
        //variable declarations
        String d = "";
        
        for(int i=0; i<c.length(); i++){
           
            if((c.charAt(i) >= 97 + key ) && (c.charAt(i) <= 122))
                d += (char)(c.charAt(i) - key);
            else if((c.charAt(i)-key) == 96)
                    d += (char)(c.charAt(i)-key-64);
            else if((c.charAt(i) == 32))
                d += (char)(' ' + 91 - key);
            else
                d += (char)(c.charAt(i)-key+27);
        }
        return d;
    }
    
    public static void main(String[] args) {
        //variable declarations
        String plaintxt, encoded, decoded;
        int key;
        Scanner in = new Scanner(System.in);
        
        //get input from user
        //we need a string from the user to be used in our cipher
        System.out.print("Enter a message you want to encode.\n"
                + "(all lowercase): ");
        plaintxt = in.nextLine();
        
        //we need an integer from the user to act as our key
        System.out.print("Enter the key for the cipher: ");
        key = in.nextInt();
        in.nextLine();
        
        //encode the message by calling the respective method
        encoded = encode(plaintxt,key);
        
        //decode the message by calling the respective method
        decoded = decode(encoded,key);
        
        //output the result
        System.out.println("The encrypted message: "+encoded);
        System.out.println("Decrypting the message: "+decoded);
        
        //end program
    }//end main

}//end class
