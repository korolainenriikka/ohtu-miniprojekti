/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendationLibrary;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import RecommendationLibrary.dao.*;

/**
 *
 * @author jenni.makinen
 */
public class Stepdefs {
    
    Main main;
    List<String> inputLines;
    
    @Before
    public void setup(){
          
    }
    
    @Given("^command add is selected$")
    public void commandAddSelected() throws Throwable {
        inputLines.add("1"); // 1 = add
    }
    
    @When("author {string}, title {string} and rescription {string} is added")
    public void newRecommendationIsAdded(String author, String title, String rescription){
        
    }
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        //assertTrue(.contains(expectedOutput));
    }
    
}
