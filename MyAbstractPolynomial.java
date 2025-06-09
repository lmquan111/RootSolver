package hus.oop.rootsolver;

public abstract class MyAbstractPolynomial implements MyPolynomial {
    /**
     * Mô tả đa thức theo định dạng [a0 + a1x + a2x^2 + ... + anx^n]
     * @return String mô tả về đa thức.
     */
   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int n = this.degree();
        for (int i = n - 1; i >= 0; i--) {
            double coeff = this.coefficientAt(i);
            int deg = n - 1 - i;

            if (deg > 0) {
                sb.append(" + ");
            }

            if (deg == 0) {
                sb.append(coeff);
            } 
            else if (deg == 1) {
                sb.append(coeff).append("x");
            } 
            else {
                sb.append(coeff).append("x^").append(deg);
            }
        }

        sb.append("]");
        return sb.toString();
    }
    

    /**
     * Lấy đạo hàm đa thức.
     * @return mảng các phần tử là hệ số của đa thức đạo hàm.
     */
    public double[] differentiate() {
        /* TODO */
        var newList = this.derivative();

        return newList.coefficients();        

    }
}
