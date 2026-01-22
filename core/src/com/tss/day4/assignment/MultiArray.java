package com.tss.day4.assignment;

import java.util.Scanner;

public class MultiArray {

    public static Scanner scanner = new Scanner(System.in);
    //    public static int[][][] array_storage = totalArray();
//    public static int total_arrays=array_storage.length;
    public static int[][][] arrayStorage;

    public static void main(String[] args) {

        System.out.println("Enter the number of matrices you want to operate with");
        int totalArrays = scanner.nextInt();
        arrayStorage = new int[totalArrays][][];

        while (true) {
            System.out.println("Available Operations:\n1. Create Matrix\n2. Display Matrix\n3. Add 2 Matrices\n4. Multiply 2 Matrices\n5. Check Magical Matrix\n6. Check Prime-Harmonic Matrix\n7. Display All Matrices\n8. Replace Matrix \n9. Destroy Matrix\n10.Exit");
            System.out.println("Enter the operation number you want to perform");
            int user_choice = scanner.nextInt();
            switch (user_choice) {
                case 1: {
                    boolean allCreated = true;
                    for (int i = 0; i < totalArrays; i++) {
                        if (arrayStorage[i] == null) {
                            allCreated = false;
                            break;
                        }
                    }
                    if (allCreated) {
                        System.out.println("All matrices have already been created. No empty slots available.");
                        break;
                    }
                    boolean createMore = true;
                    for (int i = 0; i < totalArrays && createMore; i++) {
                        if (arrayStorage[i] != null) {
                            continue;
                        }
                        System.out.println("Creating matrix " + (i + 1));
                        arrayStorage[i] = createMatrix();
                        if (i == totalArrays - 1) {
                            break;
                        }
                        while (true) {
                            System.out.println("Do you want to create another matrix? (choose either yes or no)");
                            String choice = scanner.next().trim();
                            if (choice.equalsIgnoreCase("yes")) {
                                break;
                            } else if (choice.equalsIgnoreCase("no")) {
                                createMore = false;
                                break;
                            } else {
                                System.out.println("Invalid input. Please type only 'yes' or 'no'.");
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Which matrix do you want to display ?");
                    int arrayNumber = scanner.nextInt();
                    if (checkSingleArray(arrayNumber)) {
                        displayMatrix(arrayStorage[arrayNumber - 1]);
                    }
                    break;
                }
                case 3: {
                    while (true) {
                        ensureTwoMatricesExist();
                        displayAll(arrayStorage);
                        System.out.println("Which two matrices do you want to add ?");
                        int array1Number = scanner.nextInt();
                        int array2Number = scanner.nextInt();

                        if (checkDoubleArray(array1Number, array2Number)) {
                            continue;
                        }
                        if (arrayStorage[array1Number - 1].length != arrayStorage[array2Number - 1].length || arrayStorage[array1Number - 1][0].length != arrayStorage[array2Number - 1][0].length) {
                            System.out.println("Matrices must have the SAME dimensions. Please re-choose.");
                            continue;
                        }
                        addMatrix(arrayStorage[array1Number - 1], arrayStorage[array2Number - 1]);
                        break;
                    }
                    break;
                }
                case 4: {
                    while (true) {
                        ensureTwoMatricesExist();
                        displayAll(arrayStorage);
                        System.out.println("Which two matrices do you want to multiply ?");
                        int array1Number = scanner.nextInt();
                        int array2Number = scanner.nextInt();

                        if (checkDoubleArray(array1Number, array2Number)) {
                            continue;
                        }
                        if (arrayStorage[array1Number - 1][0].length != arrayStorage[array2Number - 1].length) {
                            System.out.println("Matrix multiplication not possible.");
                            continue;
                        }
                        multiplyMatrix(arrayStorage[array1Number - 1], arrayStorage[array2Number - 1]);
                        break;
                    }
                    break;
                }
                case 5: {
                    while (true) {
                        ensureAtLeastOneMatrixExists();
                        displayAll(arrayStorage);
                        System.out.println("Which matrix would you like to verify as a Magical Matrix ?");
                        int arrayNumber = scanner.nextInt();

                        if (!checkSingleArray(arrayNumber)) {
                            continue;
                        }
                        if (isMagicSquare(arrayStorage[arrayNumber - 1])) {
                            System.out.println("The Matrix is Magical Matrix");
                        } else {
                            System.out.println("The Matrix is not Magical Matrix");
                        }
                        break;
                    }
                    break;
                }
                case 6: {
                    while (true) {
                        ensureAtLeastOneMatrixExists();
                        displayAll(arrayStorage);
                        System.out.println("Which matrix would you like to verify as a Prime Harmonic Matrix ?");
                        int arrayNumber = scanner.nextInt();

                        if (!checkSingleArray(arrayNumber)) {
                            System.out.println("Enter a valid matrix number.");
                            continue;
                        }
                        if (isPrimeHarmonic(arrayStorage[arrayNumber - 1])) {
                            System.out.println("The matrix is Prime Harmonic Matrix");
                        } else {
                            System.out.println("The matrix is not Prime Harmonic Matrix");
                        }
                        break;
                    }
                    break;
                }

                case 7: {
                    displayAll(arrayStorage);
                    break;
                }
                case 8: {
                    while (true) {
                        ensureAtLeastOneMatrixExists();
                        displayAll(arrayStorage);
                        System.out.println("Which matrix do you want to replace?");
                        int index = scanner.nextInt();
                        if (!checkSingleArray(index)) {
                            continue;
                        }
                        System.out.println("Enter new matrix values:");
                        int[][] newMatrix = createMatrix();
                        reassignMatrix(index - 1, newMatrix);
                        break;
                    }
                    break;
                }
                case 9: {
                    while (true) {
                        ensureAtLeastOneMatrixExists();
                        displayAll(arrayStorage);
                        System.out.println("Which matrix do you want to destroy?");
                        int index = scanner.nextInt();
                        if (!checkSingleArray(index)) {
                            continue;
                        }
                        if (index >= 1 && index <= arrayStorage.length) {
                            destroyMatrix(index - 1);
                        } else {
                            System.out.println("Invalid matrix index.");
                        }
                        break;
                    }
                    break;
                }
                case 10: {
                    System.out.println("Hope you liked the service");
                    return;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }
    }

    private static int[][] createMatrix() {
        int matrixRows, matrixCols;
        while (true) {
            System.out.println("Enter the number of rows for the matrix:");
            matrixRows = scanner.nextInt();

            if (matrixRows > 0) {
                break;
            }
            System.out.println("Number of rows must be a POSITIVE integer. Please try again.");
        }

        while (true) {
            System.out.println("Enter the number of columns for the matrix:");
            matrixCols = scanner.nextInt();

            if (matrixCols > 0) {
                break;
            }
            System.out.println("Number of columns must be a POSITIVE integer. Please try again.");
        }
        System.out.println("Enter matrix elements:");
        int[][] matrix = new int[matrixRows][matrixCols];
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void displayMatrix(int[][] matrix) {
        int matrixRows = matrix.length;
        int matrixCols = matrix[0].length;
        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void addMatrix(int[][] matrixA, int[][] matrixB) {

        int matrixRows = matrixA.length;
        int matrixCols = matrixA[0].length;

        int[][] matrixC = new int[matrixRows][matrixCols];

        for (int i = 0; i < matrixRows; i++) {
            for (int j = 0; j < matrixCols; j++) {
                matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        System.out.println("\nResultant Matrix:");
        displayMatrix(matrixC);
    }

    private static void multiplyMatrix(int[][] matrixA, int[][] matrixB) {
        int matrixARows = matrixA.length;
        int matrixACols = matrixA[0].length;
        // int matrix_B_rows = matrix_B.length;
        int matrixBCols = matrixB[0].length;

        int[][] matrixC = new int[matrixARows][matrixBCols];

        for (int i = 0; i < matrixARows; i++) {
            for (int j = 0; j < matrixBCols; j++) {
                for (int k = 0; k < matrixACols; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        System.out.println("\nResultant Matrix:");
        displayMatrix(matrixC);
    }

    private static boolean isMagicSquare(int[][] array) {
        int arrayRows = array.length;
        int arrayCols = array[0].length;
        int magicSum = 0, diagonal1Sum = 0, diagonal2Sum = 0;

        if (arrayRows != arrayCols) {
            return false;
        }

        for (int i = 0; i < arrayCols; i++) {
            magicSum += array[0][i];
        }

        for (int i = 0; i < arrayRows; i++) {
            diagonal1Sum += array[i][i];
            diagonal2Sum += array[i][arrayRows - 1 - i];
            int rowSum = 0, colSum = 0;

            for (int j = 0; j < arrayCols; j++) {
                rowSum += array[i][j];
                colSum += array[j][i];
            }
            if (rowSum != magicSum || colSum != magicSum) {
                return false;
            }
        }
        return diagonal1Sum == magicSum && diagonal2Sum == magicSum;

    }

    private static boolean isPrimeHarmonic(int[][] array) {
        int arrayRows = array.length;
        int arrayCols = array[0].length;

        for (int i = 0; i < arrayRows; i++) {
            int count = 0;
            for (int j = 0; j < arrayCols; j++) {

                if (isPrimeNumber(array[i][j])) {
                    count++;
                }
            }
            if (count != 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void displayAll(int[][][] arrayStorage) {
        boolean hasMatrix = false;
        for (int i = 0; i < arrayStorage.length; i++) {
            if (arrayStorage[i] == null) {
                continue;
            }
            if (!hasMatrix) {
                System.out.println("Currently available matrices:");
                hasMatrix = true;
            }
            System.out.println("Matrix " + (i + 1) + ":");
            displayMatrix(arrayStorage[i]);
            System.out.println();
        }
        if (!hasMatrix) {
            System.out.println("No matrices available.");
        }
    }

    private static boolean checkSingleArray(int arrayNumber) {
        if (arrayNumber < 1 || arrayNumber > arrayStorage.length) {
            System.out.println("Invalid matrix index.");
            return false;
        }
        if (arrayStorage[arrayNumber - 1] == null) {
            System.out.println("Matrix " + arrayNumber + " not created yet.");
            System.out.println("Please create the matrix now:");
            arrayStorage[arrayNumber - 1] = createMatrix();
        }
        return true;
    }

    private static boolean checkDoubleArray(int array1Number, int array2Number) {
        if (array1Number < 1 || array1Number > arrayStorage.length
                || array2Number < 1 || array2Number > arrayStorage.length) {

            System.out.println("Invalid matrix index.");
            return true;
        }
        if (arrayStorage[array1Number - 1] == null) {
            System.out.println("Matrix " + array1Number + " not created yet.");
            System.out.println("Please create it now:");
            arrayStorage[array1Number - 1] = createMatrix();
        }
        if (arrayStorage[array2Number - 1] == null) {
            System.out.println("Matrix " + array2Number + " not created yet.");
            System.out.println("Please create it now:");
            arrayStorage[array2Number - 1] = createMatrix();
        }
        return false;
    }

    private static void destroyMatrix(int index) {
        if (index < 0 || index >= arrayStorage.length) {
            System.out.println("Invalid matrix index.");
            return;
        }
        if (arrayStorage[index] == null) {
            System.out.println("Matrix already empty.");
            return;
        }
        arrayStorage[index] = null;
        System.out.println("Matrix at index " + (index + 1) + " destroyed.");
    }

    private static void reassignMatrix(int index, int[][] newMatrix) {
        if (index < 0 || index >= arrayStorage.length) {
            System.out.println("Invalid matrix index.");
            return;
        }
        arrayStorage[index] = newMatrix;
        System.out.println("Matrix at index " + (index + 1) + " reassigned.");
    }

    private static void ensureAtLeastOneMatrixExists() {
        boolean exists = false;
        for (int[][] arrayStorage1 : arrayStorage) {
            if (arrayStorage1 != null) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            System.out.println("No matrices exist. Creating first matrix now:");
            arrayStorage[0] = createMatrix();
        }
    }

    private static void ensureTwoMatricesExist() {
        int count = 0;
        for (int[][] arrayStorage1 : arrayStorage) {
            if (arrayStorage1 != null) {
                count++;
            }
        }
        for (int i = 0; count < 2 && i < arrayStorage.length; i++) {
            if (arrayStorage[i] == null) {
                System.out.println("Creating matrix " + (i + 1) + " for operation:");
                arrayStorage[i] = createMatrix();
                count++;
            }
        }
    }
}
