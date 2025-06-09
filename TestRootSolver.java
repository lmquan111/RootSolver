package hus.oop.rootsolver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestRootSolver {
    private PolynomialRootFinder rootFinder;

    public TestRootSolver(PolynomialRootFinder rootFinder) {
        this.rootFinder = rootFinder;
    }

    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("NguyenVanA_123456_RootSolver.txt");
            PolynomialRootFinder rootFinder = new PolynomialRootFinder();

            TestRootSolver tester = new TestRootSolver(rootFinder);

            writer.write("=== TEST ARRAY POLYNOMIAL ===\n");
            tester.testMyArrayPolynomial(writer);

            writer.write("\n=== TEST LIST POLYNOMIAL ===\n");
            tester.testMyListPolynomial(writer);

            writer.write("\n=== TEST LINKED LIST POLYNOMIAL ===\n");
            tester.testMyLinkedListPolynomial(writer);

            writer.close();
            System.out.println("Đã lưu kết quả test vào file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void testPolynomial(MyPolynomial poly, FileWriter writer) throws IOException {
        Random rand = new Random();
        double x = rand.nextDouble() * 10;
        double valueAtX = poly.evaluate(x);
        MyPolynomial derivative = poly.derivative();

        writer.write("Đa thức: " + poly + "\n");
        writer.write("Giá trị tại x = " + x + " là: " + valueAtX + "\n");
        writer.write("Đạo hàm: " + derivative + "\n");

        // Tạo đa thức ngẫu nhiên để cộng, trừ, nhân
        MyArrayPolynomial another = new MyArrayPolynomial();
        for (int i = 0; i < poly.degree() + 1; i++) {
            another.addAtEnd(rand.nextDouble() * 10 - 5);
        }

        writer.write("Đa thức khác: " + another + "\n");
        writer.write("Tổng: " + poly.plus(another) + "\n");
        writer.write("Hiệu: " + poly.minus(another) + "\n");
        writer.write("Tích: " + poly.multiply(another) + "\n");

        // Tìm nghiệm gần đúng trong đoạn [a, b]
        double a = -10, b = 10;
        while (poly.evaluate(a) * poly.evaluate(b) >= 0) {
            a = rand.nextDouble() * 20 - 10;
            b = rand.nextDouble() * 20 - 10;
        }

        RootSolver[] solvers = {
            new BisectionSolver(1e-6, 1000),
            new NewtonRaphsonSolver(1e-6, 1000),
            new SecantSolver(1e-6, 1000)
        };
        String[] names = {"Bisection", "Newton-Raphson", "Secant"};

        for (int i = 0; i < solvers.length; i++) {
            double root = solvers[i].solve(poly, a, b);
            writer.write(names[i] + " root: x = " + root + ", f(x) = " + poly.evaluate(root) + "\n");
        }
    }

    public void testMyArrayPolynomial(FileWriter writer) throws IOException {
        Random rand = new Random();
        int size = rand.nextInt(5) + 3;
        MyArrayPolynomial poly = new MyArrayPolynomial();
        for (int i = 0; i < size; i++) {
            poly.addAtEnd(rand.nextDouble() * 10 - 5);
        }
        testPolynomial(poly, writer);
    }

    public void testMyListPolynomial(FileWriter writer) throws IOException {
        Random rand = new Random();
        int size = rand.nextInt(5) + 3;
        MyListPolynomial poly = new MyListPolynomial();
        for (int i = 0; i < size; i++) {
            poly.addAtEnd(rand.nextDouble() * 10 - 5);
        }
        testPolynomial(poly, writer);
    }

    public void testMyLinkedListPolynomial(FileWriter writer) throws IOException {
        Random rand = new Random();
        int size = rand.nextInt(5) + 3;
        MyLinkedListPolynomial poly = new MyLinkedListPolynomial();
        for (int i = 0; i < size; i++) {
            poly.addAtEnd(rand.nextDouble() * 10 - 5);
        }
        testPolynomial(poly, writer);
    }
}
