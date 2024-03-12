package algorithms;

import datastructures.TreeNode;
import utility.DataUtils;

import java.util.List;
import java.util.ArrayList;

/**
 * <strong>DecisionTree</strong> - Represents a Decision Tree for classification
 * or regression tasks. This class allows building a decision tree from a
 * dataset, predicting target values for new data points,
 * and tree traversal.<br><br>
 * <p>
 * The tree is constructed by recursively selecting the best feature based on
 * correlations with the target variable, aiming for subsets with high purity.
 * It serves as a framework for understanding decision tree algorithms,
 * including methods for building, predicting, and traversing (pre-order,
 * in-order, post-order). Knowledge of decision tree concepts, recursive
 * algorithms, and data manipulation is required.<br><br>
 * </p>
 *
 * <strong>Note:</strong> This class is intended for educational purposes to
 * demonstrate the implementation and use of decision trees. Unauthorized
 * distribution or publishing of the solution on the web or any other platform
 * is not allowed.<br><br>
 *
 * @author Maria Hybinette
 * @version 1.0, 2023-03-11
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */

public class DecisionTree {
    private TreeNode root; // Store the root of the decision tree


    /**
     * Builds the decision tree based on the input data, features, target variable,
     * current depth, and maximum depth. This method recursively splits the data to
     * create a tree structure.
     *
     * @param data The dataset used to build the tree, where each list within the list represents a data point.
     * @param features List of feature names corresponding to columns in the dataset.
     * @param target The name of the target variable for prediction.
     * @param depth The current depth of the tree during the building process.
     * @param maxDepth The maximum allowed depth of the tree to prevent overfitting.
     * @return The root node of the constructed decision tree.
     *
     */
    public TreeNode buildTree(
            List<List<String>> data,
            List<String> features,
            String target,
            int depth,
            int maxDepth) {


// Building a Decision Tree:
//
// The goal of building a decision tree is to create a model that predicts the value of a
// target variable based on several input features.

// This is done by recursively splitting the data into subsets based on the values of the
// input features, creating a tree-like structure.
//
// At each node in the tree, we select the best feature to split on, based on its
// correlation with the target variable.
// This feature is used to divide the data into two subsets (left and right subsets):
//      left:  where the feature's value is less than or equal to a threshold
//      right: where the feature's value is greater than the threshold.
//
// As we move down the tree, the dataset at each node becomes smaller, as it
// only contains the subset of data relevant to that node.
// This process continues until we reach a stopping condition, such as reaching
// a maximum depth or having no more features to split on.
// At this point, a leaf node is created, which represents a prediction for
// the target variable based on the input features.
//
// By following this process, we build a decision tree that can be used to
// make predictions on new data by traversing the tree
// and following the splits based on the input features until a leaf node is reached.

 // Here are the steps in detail:

// Step 1: Check the base cases
// - 1) If the maximum depth has been reached, or 2) if there are no more features to split on,
//   or 3) if all the data points have the same target value, create a leaf node.
// - The leaf node should contain the most common target value in the current data subset.
// TODO: Implement the base cases

// Step 2: Select the BEST feature to split on
// - Calculate the correlation (or another suitable metric) between each feature and the target variable.
// - Choose the feature with the highest correlation as the best feature for the split on.
//      --Caveat: if there are features with equal correlation (ties), break the tie
//          by selecting the feature name with lower alphabetical name.
// TODO: Implement feature selection (we will use correlation for this HW)
// HINT: Create a method to select the best feature based on correlation. You might define a method like this:
// private String selectBestFeature(List<List<String>> data, List<String> features, int targetIndex, String tieBreakerMethod) {
//     // Your implementation goes here
//     // Calculate the correlation for each feature with the target
//     // Return the name of the feature with the highest correlation
//     // Use the tieBreakerMethod to decide in case of a tie
// }

// Step 3: Split the data
// - Use the median value of the best feature to split the data into two subsets: left and right.
// - The left subset should contain data points where the best feature's value is less than or equal to the median.
// - The right subset should contain data points where the best feature's value is greater than the median.
// TODO: Implement data splitting
// HINT: To split/filter the data, implement DataUtils.filterData(). See pseudo code in DataUtils.java.
// leftData = DataUtils.filterData(..., flag for leftData = true);
// rightData = DataUtils.filterData(..., flag for leftData = false);

// Step 5: Create the current tree node
// - The current node should contain the best feature, its median value, and the left and right subtrees.
// TODO: Implement node creation using new TreeNode(...)
// HINT: TreeNode() constructor is already complete

// TODO: Implement special cases
// HINT: If depth is zero, set the root to the currentNode - see package datastructures

// Return the current Node of the tree

        return null; // Placeholder - replace as needed.
    }

    // Method to  select the best feature for splitting
    //  the data based on correlation and a tiebreaker method
    private String selectBestFeature(
            List<List<String>> data,
            List<String> features,
            int targetIndex,
            String tieBreakerMethod) {

        // Hint: You may want to use DataUtils.calculateCorrelation
        //  to find the feature with the highest absolute correlation to the target
        String bestFeature = null; //
        double maxCorrelation = Double.NEGATIVE_INFINITY;
        double tolerance = 1e-6;    // Tolerance value for comparing correlations

        // TODO: Implement your logic to select the best feature here
        // Consider using the tieBreakerMethod if there's a tie

        return bestFeature; // Return the best feature if there is no tie or if the tiebreaker method is not specified
    }

    // Returns the root node of the decision tree
    public TreeNode getRoot() {
        return this.root;
    }

    // Predicts the target value for a given data point using the 'built' decision tree
    public double predict( TreeNode tree, List<String> dataPoint, List<String> features ) {
        // TODO: Implement the prediction logic by traversing
        // TODO:   the tree based on the features of the data point

        return 0; // Placeholder
    }

    public void preOrderTraversal(TreeNode node) {
        System.out.println("preOrderTraversal( Not Done )"); // Placeholder
        // TODO: Implement pre-order traversal and print each node using nodeToString
    }
    public void inOrderTraversal(TreeNode node) {
        System.out.println("inOrderTraversal( Not Done )"); // Placeholder
        // TODO: Implement in-order traversal and print each node using nodeToString
    }

    // Post-order traversal
    public void postOrderTraversal(TreeNode node) {
        System.out.println("postOrderTraversal( Not Done )"); // Placeholder
        // TODO: Implement post-order traversal and print each node using nodeToString

    }

    // Helper method to convert a node to a string representation
    private String nodeToString(TreeNode node) {
        // You can use this method to convert a node to a string for printing
        return (node.value != null) ? "Value: " + node.value
                : node.feature + " <= " + node.threshold;
    }

    // TODO (if needed): Additional methods can be added here
}
