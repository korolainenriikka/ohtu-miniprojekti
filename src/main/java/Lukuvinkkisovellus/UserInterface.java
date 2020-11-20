/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkkisovellus;

import Lukuvinkkisovellus.Recommendation;
import java.util.Scanner;

/**
 *
 * @author jhku
 */
public class UserInterface {

    private Scanner reader;
    private Recommendation recommendation;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.recommendation = new Recommendation();
    }

    public void run() {
        
        int input;
        
        while (true) {
            System.out.println("[1] Add recommendation, [2] List recommendations, [3] Exit");
            input = reader.nextInt();
            
            if(input == 1) add();
            if(input == 2) list();
            if(input == 3) break;
        }                
    }
    
    
    public void add(){
        System.out.println("Type the name of the recommendation");
        String name = reader.next();
        
        System.out.println("Type the author of the recommendation");
        String author = reader.next();
        
        System.out.println("Type the description of the recommendation");
        String description = reader.next();
        
        recommendation.add(name, author, description);
        
    }
    
    public void list(){
        recommendation.list();
    }

}
