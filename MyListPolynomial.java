package hus.oop.rootsolver;

import java.util.List;

public class MyListPolynomial extends MyAbstractPolynomial {
    private List<Double> coefficients;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyListPolynomial() {
        this.coefficients = new ArrayList<>();
    }

    @Override
    public double coefficientAt(int index) {
        /* TODO */

        return coefficients.get(index);
    }

    @Override
    public double[] coefficients() {
        return coefficients.stream().mapToDouble(Double::doubleValue).toArray();
    }

    @Override
    public double coefficientAt(int index) {
        if (index < 0 || index >= coefficients.size()){
            return 0.0;
        }
        return coefficients.get(index);
    }

    @Override
    public void addAtStart(double coefficient) {
        coefficients.add(0, coefficient);
    }

    @Override
    public void addAtEnd(double coefficient) {
        coefficients.add(coefficient);
    }

    @Override
    public void addAtPosition(int index, double coefficient) {
        if (index < 0) return;


        if(index > coefficients.size()){

            for(int i = coefficients.size() - 1; i < index; i++){
                coefficients.add(0.0);
            }


        }

        coefficients.add(index, coefficient);
        
    }

    @Override
    public void set(int index, double coefficient) {
        /* TODO */

        if (index < 0) return;

        coefficients.set(index, coefficient);
    }

    @Override
    public int degree() {
        /* TODO */

        return coefficients.size();
    }

    @Override
    public double evaluate(double x) {
        
        double result = 0.0;
        for (int i = coefficients.size() - 1; i >= 0; i--){
            result = result * x + coefficients.get(i);
        }
        return result;
    }

    @Override
    public MyListPolynomial derivative() {
        /* TODO */

        var newList = new MyListPolynomial();

        int n = coefficients.size() - 1;

        for(int i = 0; i < coefficients.size() - 1; i++){

            newList.addAtEnd(this.coefficientAt(i) * (n - i));

        }

        return newList;

    }

    @Override
    public MyListPolynomial plus(MyPolynomial another) {
        /* TODO */

        int maxDegree = Math.max(this.coefficients.size(), another.degree());
        MyListPolynomial result = new MyListPolynomial();

        for (int i = 0; i < maxDegree; i++){
            double a = this.coefficientAt(i);
            double b = another.coefficientAt(i);
            result.addAtEnd(a + b);
        }

        return result;
    }

    @Override
    public MyListPolynomial minus(MyPolynomial another) {
        /* TODO */

        int maxDegree = Math.max(this.coefficients.size(), another.degree());
        MyListPolynomial result = new MyListPolynomial();

        for (int i = 0; i < maxDegree; i++){
            double a = this.coefficientAt(i);
            double b = another.coefficientAt(i);
            result.addAtEnd(a - b);
        }

        return result;
    }

    @Override
    public MyListPolynomial multiply(MyPolynomial another) {
        /* TODO */

        // -2 because degree() -1 is true answer
        int newDegree = this.degree() + another.degree() - 2; 
       
        double[] resultCoeffs = new double[newDegree + 1];

        // Nhân đa thức
        for (int i = 0; i < this.degree(); i++){
            for (int j = 0; j < another.degree(); j++){

                resultCoeffs[i + j] += this.coefficientAt(i) * another.coefficientAt(j);

            }
        }

        MyListPolynomial result = new MyListPolynomial();
        for (double coeff : resultCoeffs) {
            result.addAtEnd(coeff);
        }

        return result;
    }
}
