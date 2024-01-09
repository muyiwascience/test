Feature: Start a Rover


  Background:
    Given I start a rover

  Scenario Outline: Start a new rover with <CoordinateX>, <CoordinateY>, and <direction>
    When I change the rover's position to <CoordinateX>, <CoordinateY> in the "<direction>"
    Then the rover's is positioned to <CoordinateX>, <CoordinateY> in the "<direction>"
    Examples:
      | CoordinateX | CoordinateY | direction |
      | 1           | 3           | N         |
      | 2           | 1           | S         |
      | 1           | 1           | E         |
      | 2           | 2           | W         |


  Scenario Outline: Move the rover forward in a <direction>
    When I change the rover's position to <InitialCoordinateX>, <InitialCoordinateY> in the "<direction>"
    And I send the command "<commands>"
    Then the rover's is positioned to <ExpectedCoordinateX>, <ExpectedCoordinateY> in the "<direction>"
    Examples:
      | direction | InitialCoordinateX | InitialCoordinateY | direction | commands | ExpectedCoordinateX | ExpectedCoordinateY | direction |
      | N         | 1                  | 2                  | N         | M        | 1                   | 3                   | N         |
      | E         | 3                  | 3                  | E         | M        | 4                   | 3                   | E         |
      | S         | 1                  | 2                  | S         | M        | 1                   | 1                   | S         |
      | W         | 1                  | 2                  | W         | M        | 0                   | 2                   | W         |

  Scenario Outline: Move the rover in the direction north
    When I change the rover's position to <InitialCoordinateX>, <InitialCoordinateY> in the "<direction>"
    And I send the command "<commands>"
    Then the rover's is positioned to <ExpectedCoordinateX>, <ExpectedCoordinateY> in the "<direction>"
    Examples:
      | direction | InitialCoordinateX | InitialCoordinateY | direction | commands  | ExpectedCoordinateX | ExpectedCoordinateY | direction |
      | N         | 55                 | 12                 | N         | LMLMLMLMM | 55                  | 13                  | N         |



