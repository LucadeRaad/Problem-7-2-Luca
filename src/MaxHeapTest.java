import org.junit.Test;

public class MaxHeapTest {

    @Test
    public void HeapLogNHeapN() {
        Integer[][] testData = {
                {},
                {1},
                {12, 4},
                {3, 5, 6},
                {10, 11, 9, 8, 6},
                {30, 21, 9, 1, 7, 19},
                {8, 5, 49, 50, 18, 6, 4, 14, 7, 24},
                {13, 100, 4, 9, 12, 56, 67}
        };

        MaxHeap[] heapLogN = new MaxHeap[testData.length];
        MaxHeap[] heapN = new MaxHeap[testData.length];

        // Heaps in this case are expressed with arrays
        for (int i = 0; i < testData.length; i++) {
            // There are now two arrays of the same input
            heapLogN[i] = new MaxHeap(testData[i].length);
            heapN[i] = new MaxHeap(testData[i].length);

            // Creating the two arrays of heaps that should be identical
            heapLogN[i].MaxHeapLogN(testData[i]);
            heapN[i].MaxHeapN(testData[i]);

            if(!(heapLogN[i].equals(heapN[i]))) {
                System.out.println("Heap logN");
                for (int count = 0; count < heapLogN[i].size; count++) {
                    System.out.print(heapLogN[i].data[count] + " ");
                }

                System.out.println();
                System.out.println("Heap N");
                for (int count = 0; count < heapLogN[i].size; count++) {
                    System.out.print(heapN[i].data[count] + " ");
                }
            }

            assert(heapLogN[i].equals(heapN[i]));
        }
    }
}