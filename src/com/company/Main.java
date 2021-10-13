package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int counter;
        System.out.println("This program checks whether the point lies on the side of the polygon");
        counter = inputData();
        checkCounter(counter);
    }

    public static int inputData(){
        Scanner input = new Scanner(System.in);
        int counter = 0;
        int numOfVer;
        int[] pointCoord = new int[2];
        numOfVer = checkInputData("Enter the number of vertices of the polygon: ", input);
        while (numOfVer < 3){
            numOfVer = checkInputData("Number of vertices should be more than 2: ", input);
        }
        int[][] verCoordinates = new int[2][numOfVer];
        pointCoord[0] = checkInputData("Enter x - coordinate of point: ", input);
        pointCoord[1] = checkInputData("Enter y - coordinate of point: ", input);
        for (int i = 0; i < numOfVer; i++){
            verCoordinates[0][i] = checkInputData("Enter x - coordinate of vertex: ", input);
            verCoordinates[1][i] = checkInputData("Enter y - coordinate of vertex: ", input);
        }
        counter = ifPointOnVector(pointCoord, verCoordinates, numOfVer);
        input.close();
        return counter;
    }

    public static int ifPointOnVector(int[] pointCoord, int[][] verCoordinates, int numOfVer) {
        int counter = 0;
        int[] vectorOfSide = new int[2];
        int[] vectorOfPoint = new int[2];
        int n = numOfVer - 1;
        double finderBundle;
        for (int i = 0; i < n; i++){
            vectorOfSide[0] = verCoordinates[0][i] - verCoordinates[0][i+1];
            vectorOfSide[1] = verCoordinates[1][i] - verCoordinates[1][i+1];
            vectorOfPoint[0] = pointCoord[0] - verCoordinates[0][i];
            vectorOfPoint[1] = pointCoord[1] - verCoordinates[1][i];
            finderBundle = vectorOfSide[0] * vectorOfPoint[1] - vectorOfPoint[0] * vectorOfSide[1];
            if (finderBundle == 0){
                counter++;
            }
        }
        vectorOfSide[0] = verCoordinates[0][0] - verCoordinates[0][n];
        vectorOfSide[1] = verCoordinates[1][0] - verCoordinates[1][n];
        vectorOfPoint[0] = pointCoord[0] - verCoordinates[0][0];
        vectorOfPoint[1] = pointCoord[1] - verCoordinates[1][0];
        finderBundle = vectorOfSide[0] * vectorOfPoint[1] - vectorOfPoint[0] * vectorOfSide[1];
        if (finderBundle == 0){
            counter++;
        }
        return counter;
    }

    public static void checkCounter(int counter){
        if (counter > 0){
            System.out.println("The point lies on the side of polygon");
        } else{
            System.out.println("The point doesn't lies on the side of polygon");
        }
    }
    public static int checkInputData(String str, Scanner input) {
        boolean isIncorrect;
        int number = 0;
        System.out.print(str);
        do {
            isIncorrect = false;
            try {
                number = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.err.print("Error! Enter the number: ");
                isIncorrect = true;
            }
        } while (isIncorrect);
        return number;
    }

}
