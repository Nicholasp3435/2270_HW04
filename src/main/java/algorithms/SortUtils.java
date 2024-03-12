package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <strong>SortUtils</strong> - Demonstrates using different sorting strategies. This
 * utility class showcases dynamic swapping of sorting algorithms at runtime,
 * leveraging the Strategy pattern with examples like Bubble Sort, Insertion Sort,
 * and Merge Sort.<br><br>
 * <p>
 * It serves as an example of the Strategy design pattern in sorting, promoting
 * loose coupling between algorithm selection and client code usage. Run the
 * main method to compare outcomes of different sorting strategies on the same
 * dataset.<br><br>
 * </p>
 *
 * <strong>Note:</strong> Designed for educational purposes, this class demonstrates
 * sorting algorithms and is not optimized for production use. Unauthorized
 * distribution or publishing online or on other platforms is not allowed.<br><br>
 *
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */


public class SortUtils {

    public static <T extends Comparable<T>> void sort(List<T> list, SortStrategy<T> strategy) {
        strategy.sort(list);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        int numbers_to_test = 20;

        // Generate 12 random numbers and add them to the list
        for (int i = 0; i < numbers_to_test; i++) {
            numbers.add(random.nextInt(100)); // Assuming a range of 0 to 99 for simplicity
        }

        System.out.println("Original list:");
        System.out.println("\t" + numbers);

        // Clone the original list for separate sorting
        List<Integer> numbersForBubbleSort = new ArrayList<>(numbers);
        List<Integer> numbersForInsertionSort = new ArrayList<>(numbers);
        List<Integer> numbersForMergeSort = new ArrayList<>(numbers);

        // Bubble Sort
        System.out.println("Bubble Sort (Not Done):");
        SortStrategy<Integer> bubbleSortStrategy = new BubbleSortStrategy<>();
        sort(numbersForBubbleSort, bubbleSortStrategy);
        System.out.println("\t" + numbersForBubbleSort);

        // Insertion Sort
        System.out.println("Insertion Sort:");
        SortStrategy<Integer> insertionSortStrategy = new InsertionSortStrategy<>();
        sort(numbersForInsertionSort, insertionSortStrategy);
        System.out.println("\t" + numbersForInsertionSort);

        // Merge Sort
        System.out.println("Merge Sort (Not Done):");
        SortStrategy<Integer> mergeSortStrategy = new MergeSortStrategy<>();
        sort(numbersForMergeSort, mergeSortStrategy);
        System.out.println("\t" + numbersForMergeSort);
    }
}
