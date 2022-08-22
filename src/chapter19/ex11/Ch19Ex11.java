package chapter19.ex11;

/**
 * @author swarfte
 * @title ComplexMatrix
 */
public class Ch19Ex11 {
    public static void main(String[] args) {
        Complex[][] matrix1 = new Complex[3][3];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = new Complex(Math.random() * 100, Math.random() * 100);
            }
        }
        Complex[][] matrix2 = new Complex[3][3];
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = new Complex(Math.random() * 100, Math.random() * 100);
            }
        }

        ComplexMatrix complexMatrix = new ComplexMatrix();
        ComplexMatrix.printResult19(matrix1, matrix2, complexMatrix.addMatrix(matrix1, matrix2), '+');
        System.out.println();
        ComplexMatrix.printResult19(matrix1, matrix2, complexMatrix.multiplyMatrix(matrix1, matrix2), '*');

    }


}

class Complex implements Comparable<Complex>, Cloneable {
    private double real;
    private double imaginary;

    public Complex() {
        this(0.0, 0.0);
    }

    public Complex(double real) {
        this(real, 0.0);
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getRealPart() {
        return real;
    }

    public double getImaginaryPart() {
        return imaginary;
    }

    public Complex add(Complex c) {
        return new Complex(real + c.real, imaginary + c.imaginary);
    }

    public Complex subtract(Complex c) {
        return new Complex(real - c.real, imaginary - c.imaginary);
    }

    public Complex multiply(Complex c) {
        return new Complex(real * c.real - imaginary * c.imaginary,
                real * c.imaginary + imaginary * c.real);
    }

    public Complex divide(Complex c) {
        double denom = c.real * c.real + c.imaginary * c.imaginary;
        return new Complex((real * c.real + imaginary * c.imaginary) / denom,
                (imaginary * c.real - real * c.imaginary) / denom);
    }

    public double getAbsoluteValue() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public String toString() {
        if (imaginary == 0) {
            return String.format("%f", real);
        } else if (real == 0) {
            return String.format("%fi", imaginary);
        } else if (imaginary < 0) {
            return String.format("%f - %fi", real, -imaginary);
        } else {
            return String.format("%f + %fi", real, imaginary);
        }
    }

    public int compareTo(Complex c) {
        if (real != c.real) {
            return (int) (real - c.real);
        } else {
            return (int) (imaginary - c.imaginary);
        }
    }

    public Complex clone() {
        return new Complex(real, imaginary);
    }

}

abstract class GenericMatrix<E> {
    protected abstract E add(E o1, E o2);

    protected abstract E multiply(E o1, E o2);

    protected abstract E zero();

    public E[][] addMatrix(E[][] matrix1, E[][] matrix2) {
        if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
            throw new IllegalArgumentException("Matrix dimensions must agree");
        }
        E[][] result = (E[][]) new Complex[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }
        return result;
    }

    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException("Matrix dimensions must agree");
        }
        E[][] result = (E[][]) new Complex[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                result[i][j] = zero();
                for (int k = 0; k < matrix1[0].length; k++) {
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }
        return result;
    }

    public static <E> void printResult(E[][] m1, E[][] m2, E[][] m3, char op) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                System.out.print(" " + m1[i][j]);
            }

            if (i == m1.length / 2) {
                System.out.print(" " + op + " ");
            } else {
                System.out.print("    ");
            }

            for (int j = 0; j < m2.length; j++) {
                System.out.print(" " + m2[i][j]);
            }

            if (i == m1.length / 2) {
                System.out.print(" " + "=" + " ");
            } else {
                System.out.print("    ");
            }

            for (int j = 0; j < m3.length; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class ComplexMatrix extends GenericMatrix<Complex> {
    protected Complex add(Complex c1, Complex c2) {
        return c1.add(c2);
    }

    protected Complex multiply(Complex c1, Complex c2) {
        return c1.multiply(c2);
    }

    protected Complex zero() {
        return new Complex(0.0, 0.0);
    }

    public static <E> void printResult19(E[][] m1, E[][] m2, E[][] m3, char op) {
        printResult(m1, m2, m3, op);
    }
}