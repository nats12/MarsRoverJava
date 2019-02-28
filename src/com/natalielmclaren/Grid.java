package com.natalielmclaren;

import java.util.ArrayList;

public class Grid {

    int[] size;
    ArrayList<Rover> rovers;

    public Grid(int[] _size) {
        this.size = _size;
        this.rovers = new ArrayList<Rover>();
    }

    public void addRover(Rover _rover) {
        this.rovers.add(_rover);
    }

    public ArrayList<Rover> getRovers() {
        return this.rovers;
    }

    public int[] getSize() {
        return size;
    }
}
