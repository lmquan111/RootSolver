package hus.oop.rootsolver;

public class MyLinkedList {
    private MyNode top;

    /**
     * Khởi tạo dữ liệu mặc định.
     */
    public MyLinkedList() {
        /* TODO */
        top = null;
    }

    /**
     * Lấy kích thước danh sách
     * @return
     */
    public int size() {
        /* TODO */
        int count = 0;
        MyNode current = top;
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * Lấy giá trị của node ở vị trí index
     * @return
     */
    public double get(int index) {
        /* TODO */
        return getNodeByIndex(index).data;
    }

    /**
     * Thay đổi giá trị của node ở vị trí index
     */
    public void set(double data, int index) {
        /* TODO */
        getNodeByIndex(index).data = data;
    }

    /**
     * Thêm node có giá trị data tại vị trí cuối danh sách
     * @param data
     */
    public void add(double data) {
        /* TODO */
        MyNode newNode = new MyNode(data);
        if (top == null){
            top = newNode;
        } 
        else{
            MyNode current = top;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Thêm node có giá trị data tại vị trí index
     * @param data
     * @param index
     */
    public void insert(double data, int index) {
        /* TODO */
        if (index < 0) return;

        MyNode newNode = new MyNode(data);
        if (index == 0){
            newNode.next = top;
            top = newNode;
            return;
        }

        MyNode prev = getNodeByIndex(index - 1);
        newNode.next = prev.next;
        prev.next = newNode;
    }

    /**
     * Xóa node tại vị trí index
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (index < 0 || top == null) return;

        if (index == 0){
            top = top.next;
            return;
        }

        MyNode prev = getNodeByIndex(index - 1);
        if (prev.next != null){
            prev.next = prev.next.next;
        }
    }

    /**
     * Lấy node ở vị trí index.
     * @param index
     * @return
     */
    private MyNode getNodeByIndex(int index) {
        /* TODO */
        if (index < 0){
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }

        MyNode current = top;
        int count = 0;

        while (current != null && count < index){
            current = current.next;
            count++;
        }

        if (current == null){
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        return current;
    }
}
