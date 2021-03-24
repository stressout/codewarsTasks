/** There is a Pascal triangle, with horizontal lines starting at 0.
     You need to compute the sum of the squares of binomial coefficients on a given horizontal line with a function called easyLine.
     Write a program that calculates easyLine(n), where n is the number of the horizontal line, the function takes the parameter n (n>= 0) 
     and returns the sum of squares of binomial coefficients on a given horizontal line.*/

public static BigInteger easyLine(int n) {
        BigInteger[][] pascalTriangle = initializingPascalTriangle(n);
        for (int row = 2; row <= n; row++) { /** Цикл проходится по строкам, начиная со 2 строки, заканчивая строкой n. Начинаем со 2 строки по той причине, что значения 0 и 1 строк уже известны*/
            BigInteger[] valuesFromPreviousTriangleRow = fillArrayFromPreviousDimension(pascalTriangle[row - 1], row - 1); /** Получили массив со значениями, которые нужно вставить в текущую строку*/
            for (int currentRowCell = 1; currentRowCell <= pascalTriangle[row].length - 2; currentRowCell++) { /** Цикл для заполнения текущей строки треугольника Паскаля нужными значениями, (pascalTriangle[row].length - 2) поскольку последний элемент уже известен, это единица*/
                pascalTriangle[row][currentRowCell] = valuesFromPreviousTriangleRow[currentRowCell - 1];
            }
        }
        BigInteger result = BigInteger.valueOf(0);
        for (int currentCell = 0; currentCell < pascalTriangle[n].length; currentCell++) /** Цикл для сложения суммы квадратов треугольника Паскаля, можно сократить код, но решил оставить так*/
        {
            BigInteger cellValue = new BigInteger(String.valueOf(pascalTriangle[n][currentCell]));
            cellValue = cellValue.multiply(cellValue);
            result = result.add(cellValue);
        }
        return result;
    }

    /** Метод для инициализации массива(представление треугольника Паскаля) дефолтными значениями, где начало и конец строки имеют значение 1
     * Принимает параметр rows, именно это количество строк треугольника Паскаля будет создано*/
    public static BigInteger[][] initializingPascalTriangle(int rows) {
        BigInteger[][] pascalTriangle = new BigInteger[rows + 1][];
        pascalTriangle[0] = new BigInteger[1];
        pascalTriangle[0][0] = BigInteger.valueOf(1);
        for (int i = 1; i <= rows; i++) { /** Цикл для выделения необходимого количества памяти под значения текущей строки(значение переменной row в первом цикле метода easyLine) треугольника Паскаля*/
            pascalTriangle[i] = new BigInteger[i + 1];
            for (int j = 0; j < 2; j++) /** Цикл для заполнениями дефолтными значениями нулевого и последнего индексов массива*/
                pascalTriangle[i][j == 0 ? j : pascalTriangle[i].length - j] = BigInteger.valueOf(1);
        }
        return pascalTriangle;
    }

    /** Метод для заполнения массива(представление треугольника Паскаля) конкретными значениями из предыдущей строки
     * Принцип получения необходимых чисел следующий: если у нас есть треугольник Паскаля и нам нужно узнать значения в 4 строке, то нам нужно знать значения в 3 строке(переменная
     * PreviousTriangleRow отвечает за номер предыдущей строки, а PreviousTriangleArray указывает на массив предыдущей строки),
     * в 3 строке у нас следующие значения 1 3 3 1, в 4 строке будет 5 значений (номер строки + 1), 2 числа из которых дефолтные единицы, то чтобы получить 3 значения,
     * нужно сложить в 3 строке числа: 1 + 3 = 4, 3 + 3 = 6, 3 + 1 = 4, соответственно, в 4 строке у нас будут следующие числа 1 4 6 4 1*/
    public static BigInteger[] fillArrayFromPreviousDimension(BigInteger[] PreviousTriangleArray, long PreviousTriangleRow) {
        BigInteger[] resultArray = new BigInteger[PreviousTriangleArray.length - 1];
        for (int i = 0; i < PreviousTriangleRow; i++) /** Цикл для получения значений предыдущей строки, которые будут вставляться в ту строку, на которой вызвался этот метод*/
            resultArray[i] = PreviousTriangleArray[i].add(PreviousTriangleArray[i + 1]);
        return resultArray;
    }
