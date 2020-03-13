import org.junit.Test;

import java.util.Arrays;

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
                {8, 5, 1, 27, 18, 6, 4, 14, 7},
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

            // This is a debugger.
            if(!(heapLogN[i].equals(heapN[i]))) {
                System.out.println();
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

    @Test
    public void getTest() {
        Integer[][] testData = {
                {9},
                {12, 4},
                {6, 5, 3},
                {11, 10, 9, 8, 6},
                {30, 21, 19, 1, 7, 9},
                {34, 27, 8, 15, 18, 6, 4, 14, 7},
                {100, 67, 17, 9, 12, 1, 13}
        };

        // Need to return max value of the maxheap
        Integer[] expected = {9, 12, 6, 11, 30, 34, 100};
        MaxHeap[] heapGet = new MaxHeap[testData.length];

        for(int i = 0; i < testData.length; i++) {
            heapGet[i] = new MaxHeap(testData[i].length);
            heapGet[i].MaxHeapN(testData[i]);
            Integer actual = heapGet[i].get();
            assert(actual.equals(expected[i]));
        }
    }

    @Test
    public void popTest() {
        // Going to assume for popping that the heap is already created. AKA the array is heapified
        Integer[][] testData = {
                {9},
                {12, 4},
                {6, 5, 3},
                {11, 10, 9, 8, 6},
                {30, 21, 19, 1, 7, 9},
                {34, 27, 8, 15, 18, 6, 4, 14, 7},
                {100, 67, 17, 9, 12, 1, 13}
        };

        // Testing to see if it removes the topmost value and to see if the heap is correctly formatted afterwards
        Integer[] output = {9, 12, 6, 11, 30, 34, 100};
        Integer[][] expected = {
                {null},
                {4, null},
                {5, 3, null},
                {10, 8, 9, 6, null},
                {21, 9, 19, 1, 7, null},
                {27, 18, 8, 15, 7, 6, 4, 14, null},
                {67, 13, 17, 9, 12, 1, null}
        };

        MaxHeap[] heapPop = new MaxHeap[testData.length];

        for(int i = 0; i < testData.length; i++) {
            heapPop[i] = new MaxHeap(testData[i].length);
            heapPop[i].MaxHeapN(testData[i]);
            Integer popValue = heapPop[i].pop();

            // One tests if the right value has been found, the other other tests if the heap correctly has shifted
            assert(popValue.equals(output[i]));
            assert(Arrays.equals(heapPop[i].data, expected[i]));
        }
    }
}