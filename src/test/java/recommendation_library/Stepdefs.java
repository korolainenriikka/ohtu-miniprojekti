/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import recommendation_library.dao.InMemoryRecommendationDao;
import recommendation_library.dao.RecommendationDao;
import recommendation_library.UserInterface;
import recommendation.io.StubIO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 *
 * @author jenni.makinen
 */
public class Stepdefs {
    
    List<String> inputLines;
    StubIO io;
    UserInterface ui;
    RecommendationDao dao;
    
    @Before
    public void setup(){
        this.inputLines = new ArrayList<String>();
    }

    @Given("^command add is selected")
    public void commandAddSelected() {
        inputLines.add("1");
    }
    
    @When("author {string}, title {string} and description {string} are entered")
    public void newRecommendationIsAdded(String author, String title, String description){
        inputLines.add(author);
        inputLines.add(title);
        inputLines.add(description);
        inputLines.add("3");
        io = new StubIO(inputLines);
        dao = new InMemoryRecommendationDao();
        ui = new UserInterface(io, dao);
        ui.run();
        
    }
    
    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        io.getPrints().contains(expectedOutput);
    }
    
}
