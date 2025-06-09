package hus.oop.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */

        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        /* TODO */

        // xn + 1 = xn + f(xn)/f'(xn)

        MyPolynomial derivative = polynomial.derivative();
        double x = (lower + upper) / 2;

        for (int i = 0; i < maxIterations; i++) {
            double fx = polynomial.evaluate(x);
            double f_de_X = derivative.evaluate(x);

            if (Math.abs(fx) < tolerance) {
                return x;
            }

            if (Math.abs(fPrimeX) < 1e-12) {
                // Tránh chia cho gần 0
                throw new ArithmeticException("xấp xỉ 0");
            }

            x = x - fx / f_de_X;
        }


    }
    
}
