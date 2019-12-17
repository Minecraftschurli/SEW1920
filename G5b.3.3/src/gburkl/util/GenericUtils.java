package gburkl.util;

/**
 * @author Georg Burkl
 * @version 2019-12-10
 */
public final class GenericUtils {
    /**
     * Reverses the elements of an array
     * @param array the array to reverse
     * @param <T> the type of the array
     * @return the reversed array
     */
    public static <T> T[] reverse(T[] array) {
        for(int i=0; i<array.length/2; i++){
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    /**
     * Sorts the given array of type {@link T} extending {@link Comparable}
     * @param array the array to sort
     * @param <T> the type of the array
     * @return the sorted array
     */
    public static <T extends Comparable<T>> T[] sort(T[] array){
        boolean done;
        do{
            done = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i+1])>0){
                    T tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    done = false;
                }
                if (array[array.length-i-1].compareTo(array[array.length-i-2])<0){
                    T tmp = array[array.length-i-1];
                    array[array.length-i-1] = array[array.length-i-2];
                    array[array.length-i-2] = tmp;
                    done = false;
                }
            }
        }while (!done);
        return array;
    }

    /**
     * Creates the sum of all the values in the given array
     * @param values the values to sum up
     * @param <T> the type of the array to sum
     * @return the sum of the values given
     */
    public static <T extends Number> double sum(T[] values) {
        double sum = 0;
        for (T value : values) {
            sum+=value.doubleValue();
        }
        return sum;
    }
}
