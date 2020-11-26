/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *
 * @author jenni.makinen
 */

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = "pretty", 
    features = "src/test/resources/RecommendationLibrary", 
    snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunCucumberTest {   
}