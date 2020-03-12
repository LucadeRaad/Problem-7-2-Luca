import javax.management.openmbean.OpenMBeanInfoSupport;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // helper method that adds elements to a heap for O(n)
    // AKA HeapifyDown. I used the slide's psudocode to build this function
    private void arrayHeapSort(int index) {
        int smallest = index;
        // Have the children of the index
        int leftChild = (index * 2) + 1;
        int rightChild = (index * 2) + 2;

        if (leftChild < data.length && data[leftChild] < data[smallest])
            smallest = leftChild;
        if (rightChild < data.length && data[rightChild] < data[smallest])
            smallest = rightChild;
        if (smallest != index) {
            swap(smallest, index);
            arrayHeapSort(smallest);
        } else {
            System.out.println(data[smallest] + " is smaller than");
            if(leftChild < data.length) System.out.println(data[leftChild]);
            if(rightChild < data.length) System.out.println(data[rightChild]);
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
        // Need a deep copy of the array, this MaxHeap object now holds the array and we manipulate our own data
        //System.arraycopy(data, 0, this.data, 0, data.length);

        for(Integer input: data)
            add(input);
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // Need a deep copy of the array, this MaxHeap object now holds the array and we manipulate our own data
        System.arraycopy(data, 0, this.data, 0, data.length);

        for(int i = 0; i < data.length; i++) {
            arrayHeapSort(i);
        }
    }

    // add an item to the heap
    public boolean add(Integer item) {
        if(size == data.length) return false;
        if(size == 0) {
            data[size] = item;
            size++;
            return true;
        }

        data[size] = item;
        int count = size;

        while (data[count] > data[(count / 2)]) {
            swap(count, (count / 2));
            count /= 2;
        }
        size++;
        return true;
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

        for(int i = 0; i < data.length; i++) {
            if (!data[i].equals(other.data[i])) return false;
            System.out.println(i);
        }
        return true;
    }
}
