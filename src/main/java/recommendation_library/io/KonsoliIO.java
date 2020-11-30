/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.io;

import java.util.Scanner;

/**
 *
 * @author jenni.makinen
 */
public class KonsoliIO implements IO {

    private Scanner reader;

    /**
     *
     * example: KonsoliIO io = new KonsoliIO(System.in);
     *
     * @param scanner a scanner from where input can be read.
     */
    public KonsoliIO(Scanner scanner) {
        reader = scanner;
    }

    @Override
    public String nextLine() {
        return reader.nextLine();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

}
