package com.natalielmclaren;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Main main = new Main();
    int gridSize[] = new int[2];

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Enter the grid size: ");
        String enteredGridSize = getInputGridSize();

        String splitGridSize[] = enteredGridSize.split(" ");


        main.gridSize[0] = Integer.parseInt(splitGridSize[0]);
        main.gridSize[1] = Integer.parseInt(splitGridSize[1]);

        Grid grid = new Grid(main.gridSize);

        int numberOfRovers = getInputNumberOfRovers();

        // Create a string array to store the rover data
        String enteredRoverData[] = new String[numberOfRovers];

        for (int i = 0; i < enteredRoverData.length; i++) {

            System.out.print("Enter the details of rover " + (i + 1) + " : ");
            enteredRoverData[i] = getInputRoverData();

            String splitData[] = splitDataByWhitespace(enteredRoverData, i);

            int x = Integer.parseInt(splitData[0]);
            int y = Integer.parseInt(splitData[1]);
            char direction = splitData[2].charAt(0);
            String command = splitData[3];

            Rover rover = createRover(x, y, direction, command);
            addRoverToGrid(rover, grid);

        }

        ArrayList<Rover> rovers = grid.getRovers();

        navigateRovers(rovers);
    }

    /**
     *
     */
    public static String getInputGridSize() {

        return scanner.nextLine();
    }
    /**
     *
     * @param rovers
     */
    public static void navigateRovers(ArrayList<Rover> rovers) {

        for(int i = 0; i < rovers.size(); i++) {

            rovers.get(i).processCommand();
            System.out.println(rovers.get(i).getPosition());
        }
    }

    /**
     *
     * @return
     */
    public static String getInputRoverData() {

        return scanner.nextLine();
    }

    /**
     *
     * @return
     */
    public static int getInputNumberOfRovers() {

        // Enter the number of rovers being sent
        System.out.print("Enter how many rovers: ");
        return Integer.parseInt(scanner.nextLine());

    }

    /**
     *
     * @param arrayOfRoverData
     * @param index
     * @return
     */
    public static String[] splitDataByWhitespace(String arrayOfRoverData[], int index) {

        return arrayOfRoverData[index].split(" ");
    }

    /**
     *
     * @param x
     * @param y
     * @param direction
     * @param command
     */
    public static Rover createRover(int x, int y, char direction, String command) {

        return new Rover(x, y, direction, command);

    }

    /**
     *
     * @param rover
     */
    public static void addRoverToGrid(Rover rover, Grid grid) {

        grid.addRover(rover);
    }
}
