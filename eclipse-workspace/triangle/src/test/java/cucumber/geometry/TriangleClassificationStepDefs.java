package cucumber.geometry;

import static org.junit.Assert.assertEquals;

import geometry.Triangle;
import geometry.TriangleImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TriangleClassificationStepDefs {

  Triangle triangle;

  @Given("a triangle")
  public void init_feature() {}

  @When("I enter the sides {double}, {double}, {double}")
  public void add_the_side_lengths(double a, double b, double c) throws Exception {
    triangle = new TriangleImpl(a, b, c);
  }

  @Then("the resulting type should be {string}")
  public void the_type_should_be(String expectedType) {
    assertEquals("Triangle Type", expectedType, triangle.toString());
  }

}
