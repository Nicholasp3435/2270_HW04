package applications;

import algorithms.DecisionTree;
import datastructures.TreeNode;
import graphics.TreeVisualizer;

/**
 * <strong>DemoTreeVisualizer</strong> - Showcases the construction and
 * visualization of a decision tree using predefined features and thresholds.
 * Utilizes the TreeVisualizer class for visualization and demonstrates tree
 * traversal (pre-order, in-order, post-order) to explore the tree's structure
 * and decision sequence.<br><br>
 * <p>
 * The demo tree is manually constructed, serving as an illustrative example to
 * learn about decision tree representation, visualization, and traversal, not
 * based on any dataset.<br><br>
 * </p>
 *
 * <strong>Note:</strong> Intended for educational purposes to demonstrate
 * decision trees. Unauthorized distribution or publishing online or on other
 * platforms is not allowed.<br><br>
 *
 * <strong>Usage</strong>: Execute the main method to view the decision tree
 * visualization and traversal outputs.<br><br>
 *
 * <strong>Dependencies</strong>: Relies on DecisionTree, TreeNode, and TreeVisualizer
 * classes.<br><br>
 *
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */


public class DemoTreeVisualizer {
    private static TreeNode buildDecisionTree() {
        // Constructing a fake tree
        TreeNode root = new TreeNode("Feature1", 5.5, null, null, null);
        root.left = new TreeNode("Feature2", 3.0, null, null, null);
        root.right = new TreeNode("Feature3", 7.0, null, null, null);
        root.left.left = new TreeNode(null, 0.0, null, null, 1.0); // Leaf node
        root.left.right = new TreeNode(null, 0.0, null, null, 2.0); // Leaf node
        root.right.left = new TreeNode(null, 0.0, null, null, 3.0); // Leaf node
        root.right.right = new TreeNode(null, 0.0, null, null, 4.0); // Leaf node

        return root;
    }

    public static void main(String[] args) {
        // Constructing a fake tree

        TreeNode root = buildDecisionTree();
        // Displaying the fake tree using TreeVisualizer
        TreeVisualizer.display(root);

        // Displaying the fake tree using TreeVisualizer with an empty node
        TreeVisualizer.display(null);

        DecisionTree decisionTree = new DecisionTree();

        // Print the nodes of the tree in pre-order traversal
        System.out.println("\n\nPre-order traversal of the decision tree:");
        decisionTree.preOrderTraversal(root);

        // Print the nodes of the tree in in-order traversal
        System.out.println("\n\nIn-order traversal of the decision tree:");
        decisionTree.inOrderTraversal(root);

        // Print the nodes of the tree in pre-order traversal
        System.out.println("\n\nPost-order traversal of the decision tree:");
        decisionTree.postOrderTraversal(root);
    }
}
