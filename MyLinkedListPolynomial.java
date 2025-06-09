package hus.oop.rootsolver;

public class MyLinkedListPolynomial extends MyAbstractPolynomial {
    private MyLinkedList polynomial;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedListPolynomial() {
        /* TODO */
        this.polynomial = new MyLinkedList();
    }

    @Override
    public double coefficientAt(int index) {
        /* TODO */
        return polynomial.get(index);
    }

    @Override
    public double[] coefficients() {
        /* TODO */
        int n = polynomial.size();
        double[] result = new double[n];
        for (int i = 0; i < n; i++){
            result[i] = polynomial.get(i);
        }
        return result;
    }

    @Override
    public void addAtStart(double coefficient) {
        /* TODO */
        polynomial.insert(coefficient, 0);
    }

    @Override
    public void addAtEnd(double coefficient) {
        /* TODO */
        polynomial.add(coefficient);
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        /* TODO */
        if (index < 0) return;
        if (index >= polynomial.size()){
            // Bổ sung các phần tử 0 nếu thiếu
            while (polynomial.size() < index) {
                polynomial.add(0.0);
            }
            polynomial.add(coefficient);
        } 
        else{
            polynomial.insert(coefficient, index);
        }
    }

    @Override
    public void set(int index, double coefficient) {
        /* TODO */
        if (index >= 0 && index < polynomial.size()){
            polynomial.set(coefficient, index);
        }
    }

    @Override
    public int degree() {
        /* TODO */
        return polynomial.size() - 1;
    }

    @Override
    public double evaluate(double x) {
        /* TODO */
        double result = 0;

        for (int i = 0; i < polynomial.size(); i++){
            result += polynomial.get(i) * Math.pow(x, i);
        }

        return result;
    }

    @Override
    public MyLinkedListPolynomial derivative() {
        /* TODO */
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();

        for (int i = 1; i < polynomial.size(); i++){
            result.addAtEnd(polynomial.get(i) * i);
        }

        return result;
    }

    @Override
    public MyLinkedListPolynomial plus(MyPolynomial another) {
        /* TODO */
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        int n = Math.max(this.degree(), another.degree()) + 1;
        for (int i = 0; i < n; i++){

            double a = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double b = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(a + b);

        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial minus(MyPolynomial another) {
        /* TODO */
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();
        int n = Math.max(this.degree(), another.degree()) + 1;
        for (int i = 0; i < n; i++){

            double a = (i <= this.degree()) ? this.coefficientAt(i) : 0;
            double b = (i <= another.degree()) ? another.coefficientAt(i) : 0;
            result.addAtEnd(a - b);

        }
        return result;
    }

    @Override
    public MyLinkedListPolynomial multiply(MyPolynomial another) {
        /* TODO */
        int degree1 = this.degree();
        int degree2 = another.degree();
        MyLinkedListPolynomial result = new MyLinkedListPolynomial();

        for (int i = 0; i <= degree1 + degree2; i++){
            result.addAtEnd(0.0);
        }

        for (int i = 0; i <= degree1; i++){
            for (int j = 0; j <= degree2; j++){
                double value = result.coefficientAt(i + j) + this.coefficientAt(i) * another.coefficientAt(j);
                result.set(i + j, value);
            }
        }

        return result;
    }
}