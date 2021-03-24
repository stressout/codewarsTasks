/** There are 6 squares that have the following lengths of sides: 1, 1, 2, 3, 5, 8. The sum of the perimeter of these squares is equal: 4 * (1 + 1 + 2 + 3 + 5 + 8) = 80
     Calculate the sum of perimeters of all squares if there are n + 1 squares arranged in the same way as in the example */

    /** Аргумент n определяет количество квадратов */
    public static BigInteger perimeter(BigInteger n) {
        BigInteger[] fibonacciArray = new BigInteger[n.intValue() + 1]; /** Создание массива для последовательности чисел фибонначи */
        for (int i = 0; i <= n.intValue(); i++) /** Цикл для заполнения массива последовательностью чисел фибонначи */
            fibonacciArray[i] = i == 0 || i == 1 ? BigInteger.valueOf(1) : fibonacciArray[i - 1].add(fibonacciArray[i - 2]);
        BigInteger perimeter = BigInteger.valueOf(0); /** Переменная для хранения расчета периметра квадратов */
        for (int i = 0; i <= n.intValue(); i++) { /** Цикл для сложения чисел фибонначи до тех пор, пока индекс не дойдет до номера позиции числа в последовательности фибонначи */
            fibonacciArray[i] = (i == 0 || i == 1 ? BigInteger.valueOf(1) : fibonacciArray[i - 1].add(fibonacciArray[i - 2]));
            perimeter = perimeter.add(fibonacciArray[i]);
        }
//        Arrays.stream(fibonacciArray).forEach((value) -> perimeter[0] = perimeter[0].add(value)); Можно реализовать так, тогда придется делать переменную perimeter final и объявлять как массив
        return perimeter.multiply(BigInteger.valueOf(4)); /** Результирующее значение - периметр всех квадратов */
    }
