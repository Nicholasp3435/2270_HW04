package applications;

import algorithms.DecisionTree;
import datastructures.TreeNode;
import graphics.TreeVisualizer;
import utility.CSVReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <strong>DecisionTreeDriver</strong> - Demonstrates decision tree construction,
 * visualization, and evaluation. Manages datasets for building and testing
 * decision trees based on specific parameters.<br><br>
 * <p>
 * Includes a <tt>DataSet</tt> inner class for handling dataset specifics like file paths,
 * preprocessing flags, and tree depth limits. Use by creating <tt>DataSet</tt> instances
 * and processing them to construct, visualize, and evaluate trees. Aimed for
 * educational use in a homework assignment context.<br><br>
 * </p>
 *
 * <strong>Note:</strong> For educational purposes, teaching decision trees and
 * visualization techniques. Unauthorized distribution or publishing online or
 * on other platforms is not allowed.<br><br>
 *
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */

public class DecisionTreeDriver {
    /**
     * Represents a dataset with associated configuration for processing
     * in the context of decision tree building and evaluation.
     * This class encapsulates dataset details and processing parameters
     * to streamline decision tree experiments.
     *
     * Each instance of DataSet is configured with paths to data files,
     * preprocessing options, depth limits for tree construction, and
     * optional test cases with expected outcomes for evaluation purposes.
     *
     * @param filePath Path to the dataset file.
     * @param ignoreColumns A list of column indices to be ignored in the dataset.
     * @param maxDepth Maximum depth of the decision tree.
     * @param testCases Test cases for evaluating the tree.
     * @param expectedValues Expected outcomes for the test cases.
     *
     */
    static class DataSet {
        String filePath;
        boolean process;
        List<Integer> ignoreColumns;
        int maxDepth;
        List<List<String>> testCases;
        List<Double> expectedValues;

        DataSet(String filePath, List<Integer> ignoreColumns, int maxDepth, List<List<String>> testCases, List<Double> expectedValues) {
            this.filePath = filePath;
            this.ignoreColumns = ignoreColumns;
            this.maxDepth = maxDepth;
            this.testCases = testCases;
            this.expectedValues = expectedValues;
            this.process = true;
        }

        public DataSet( String filePath,
                        List<Integer> ignoreColumns,
                        int maxDepth) {
            this(filePath, ignoreColumns, maxDepth, new ArrayList<>(), new ArrayList<>());
        }
    }

    private static void processDataSet(DataSet dataset) {
        // Read the entire dataset
        List<List<String>> data = CSVReader.readCSV(dataset.filePath);
        for (int colIndex : dataset.ignoreColumns) {
            data.forEach(row -> row.remove(colIndex));
            // remove extraneous columns
        }
        List<String> features = new ArrayList<>(data.get(0).subList(0, data.get(0).size() - 1));

        System.out.println("\n\nBuilding tree with --> ");
        System.out.println("*** Features = " + features + "\n");

        String target = data.get(0).get(data.get(0).size() - 1);

        DecisionTree decisionTree = new DecisionTree();
        TreeNode tree = decisionTree.buildTree(data, features, target, 0, dataset.maxDepth);

        // Visualize the tree
        TreeVisualizer.display(tree);
        System.out.println("\n\n");

        // Evaluate test cases if provided
        if (!dataset.testCases.isEmpty()) {
            if (dataset.testCases.size() != dataset.expectedValues.size()) {
                System.err.println("Error: Mismatched number of test cases and expected values.");
                return;
            }
            System.out.println("*** Testing cases - and prediction ... ");
            int correctPredictions = 0;
            for (int i = 0; i < dataset.testCases.size(); i++) {
                List<String> dataPoint = dataset.testCases.get(i);
                Double expectedValue = dataset.expectedValues.get(i);
                double prediction = decisionTree.predict(tree, dataPoint, features);

                StringBuilder testCaseStr = new StringBuilder();
                for (int j = 0; j < features.size(); j++) {
                    if (j > 0) testCaseStr.append(", ");
                    testCaseStr.append(features.get(j)).append(" = ").append(dataPoint.get(j));
                }

                boolean isCorrect = Math.abs(expectedValue - prediction) < 0.1; // Adjust tolerance as needed
                if (isCorrect) correctPredictions++;

                System.out.println("+-----------------------------------------------------------------+");
                System.out.println("| From: { " + testCaseStr + " }");
                System.out.println("| Expects = " + expectedValue + ", Predicts = " + String.format("%.2f", prediction) + (isCorrect ? " (Correct)" : " (Incorrect)"));
                System.out.println("+-----------------------------------------------------------------+");
            }
            double accuracy = (double) correctPredictions / dataset.testCases.size();
            System.out.println("\nAccuracy: " + String.format("%.2f", accuracy * 100) + "%");
        }
    }

    public static void main(String[] args) {
        List<DataSet> datasets = new ArrayList<>();

        datasets.add(new DataSet(
                "src/main/resources/data/bikes.csv",
                Arrays.asList(0), // Ignore first column
                2,
                Arrays.asList(
                        Arrays.asList("0.3", "0.65", "0.15"),
                        Arrays.asList("0.5", "0.55", "0.25")),
                Arrays.asList(200.0, 300.0)
        ));

        datasets.add(new DataSet(
                "src/main/resources/data/wine-simple.csv",
                Arrays.asList(0),   // Ignore first column
                                    //  Arrays.asList(0, 2), // Ignore first and third columns
                2,
                Arrays.asList(
                            Arrays.asList("0.72", "0.74", "12.8"),
                            Arrays.asList("0.72", "0.74", "5.5")),
                Arrays.asList(5.0, 10.0)
        ));

        for (DataSet dataset : datasets) {
            if (dataset.process) {
                processDataSet(dataset);
            }
        }
    }
}



