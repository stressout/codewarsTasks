package explain;

import java.io.FileReader;

public class ExplainClass {

    private final String explanation;

    public ExplainClass() {
        explanation = "There is a Pascal triangle, with horizontal lines starting at 0. (from top)\n" +
                "You need to compute the sum of the squares of binomial coefficients on a given horizontal line with a function called computeBinomialCoefficients.\n" +
                "Write a program that calculates computeBinomialCoefficients(n), where n is the number of the horizontal line, the function takes the parameter n (n>= 0)\n" +
                "\tand returns the sum of squares of binomial coefficients on a given horizontal line.\n" +
                "The principle for getting the numbers we need is as follows: if we have a Pascal triangle and we need to know the values in line 4, we need to know the values in line 3\n" +
                "In line 3 we have the following values 1 3 3 1, in line 4 will be 5 values (line's number + 1), 2 numbers of which are default units, then to get 3 values,\n" +
                "\twe need to sum the numbers in line 3: 1 + 3 = 4, 3 + 3 = 6, 3 + 1 = 4, respectively, in line 4 we will have the following numbers 1 4 6 4 1";
    }

    public void explain() {
        Triangle.drawTriangle();
        System.out.println(explanation + "\n");
    }

    private static class Triangle {

        private static final String pathToFileTriangle = "src\\main\\resources\\Triangle.txt";

        private static void drawTriangle() {
            try (FileReader triangleReader = new FileReader(pathToFileTriangle)) {
                System.out.print("\n\t\t\t\t\t");
                while (triangleReader.ready()) {
                    char ch = (char) triangleReader.read();
                    System.out.print(ch);
                    if (ch == '\n')
                        System.out.print("\t\t\t\t\t");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            System.out.println("\n");
        }
    }

}
