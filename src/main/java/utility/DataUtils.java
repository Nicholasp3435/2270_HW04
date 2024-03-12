package utility;

import algorithms.InsertionSortStrategy;
import algorithms.SortStrategy;
import algorithms.SortUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//345678901234567890123456789012345678901234567890123456789012345678901234567890

/**
 * <strong>DataUtils</strong> - Utility methods for data analysis, including
 * calculation of correlation, mean, median, and data filtering based on specific
 * criteria.<br><br>
 *
 * <strong>Methods include:</strong>
 * <ul>
 * <li><tt>calculateCorrelation</tt>: Computes the Pearson correlation
 * coefficient between two features.</li>
 * <li><tt>calculateMean</tt>: Calculates the mean (average) of a numeric feature.</li>
 * <li><tt>calculateMedian</tt>: Determines the median value of a numeric feature.</li>
 * <li><tt>filterData</tt>: Filters rows of data based on a threshold applied
 * to a specific feature.</li>
 * </ul>
 *
 *
 * <strong>Note:</strong>  These utilities are designed for educational purposes,
 * this class demonstrates utility methods for data analysis, but these are not
 * optimized for production use. Unauthorized distribution or publishing online or
 * on other platforms is not allowed.<br><br>
 *
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 */


public class DataUtils {

    /**
     * Calculates the Pearson correlation coefficient between a given feature
     *      and the target variable in the dataset.
     *
     * @param data The dataset represented as a List of List of Strings.
     * @param featureIndex The index of the feature column.
     * @param targetIndex The index of the target column.
     * @return The correlation coefficient as a double.
     */
    public static double calculateCorrelation(
            List<List<String>> data,
            int featureIndex,
            int targetIndex) {

        // Assumes the first row is the header row
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, sumY2 = 0;

        int n = data.size() - 1; // Subtract 1 to account for header row
        // TODO: double check if you are storing the the 'header' row

        for (int i = 1; i <= n; i++) { // Start from 1 to skip the header row
            double x = Double.parseDouble(data.get(i).get(featureIndex));
            double y = Double.parseDouble(data.get(i).get(targetIndex));
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
            sumY2 += y * y;
        }

        double numerator = n * sumXY - sumX * sumY;
        double denominator = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));
        return numerator / denominator;
    }

    /**
     * Calculates the mean (average) value of a specified feature in the dataset.
     *
     * @param data The dataset represented as a List of List of Strings.
     * @param targetIndex The index of the feature column for which to calculate the mean.
     * @return The mean value as a double.
     */
    public static double calculateMean(List<List<String>> data, int targetIndex) {
        double the_mean = 0.0;
        // TODO: Implementation goes here
            // TODO: account or do not account for the header row.
        return the_mean;
    }


    /**
     * Calculates the median value of a specified feature in the dataset.
     *
     * @param data The dataset represented as a List of List of Strings.
     * @param featureIndex The index of the feature column for which to calculate the median.
     * @return The median value as a double.
     */
    public static double calculateMedian(
            List<List<String>> data,
            int featureIndex) {
        List<Double> values = new ArrayList<>();

        // fill in values
        for (int i = 1; i < data.size(); i++) { // Start from 1 to skip the header row
            values.add(Double.parseDouble(data.get(i).get(featureIndex)));
        }

        // TODO: Implement different sorting algorithm to sort the "values"
            // Insertion sort is provided
            // TODO: BubbleSortStrategy
            // TODO: MergeSortStrategy
            // TODO: QuickSortStrategy

        Collections.sort(values); // TODO:  Replace the sorting of Collections.sort()
        // TODO: - Use the below API of different sort algorithms
        // SortStrategy<Double> insertionSortStrategy = new InsertionSortStrategy<>();
        // SortUtils.sort(values, insertionSortStrategy);

        // SortStrategy<Double> mergeSortStrategy = new MergeSortStrategy<>();
        // SortUtils.sort(values, mergeSortStrategy);

        // SortStrategy<Double> bubbleSortStrategy = new BubbleSortStrategy<>();
        // SortUtils.sort(values, bubbleSortStrategy);

        // for quick sort - add follow the same pattern as provided InsertionSort

        // After sorting, calculate the median
        // Return the median value based on the sorted list 'values'

        // TODO: Adhere to the DEFINITION:
        //      The median of a set of numbers is the middle number in
        //      the set (after the numbers have been arranged from least to
        //      greatest) -- or, if there are an even number of data, the
        //      median is the average of the middle two numbers.
        return 0; // Placeholder // TODO: Replace the Placeholder with the calculated media
    }

    /**
     * Filters the dataset based on a threshold value applied to a specific feature.
     *
     * @param data The dataset represented as a List of List of Strings.
     * @param featureIndex The index of the feature column used for filtering.
     * @param threshold The threshold value for filtering.
     * @param isLeft A boolean flag indicating whether to filter values less than (true) or greater than (false) the threshold.
     * @return A filtered dataset as a List of List of Strings.
     */
    public static List<List<String>>
            filterData(
                    List<List<String>> data,
                    int featureIndex,
                    double threshold,
                    boolean isLeft ) {

        List<List<String>> filteredData = new ArrayList<>();

        // TODO: Assumes the first row is the header row
        filteredData.add(data.get(0)); // Add the header row

        // TODO: Iterate through the "data" input as a parameter and filter rows based on the threshold
        //      and isLeft flag
        //      Hint: Use a loop to go through each row.
        //      Inside the loop, get the value featureIndex and covert it to a double (lets assume all values are double)
        //      next filter it with an if statement and check the threshold condition.
        //      If it does, add the row to filteredData.

        // HINT: pseudocode
        // // for loop
        //      get value, and convert it to a double
        //          xxx - check if the value meets the treshold (filter the data left if "isLeft" is true, o/w right)
        //          if ( xxx )
        //              filterData.add( ... )
        return filteredData;
    }

    /**
     * Main method for testing the utility functions provided in the DataUtils class.
     * Demonstrates usage of correlation, mean, median calculations, and data filtering.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        List<List<String>> data = new ArrayList<>();
        Random random = new Random();

        // A header row to simulate how we keep our CSV data records
        data.add(List.of("Feature1", "Feature2"));
        int numberOfRows = 5;

        // Generate random numbers and add them to the data list as strings
        // Generate random numbers and add them as rows to the data
        for (int i = 0; i < numberOfRows; i++) {
            List<String> row = new ArrayList<>();
            // Simulating two features for the sake of demonstration
            row.add(String.valueOf(i)); // Feature1: Index as a feature
            row.add(String.valueOf(random.nextInt(100))); // Feature2: Random number
            data.add(row);
        }

        // Print our 'simulated" dataset
        System.out.println("Generated dataset:");
        for (List<String> row : data) {
            System.out.println(row);
        }

        // Assuming calculateCorrelation expects indexes for feature and target, and
        //  data includes these columns
        // Since this is just a demonstration, we're using the two columns we've generated
        // Note: You'll need to adjust the calculateCorrelation method to handle
        //      data parsing or ensure data is in the correct numeric format.
        double correlation = DataUtils.calculateCorrelation(data, 0, 1);
        System.out.println("Correlation between Feature1 and Feature2: " + correlation);

        double mean = DataUtils.calculateMean(data, 1); // Calculating mean for Feature2
        System.out.println("Mean of Feature2 (not done): " + mean);

        double median = DataUtils.calculateMedian(data, 1); // Calculating median for Feature2
        System.out.println("Median of Feature2 (not done): " + median);

        // Note: Add more tests as needed to demonstrate the functionalities
    }

}

