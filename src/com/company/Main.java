package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("This program checks whether the point lies on the side of the polygon");
        Scanner input = new Scanner(System.in);
        int numOfVer;
        int[] firstVector = new int[2];
        int[] secondVector = new int[2];
        int[] vectorOfSide = new int[2];
        int[] vectorOfPoint = new int[2];
        double finderBundle;
        double scalarProduct;
        int counter = 0;
        int[] pointCoord = new int[2];
        pointCoord[0] = checkInputData("Enter x - coordinate of point: ", input);
        pointCoord[1] = checkInputData("Enter y - coordinate of point: ", input);
        numOfVer = checkInputData("Enter the number of vertices of the polygon: ", input);
        while (numOfVer < 3) {
            numOfVer = checkInputData("Number of vertices should be more than 2: ", input);
        }
        int n = numOfVer - 1;
        int[][] verCoordinates = new int[2][numOfVer];
        for (int i = 0; i < numOfVer; i++){
            verCoordinates[0][i] = checkInputData("Enter x - coordinate of vertex: ", input);
            verCoordinates[1][i] = checkInputData("Enter y - coordinate of vertex: ", input);
        }
        input.close();
        for (int i = 0; i < n; i++) {
            firstVector[0] = verCoordinates[0][i] - pointCoord[0];
            firstVector[1] = verCoordinates[1][i] - pointCoord[1];
            secondVector[0] = verCoordinates[0][i+1] - pointCoord[0];
            secondVector[1] = verCoordinates[1][i+1] - pointCoord[1];
            vectorOfSide[0] = verCoordinates[0][i] - verCoordinates[0][i+1];
            vectorOfSide[1] = verCoordinates[1][i] - verCoordinates[1][i+1];
            vectorOfPoint[0] = pointCoord[0] - verCoordinates[0][i];
            vectorOfPoint[1] = pointCoord[1] - verCoordinates[1][i];
            finderBundle = vectorOfSide[0] * vectorOfPoint[1] - vectorOfPoint[0] * vectorOfSide[1];
            scalarProduct = firstVector[0] * secondVector[0] + firstVector[1] * secondVector[1];
            if (scalarProduct < 1 && finderBundle == 0) {
                counter++;
            }
        }
        firstVector[0] = verCoordinates[0][n-1] - pointCoord[0];
        firstVector[1] = verCoordinates[1][n-1] - pointCoord[1];
        secondVector[0] = verCoordinates[0][n] - pointCoord[0];
        secondVector[1] = verCoordinates[1][n] - pointCoord[1];
        vectorOfSide[0] = verCoordinates[0][n] - verCoordinates[0][n-1];
        vectorOfSide[1] = verCoordinates[1][n] - verCoordinates[1][n-1];
        vectorOfPoint[0] = pointCoord[0] - verCoordinates[0][n];
        vectorOfPoint[1] = pointCoord[1] - verCoordinates[1][n];
        finderBundle = vectorOfSide[0] * vectorOfPoint[1] - vectorOfPoint[0] * vectorOfSide[1];
        scalarProduct = firstVector[0] * secondVector[0] + firstVector[1] * secondVector[1];
        if (scalarProduct < 1 && finderBundle == 0){
            counter++;
        }
        if (counter > 0){
            System.out.println("The point lies on the side of polygon");
        } else {
            System.out.println("The point doesn't lie on the side of polygon");
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
