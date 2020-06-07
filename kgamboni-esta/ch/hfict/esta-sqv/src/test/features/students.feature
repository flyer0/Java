Feature: Student management

  Background:
    Given the list of students
	| Jakob   | Lanz    | 1993-04-09 |
	| Peter   | Meier   | 1986-07-29 |
	| Stefan  | Thommen | 1991-03-23 |
	| Susanne | Huber   | 1989-09-02 |
    
  Scenario: Edit existing student
    When the student "Stefan Thommen" is selected
    Then the form displays
	| Stefan | Thommen |1991-03-23|

  Scenario: Modify existing student
    When the student "Stefan Thommen" is selected
    And the students lastname is modified to "Simpson"
    And the save button is pressed
    Then the table displays
	| Jakob   | Lanz    | 1993-04-09 |
	| Peter   | Meier   | 1986-07-29 |
	| Stefan  | Simpson | 1991-03-23 |
	| Susanne | Huber   | 1989-09-02 |
