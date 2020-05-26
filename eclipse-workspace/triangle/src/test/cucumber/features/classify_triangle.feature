Feature: Classify Triangles
  As a student I want to use classify triangles.

  Scenario: Determination of a right angled triangle
    Given a triangle
		When I enter the sides 5.0, 4.0, 3.0
		Then the resulting type should be "00001"
