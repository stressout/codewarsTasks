package engine;

import java.math.BigInteger;

public class BinomialCoefficients {

    public static BigInteger computeBinomialCoefficients(int n) {
        if (n < 0)
            throw new IllegalArgumentException("A value less than 0 is passed to the method");
        BigInteger[][] pascalTriangle = initializingPascalTriangle(n);
        for (int row = 2; row <= n; row++) { /** The cycle goes through the lines, starting from line 2 and ending with line n. We start with line 2 because the values of lines 0 and 1 are already known */
            BigInteger[] valuesFromPreviousTriangleRow = fillArrayFromPreviousDimension(pascalTriangle[row - 1], row - 1); /** We got an array with values to insert into the current line */
            for (int currentRowCell = 1; currentRowCell <= pascalTriangle[row].length - 2; currentRowCell++) { /** A cycle to fill the current row of a Pascal triangle with the desired values, (pascalTriangle[row].length - 2) since the last element is already known, it is one */
                pascalTriangle[row][currentRowCell] = valuesFromPreviousTriangleRow[currentRowCell - 1];
            }
        }
        BigInteger result = BigInteger.valueOf(0);
        for (int currentCell = 0; currentCell < pascalTriangle[n].length; currentCell++) /** Cycle for adding the sum of the squares of a Pascal triangle, you can shorten the code, but I decided to leave it like this */ {
            BigInteger cellValue = new BigInteger(String.valueOf(pascalTriangle[n][currentCell]));
            cellValue = cellValue.multiply(cellValue);
            result = result.add(cellValue);
        }
        return result;
    }

    /**
     * A method for initializing an array (representing a Pascal triangle) with default values, where the beginning and end of the rows have a value of 1
     * Accepts the parameter rows, this is the number of rows of the Pascal triangle will be created */
    private static BigInteger[][] initializingPascalTriangle(int rows) {
        BigInteger[][] pascalTriangle = new BigInteger[rows + 1][];
        pascalTriangle[0] = new BigInteger[1];
        pascalTriangle[0][0] = BigInteger.valueOf(1);
        for (int i = 1; i <= rows; i++) { /** A loop to allocate the necessary amount of memory for the value of the current row (the value of the row variable in the first loop of the easyLine method) of a Pascal triangle */
            pascalTriangle[i] = new BigInteger[i + 1];
            for (int j = 0; j < 2; j++) /** A loop for filling the zero and the last index of the array with default values */
                pascalTriangle[i][j == 0 ? j : pascalTriangle[i].length - j] = BigInteger.valueOf(1);
        }
        return pascalTriangle;
    }

    /**
     * A method for filling an array (a representation of a Pascal triangle) with specific values from the previous line */
    private static BigInteger[] fillArrayFromPreviousDimension(BigInteger[] PreviousTriangleArray, long PreviousTriangleRow) {
        BigInteger[] resultArray = new BigInteger[PreviousTriangleArray.length - 1];
        for (int i = 0; i < PreviousTriangleRow; i++) /** A loop to get the values of the previous line, which will be inserted into the line on which this method was called */
            resultArray[i] = PreviousTriangleArray[i].add(PreviousTriangleArray[i + 1]);
        return resultArray;
    }
}