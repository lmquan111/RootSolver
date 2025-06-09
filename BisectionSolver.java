package hus.oop.rootsolver;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance 
     * @param maxIterations 
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm gần đúng trong khoảng [lower, upper] sử dụng phương pháp chia đôi.
     */
    @Override
    public double solve(MyPolynomial polynomial, double lower, double upper) {
        double a = lower;
        double b = upper;
        double fa = polynomial.evaluate(a);
        double fb = polynomial.evaluate(b);

        double c = a;
        for (int i = 0; i < maxIterations; i++){
            c = (a + b) / 2;
            double fc = polynomial.evaluate(c);

            if (Math.abs(fc) < tolerance || (b - a) / 2 < tolerance){
                return c;
            }

            if (fa * fc < 0){
                b = c;
                fb = fc;
            } 
            else{
                a = c;
                fa = fc;
            }
        }

    }
}
