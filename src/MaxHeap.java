import javax.management.openmbean.OpenMBeanInfoSupport;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // helper method that adds elements to a heap for O(n)
    // AKA HeapifyDown. I used slide's 40 psudocode to build this function
    private void arrayHeapSort(int index) {
        int largest = index;
        // Have the children of the index
        int leftChildChild = (index * 2) + 1;
        int rightChildChild = (index * 2) + 2;

        if (leftChildChild < size && data[leftChildChild] > data[largest])
            largest = leftChildChild;
        if (rightChildChild < size && data[rightChildChild] > data[largest])
            largest = rightChildChild;
        if (largest != index) {
            swap(index, largest);
            arrayHeapSort(largest);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = data[firstIndex];
        data[firstIndex] = data[secondIndex];
        data[secondIndex] = temp;
    }


    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {
        // Adding each individual piece of data is nlogn
        for(Integer input: data)
            add(input);
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {
        // Need a deep copy of the array, this MaxHeap object now holds the array and we manipulate our own data
        System.arraycopy(data, 0, this.data, 0, data.length);
        size = data.length;
        for(int i = data.length / 2; i >= 0; i--) {
            arrayHeapSort(i);
        }
//        //if(data.length != size) {
//            for(Integer output: data)
//                System.out.print(output + " ");
//        //}
//        System.out.println();
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // Checks to see if the heap is at max length or at size 0
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
        }
        return true;
    }
}
