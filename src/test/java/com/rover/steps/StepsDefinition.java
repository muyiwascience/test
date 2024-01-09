package com.rover.steps;

import com.rover.Rover;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StepsDefinition {
    private Rover rover;

    @Given("^I start a rover$")
    public void iStartARover() throws Throwable {
        rover = new Rover();

    }

    @When("^I change the rover's position to (\\d+), (\\d+) in the \"([^\"]*)\"$")
    public void iChangeTheRoverSPositionToInThe(int x, int y, String direction) throws Throwable {
        int position;
        switch (direction) {
            case "N":
                position = Rover.N;
                break;
            case "E":
                position = Rover.E;
                break;
            case "S":
                position = Rover.S;
                break;
            case "W":
                position = Rover.W;
                break;
            default:
                throw new IllegalArgumentException("Invalid position");
        }
        rover.setPosition(x, y, position);


    }

    @Then("^the rover's is positioned to (\\d+), (\\d+) in the \"([^\"]*)\"$")
    public void theRoverSIsPositionedToInThe(int resultX, int resultY, String resultDirection) throws Throwable {
        rover.printPosition();
        Assert.assertEquals(resultX, (int) rover.x);
        Assert.assertEquals(resultY, (int) rover.y);
        Assert.assertEquals(resultDirection, rover.getDirectionAsString(rover.direction));

    }


    @When("^I send the command \"([^\"]*)\"$")
    public void iSendTheCommand(String command) throws Throwable {
        rover.process(command);
    }
}
