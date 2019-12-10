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
}
