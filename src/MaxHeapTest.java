import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MaxHeapTest {

    @Test
    public void HeapLogNHeapN() {
        MaxHeap[] heapLogN = new MaxHeap[10];
        MaxHeap[] heapN = new MaxHeap[10];
        Random rand = new Random();
        // Heaps in this case are expressed with arrays
        Integer[][] testHeapLogN = new Integer[10][10];
        Integer[][] testHeapN = new Integer[10][10];
        // Randomly generated inputs
        for (int i = 0; i < testHeapLogN.length; i++) {
            heapLogN[i] = new MaxHeap(10);
            heapN[i] = new MaxHeap(10);
            for (int j = 0; j < testHeapLogN[i].length; j++) {
                int same = rand.nextInt(40);
                testHeapLogN[i][j] = same;
                testHeapN[i][j] = same;
                //System.out.println(same);
            }
            //System.out.println(i);
            // Creating the two arrays of heaps that should be identical
            heapLogN[i].MaxHeapLogN(testHeapLogN[i]);
            heapN[i].MaxHeapN(testHeapN[i]);

            System.out.println();
            for(int count = 0; count < heapLogN[i].size; count++) {
                System.out.println("Heap logN");
                System.out.println(heapLogN[i].data[count]);
            }

            for(int count = 0; count < heapLogN[i].size; count++) {
                System.out.println("Heap N");
                System.out.println(heapN[i].data[count]);
            }

            assert(heapLogN[i].equals(heapN[i]));
        }
    }
}