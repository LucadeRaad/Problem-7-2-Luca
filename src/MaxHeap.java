import javax.management.openmbean.OpenMBeanInfoSupport;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // helper method that adds elements to a heap for O(n)
    private void arrayHeapSort(int index) {
        // Have the children of the index
        int leftChild = (index * 2) + 1;
        int rightChild = (index * 2) + 2;

        // Recursively checks the child nodes to see if
        if(leftChild < data.length) {
            System.out.println(index + " <index leftChild> " + leftChild);
            //System.out.println(data.length);
            if (data[leftChild] > data[index]) {
                swap(leftChild, index);
                arrayHeapSort(leftChild);
            }

            if (rightChild < data.length && data[rightChild] > data[index]) {
                swap(rightChild, index);
                arrayHeapSort(rightChild); // Some duplicate code
            }
        }
    }

    // Swaps elements in an array
    private void swap(int numOne, int numTwo) {
        int temp = data[numOne];
        data[numOne] = data[numTwo];
        data[numTwo] = temp;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // Idea is that it adds, haven't added adding yet
        for(Integer input: this.data)
            add(input);

        //size = this.data.length;
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // Need a deep copy of the array, this MaxHeap object now holds the array and we manipulate our own data
        System.arraycopy(data, 0, this.data, 0, data.length);

        for(int i = 0; i < data.length; i++) {
            arrayHeapSort(this.data[this.data.length - 1 - i]);
        }
        size = this.data.length;
    }

    // add an item to the heap
    public boolean add(Integer item) {

        return false;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        return null;
    }

    // remove the root item
    public Integer pop() {
        // homework
        return null;
    }

    // Built the recommended equals function
    public boolean equals(MaxHeap other) {
        // Null pointer exceptions, just in case
        if(other.data.length != data.length) return false;

        //System.out.println();
//        for(int count = 0; count < other.data.length; count++) {
//            //System.out.println(count);
//            System.out.println(other.data[count]);
//            System.out.println(data[count]);
//        }

        for(int i = 0; i < data.length; i++) {
            if (!data[i].equals(other.data[i])) return false;
            System.out.println(i);
        }

        return true;
    }
}
