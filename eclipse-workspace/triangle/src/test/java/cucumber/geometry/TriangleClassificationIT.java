package cucumber.geometry;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
    "html:target/cucumber-reports", 
    "json:target/cucumber.json",
    "pretty:target/cucumber-pretty.txt",
    "junit:target/cucumber-results.xml"}, 
   features = "src/test/cucumber/features")
public class TriangleClassificationIT {

}
