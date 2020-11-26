/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.io;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jenni.makinen
 */

public class StubIO implements IO{
    private List<String> lines;
    private int i;
    private List<String> prints;

    public StubIO(List<String> values) {
        this.lines = values;
        this.prints = new ArrayList<>();
    }

    public List<String> getPrints() {
        return prints;
    }
    
    @Override
    public String nextLine() {
        if (i < lines.size()) {
            return lines.get(i++);
        }
        return "3";
    }

    @Override
    public void print(String string) {
        this.prints.add(string);
    }
}
