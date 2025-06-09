package hus.oop.rootsolver;

public class PolynomialRootFinder {
    private MyPolynomial polynomial;
    private RootSolver rootSolver;

    /**
     * Khởi tạo mặc định
     */
    public PolynomialRootFinder() {
        /* TODO */
        polynomial = new MyPolynomial();
        rootSolver = new RootSolver();
    }

    /**
     * Khởi tạo đa thức.
     * @param polynomial
     */
    public PolynomialRootFinder(MyPolynomial polynomial) {
        /* TODO */
        this.polynomial = polynomial;
        rootSolver = new RootSolver();
    }

    /**
     * Khởi tạo đa thức và phương pháp tìm nghiệm.
     * @param polynomial
     * @param rootSolver
     */
    public PolynomialRootFinder(MyPolynomial polynomial, RootSolver rootSolver) {
        /* TODO */
        this.polynomial = polynomial;
        this.rootSolver = rootSolver;
    }

    public void setPolynomial(MyPolynomial polynomial) {
        /* TODO */
        this.polynomial = polymial;
    }

    public void setRootSolver(RootSolver rootSolver) {
        /* TODO */
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của đa thức trong đoạn từ lower đến upper.
     * @param lower
     * @param upper
     * @return
     */
    public double solve(double lower, double upper) {
        /* TODO */

        return rootSolver.solve(polynomial, lower, upper);

    }
}
