package com.natalielmclaren;

import java.io.Console;
import java.util.ArrayList;

public class Rover {

    private int x = 0;
    private int y = 0;
    private char direction = 'N';
    private String command;

    /**
     *
     * @param _x
     * @param _y
     * @param _direction
     */
    public Rover(int _x, int _y, char _direction, String _command) {
        this.x = _x;
        this.y = _y;
        this.direction = _direction;
        this.command = _command;
    }

    /**
     *
     * @return
     */
    public String getPosition() {

        return Integer.toString(this.x) +
                " "
                + Integer.toString(this.y) +
                " " +
                this.direction;
    }

    /**
     *
     *
     */
    public void processCommand() {
        for(int i = 0; i < this.command.length(); i++) {
            navigate(this.command.charAt(i));
        }
    }


    /**
     *
     * @param _command
     */
    public void navigate(char _command) {

        switch(_command) {
            case 'L':
                turn(_command);
                break;
            case 'R':
                turn(_command);
                break;
            case 'M':
                move();
                break;
        }
    }

    /**
     *
     * @param _newDirection
     */
    private void turn(char _newDirection) {

        if(_newDirection == 'L') {
            switch (this.direction) {
                case 'N':
                    this.direction = 'W';
                    break;
                case 'W':
                    this.direction = 'S';
                    break;
                case 'S':
                    this.direction = 'E';
                    break;
                case 'E':
                    this.direction = 'N';
                    break;
            }
        } else if(_newDirection == 'R') {
            switch(this.direction) {
                case 'N':
                    this.direction = 'E';
                    break;
                case 'E':
                    this.direction = 'S';
                    break;
                case 'S':
                    this.direction = 'W';
                    break;
                case 'W':
                    this.direction = 'N';
                    break;
            }
        }
    }

    /**
     *
     */
    private void move() {

        if (this.direction == 'N') {
            this.y++;
        } else if (this.direction == 'E') {
            this.x++;
        } else if (this.direction == 'S') {
            this.y--;
        } else if (this.direction == 'W') {
            this.x--;
        }
    }
}
