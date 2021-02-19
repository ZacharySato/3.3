import java.util.Arrays;

public class ThanosSort {

    private static void doSort(int[] array, int start, int stop) {
        int section = stop - start + 1; //с учетом нуля
        if (section < 2)
            return;
        int[] storage = Arrays.copyOf(array, array.length);
        //находим среднее входящего
        int sum = 0;
        int average;
        for (int i = start; i <= stop; i++)
            sum += array[i];
        average = sum / section;
        //расставляем элементы относительного среднего, с концов к середине массива
        int stepRight = 0;
        int stepLeft = 0;

        for (int i = start; i <= stop; i++) {
            if (array[i] <= average) {
                storage[start + stepLeft] = array[i];
                stepLeft++;
            } else {
                storage[stop - stepRight] = array[i];
                stepRight++;
            }
        }
        //(исправление) для повторяющихся значений
        if(stepRight==0)
            return;

        for (int i = start; i <= stop; i++)
            array[i] = storage[i];
        //(исправление) сортируем относительно положения среднего
        doSort(array, start, start + stepLeft - 1);
        doSort(array, start + stepLeft, stop);
    }


    public static int[] sort(int[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

}

