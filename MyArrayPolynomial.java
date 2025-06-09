package hus.oop.rootsolver;

public class MyArrayPolynomial extends MyAbstractPolynomial {
    private static final int DEFAULT_CAPACITY = 8;
    private double[] coefficents;
    private int size;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyArrayPolynomial() {
        this.coefficents = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= size) return 0.0;
        return coefficents[index];
    }

    @Override
    public double[] coefficients() {
        /* TODO */

        return this.coefficents;
    }

    @Override
    public void addAtStart(double coefficient) {
        if (size >= coefficents.length) allocateMore();

        System.arraycopy(coefficents, 0, coefficents, 1, size);
        coefficents[0] = coefficient;

        ++size;
    }

    @Override
    public void addAtEnd(double coefficient) {
        if (size >= coefficents.length) allocateMore();
        coefficents[size++] = coefficient;
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        if (index < 0 || index > size) return;
        if (size >= coefficents.length) allocateMore();

        System.arraycopy(coefficents, index, coefficents, index + 1, size - index);
        coefficents[index] = coefficient;

        ++size;
    }

    @Override
    public void set(int index, double coefficient) {

        if (index < 0) return;

        while (index >= coefficents.length) allocateMore();

        coefficents[index] = coefficient;
    }

    @Override
    public int degree() {

        return size;

    }

    @Override
    public double evaluate(double x) {
        double result = 0.0;

        for (int i = size - 1; i >= 0; i--){
            result = result * x + coefficents[i];
        }

        return result;
    }

    @Override
    public MyArrayPolynomial derivative() {
        var result = new MyArrayPolynomial();

        for (int i = 0; i < size; i++){
            result.addAtEnd(coefficents[i] * (size - i));
        }

        return result;
    }

    @Override
    public MyArrayPolynomial plus(MyPolynomial another) {
        int maxDegree = Math.max(this.size, another.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();

        for (int i = 0; i < maxDegree; i++){
            double a = this.coefficientAt(i);
            double b = another.coefficientAt(i);
            result.addAtEnd(a + b);
        }
        return result;
    }

    @Override
    public MyArrayPolynomial minus(MyPolynomial another) {
        int maxDegree = Math.max(this.size, another.degree());
        MyArrayPolynomial result = new MyArrayPolynomial();

        for (int i = 0; i < maxDegree; i++){
            double a = this.coefficientAt(i);
            double b = another.coefficientAt(i);
            result.addAtEnd(a - b);
        }
        return result;
    }


    @Override
    public MyArrayPolynomial multiply(MyPolynomial another) {
        int newDegree = this.degree() + another.degree() - 2;
        double[] resultCoeffs = new double[newDegree + 1];

        for (int i = 0; i < this.degree(); i++) {
            for (int j = 0; j < another.degree(); j++) {
                resultCoeffs[i + j] += this.coefficientAt(i) * another.coefficientAt(j);
            }
        }

        MyArrayPolynomial result = new MyArrayPolynomial();
        for (double coeff : resultCoeffs) {
            result.addAtEnd(coeff);
        }
        return result;
    }

    /**
     * Thêm kích thước mảng gấp đôi để lưu đa thức khi cần thiết.
     */
    private void allocateMore() {
        double[] newCoeffs = new double[coefficents.length * 2];
        System.arraycopy(coefficents, 0, newCoeffs, 0, size);
        coefficents = newCoeffs;
    }
}
