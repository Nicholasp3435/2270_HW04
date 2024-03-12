package datastructures;

/**
 * <strong>TreeNode</strong> - Represents a node in a decision tree, encapsulating decisions
 * based on features and thresholds or holding values for leaf nodes. Useful in classification,
 * regression, or hierarchical decision-making processes.<br><br>
 * <p>
 * Nodes support binary decisions with `left` and `right` children for branching, enabling
 * recursive tree construction, traversal, and prediction operations. This structure is
 * integral to decision tree algorithms, facilitating both decision points and outcome
 * representation.<br><br>
 * </p>
 * <strong>Note:</strong> Intended for educational purposes to illustrate decision tree
 * implementation. Unauthorized distribution or publishing online or on other platforms
 * is not allowed.<br><br>
 * <strong>Usage:</strong> Used within decision tree algorithms, not typically instantiated
 * in application code.<br><br>
 * <strong>Example:</strong><br>
 * <pre>
 *      TreeNode leaf = new TreeNode(42.0);
 *      TreeNode decisionNode = new TreeNode("FeatureX", 0.5, leftChild, rightChild, null);
 * </pre>
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */

public class TreeNode {
    public String feature;
    public double threshold;
    public TreeNode left;
    public TreeNode right;
    public Double value;

    /**
     * Constructs a TreeNode with specified feature, threshold, children, and value.
     * <br><br>
     * Initializes a TreeNode for decision-making with feature and threshold. Sets up
     * left and right child nodes for branching. Leaf nodes use a separate constructor.
     * <br><br>
     * @param feature Name of the feature for decision at this node.
     * @param threshold Threshold value for deciding left or right branch.
     * @param left Left child node (decisions/outputs less than threshold).
     * @param right Right child node (decisions/outputs greater than threshold).
     * @param value Output value for leaf nodes; null for decision nodes.
     */

    public TreeNode(
                    String feature,
                    double threshold,
                    TreeNode left,
                    TreeNode right,
                    Double value) {
        this.feature = feature;
        this.threshold = threshold;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    /**
     * Constructs a TreeNode representing a leaf node with a specific value.
     * <br><br>
     * This constructor initializes a leaf node with the given output value,
     * intended for endpoints in a decision tree without further branching.
     * <br><br>
     * @param value Output value for the leaf node.
     */
    public TreeNode(Double value) {
        this.value = value;
    }
}