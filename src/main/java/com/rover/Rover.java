package com.rover;

public class Rover {
    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;
    public Integer x = 0;
    public Integer y = 0;
    public Integer direction = N;

    public Rover() {
    }

    public void setPosition(Integer x, Integer y, Integer direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void printPosition() {
        char dir = 'N';
        if (direction == 1) {
            dir = 'N';
        } else if (direction == 2) {
            dir = 'E';
        } else if (direction == 3) {
            dir = 'S';
        } else if (direction == 4) {
            dir = 'W';
        }
        System.out.println(x + " " + y + " " + dir);
    }


    public void process(String commands) {
        for (int idx = 0; idx < commands.length(); idx++) {
            process(commands.charAt(idx));
        }
    }


    private void process(Character command) {
        if (command.equals('L')) {
            turnLeft();
        } else if (command.equals('R')) {
            turnRight();
        } else if (command.equals('M')) {
            move();
        } else {
            throw new IllegalArgumentException(
                    "Mars language!");
        }
    }

    private void move() {
        if (direction == N) {
            this.y++;
        } else if (direction == E) {
            this.x++;
        } else if (direction == S) {
            this.y--;
        } else if (direction == W) {
            this.x--;
        }
    }


    private void turnLeft() {
        direction = (direction - 1) < N ? W : direction - 1;
    }

    private void turnRight() {
        direction = (direction + 1) > W ? N : direction + 1;
    }

    public String getDirectionAsString(Integer direction) {
        if (direction.equals(Rover.N)) {
            return "N";
        } else if (direction.equals(Rover.E)) {
            return "E";
        } else if (direction.equals(Rover.S)) {
            return "S";
        } else if (direction.equals(Rover.W)) {
            return "W";
        } else {
            throw new IllegalArgumentException("Invalid direction");
        }
    }

    public static void main(String[] args) {
        Rover rover = new Rover();
        rover.setPosition(1, 2, N);
        rover.process("LMLMLMLMM");
        rover.printPosition();
        rover.setPosition(3, 3, E);
        rover.process("MMRMMRMRRM");
        rover.printPosition();
        rover.setPosition(55, 13, N);
        rover.process("LMLMLMLMM");
        rover.printPosition();
    }
}