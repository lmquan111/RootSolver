package hus.oop.rootsolver;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance 
     * @param maxIterations 
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm gần đúng của đa thức sử dụng phương pháp dây cung (secant method).
     * Dùng lower và upper như hai điểm khởi tạo ban đầu.
     */
    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        double x0 = lower;
        double x1 = upper;
        double f0 = polynomial.evaluate(x0);
        double f1 = polynomial.evaluate(x1);

        for (int i = 0; i < maxIterations; i++) {

            double x2 = x1 - f1 * (x1 - x0) / (f1 - f0);
            double f2 = polynomial.evaluate(x2);

            if (Math.abs(f2) < tolerance) {
                return x2;
            }

           
            x0 = x1;
            f0 = f1;
            x1 = x2;
            f1 = f2;
        }

    }
}
