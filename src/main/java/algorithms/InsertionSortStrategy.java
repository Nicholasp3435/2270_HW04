package algorithms;

import java.util.List;

/**
 * <strong>InsertionSortStrategy</strong> - Implements the insertion sort
 * algorithm for sorting lists. This simple algorithm builds the final sorted
 * array one item at a time and is less efficient for large lists compared to
 * advanced algorithms like quicksort, heapsort, or merge sort. Nonetheless, it
 * offers an excellent introduction to sorting algorithm basics.<br><br>
 * <p>
 * This class is a practical component of an educational toolkit aimed at
 * teaching data structures and algorithm analysis in Java. It is fully
 * provided to students for educational purposes.<br><br>
 * </p>
 *
 * <strong>Note:</strong> This class is fully given to students as part of an
 * educational toolkit. Unauthorized distribution or publishing of the solution
 * on the web or any other platform is not allowed.<br><br>
 *
 * @param <T> the type of elements to be sorted, must extend {@link Comparable}
 *          for comparison.
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */

public class InsertionSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {

    /**
     * Sorts the specified list of objects using the insertion sort algorithm.
     *
     * @param list the list to be sorted.
     */
    @Override
    public void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;

            // Move elements of list[0..i-1], that are
            // greater than key, to one position ahead
            // of their current position
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }
}