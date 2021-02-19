import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class ThanosSortTest {

    @Test
    public void simpleTestOdd() {
        int[] input = new int[]{9, 8, 1, 2, 4, 5, 7, 6, 3};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, expected);
    }

    @Test
    public void simpleTestEven() {
        int[] input = new int[]{0, 2, 4, 3, 5, 6, 7, 9, 1, 8};
        int[] expected = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, expected);
    }

    @Test
    public void emptyTest() {
        int[] input = new int[]{};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, new int[]{});
    }

    @Test
    public void singleTest() {
        int[] input = new int[]{4};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, new int[]{4});
    }

    @Test
    //смещение среднего в крайнее положение
    public void overbalanceRightTest(){
        int[] input = new int[]{33, 12, 25, 17, 999, 66, 7};
        int[] expected = new int[]{7, 12, 17, 25, 33, 66, 999};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, expected);
    }

    @Test
    public void overbalanceLeftTest(){
        int[] input = new int[]{1, 112, 125, 117, 89, 82, 94};
        int[] expected = new int[]{1, 82, 89, 94, 112, 117, 125};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, expected);
    }

    @Test
    //повторения
    public void identicalElementsTest(){
        int[] input = new int[]{1, 1, 3, 3, 2, 2, 0, 4, 5, 3};
        int[] expected = new int[]{0, 1, 1, 2, 2, 3, 3, 3, 4, 5};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, expected);
    }

    @Test
    public void identicalTest(){
        int[] input = new int[]{1, 1, 1, 1, 1, 1, 1};
        int[] expected = new int[]{1, 1, 1, 1, 1, 1, 1};
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, expected);
    }

   @Test
    public void bigNumbersTest(){
        int[] input = new int[]{91341043, 563423418, 381413401, 122894794, 19230423, 37435432, 44134053, 675234239, 130921176, 21234493};
        int[] expected = Arrays.copyOf(input, input.length);
        Arrays.sort(expected);
        ThanosSort.sort(input);
        Assertions.assertArrayEquals(input, expected);
    }
}

