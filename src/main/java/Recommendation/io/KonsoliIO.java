/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recommendation.io;

import java.util.Scanner;

/**
 *
 * @author jenni.makinen
 */
public class KonsoliIO implements IO{

    private Scanner reader = new Scanner(System.in);
     
    @Override
    public String nextLine() {
        return reader.nextLine();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }
    
}
