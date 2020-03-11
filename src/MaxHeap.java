public class MaxHeap implements Heap {
    int capacity;
    int size;

    Integer[] data;

    public MaxHeap(int size) {
        this.size = size;
        data = new Integer[size];
    }
    // helper method that adds elements to a heap for O(n)
    private void arrayHeapSort(int index) {
        // Gives first child, other is one index point down
        int children = (index * 2) + 1;
        while(children < data.length) {
            if(data[children] > data[index]) {
                swap(children, index);
            } else if(children + 1 < data.length && data[children + 1] > data[index]) {
                swap(children, index);
            }
        }
    }

    // Simple swap function
    private void swap(int numOne, int numTwo) {
        int temp = data[numOne];
        data[numOne] = data[numTwo];
        data[numTwo] = temp;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // Using prebuilt heap from java
        MaxHeap heap = new MaxHeap(data.length);
        for(Integer input: data)
            heap.add(input);
        int i = 0;
        // Need to seperate these because heap needs to sort(in nlogn fasion) the elements
        for(Integer input: heap.data) {
            data[i] = input;
            i++;
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        for(int i = 0; i < data.length; i++) {
            arrayHeapSort(i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
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
}
