package hus.oop.rootsolver;

public class MyNode {
    public double data;
    public MyNode next;
    public MyNode previous;

    public MyNode(double data) {
        /* TODO */
        this.data = data;
    }

    public MyNode(double data, MyNode next, MyNode previous) {
        /* TODO */
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}
