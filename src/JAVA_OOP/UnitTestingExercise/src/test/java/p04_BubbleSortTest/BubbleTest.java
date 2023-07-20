package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] array = {0, 3, 6, 4, 2, 8, 1, 9, 5, 7};
        Bubble.sort(array);
        int[] sortedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertArrayEquals(sortedArray, array);
    }

}
