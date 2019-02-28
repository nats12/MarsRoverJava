package com.natalielmclaren;

import java.util.ArrayList;

public class Grid {

    ArrayList<Rover> rovers;

    public Grid() {
        this.rovers = new ArrayList<Rover>();
    }

    public void addRover(Rover _rover) {
        this.rovers.add(_rover);
    }

    public ArrayList<Rover> getRovers() {
        return this.rovers;
    }
}
