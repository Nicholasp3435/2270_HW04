package algorithms;

import java.util.List;

/**
 * <strong>SortStrategy</strong> - Strategy interface for sorting algorithms.
 * <br><br><p>
 * This interface defines a sorting strategy that can be applied to a list of
 * elements. Implementing classes will provide specific sorting algorithm
 * implementations according to this strategy.<br><br>
 * </p>
 *
 * <strong>Note:</strong> This interface is for educational purposes and not
 * optimized for production. Unauthorized distribution or publishing online
 * or other platforms is not allowed.<br><br>
 *
 * @param <T> the type of elements to be sorted.
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */
public interface SortStrategy<T> {
    /**
     * Sorts the given list of elements in place.
     *
     * @param list the list of elements to be sorted
     */
    void sort(List<T> list);
}
