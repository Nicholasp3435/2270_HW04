package graphics;

import datastructures.TreeNode;
import javax.swing.*;
        import java.awt.*;

//345678901234567890123456789012345678901234567890123456789012345678901234567890

/**
 * <strong>TreeVisualizer</strong> - Visualizes a decision tree structure within
 * a graphical window. Extending JPanel, this class draws the tree's nodes and
 * branches, representing the tree's hierarchical structure through recursive
 * drawing methods.<br><br>
 * <p>
 * Nodes are visualized as ovals (internal nodes) or rectangles (leaf nodes),
 * with lines connecting parents to children. It also handles cases with no
 * tree to display, showing a placeholder message.<br><br>
 * </p>
 * <strong>Usage:</strong> Create an instance with the tree's root node and add
 * it to a JFrame to visualize a decision tree. The tree displays when the JFrame
 * is rendered.<br><br>
 * <strong>Example:</strong><br>
 * <pre>
 *  TreeNode root = // construct or obtain a decision tree root
 *  TreeVisualizer visualizer = new TreeVisualizer(root);
 *  JFrame frame = new JFrame("Tree Visualization");
 *  frame.add(visualizer);
 *  frame.setSize(400, 400);
 *  frame.setVisible(true);
 * </pre>
 * <strong>Note:</strong> Intended for educational purposes to demonstrate
 * graphical visualization of decision trees.<br><br>
 *
 * @version 1.0, 2023-03-11
 * @author Maria Hybinette
 * @copyright Copyright (c) 2023-2024, Maria Hybinette. All rights reserved.
 *
 */

 public class TreeVisualizer extends JPanel {
    private TreeNode root;
    private final int nodeRadius = 20;
    private final int verticalSpacing = 50;

    public TreeVisualizer(TreeNode root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null) {
            drawTree(g, root, getWidth() / 2, 30, getWidth() / 4);
        } else {
            // drawNoTree(g);
            drawNoTree(g, root, getWidth() / 2, 30, getWidth() / 4);

        }
    }

    private void drawTree( Graphics g, TreeNode node, int x, int y, int xOffset ) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2)); // You can adjust the stroke width as needed

        if (node == null) return;

        if (node.left != null) {
            g.drawLine(x, y, x - xOffset, y + verticalSpacing);
            drawTree(g, node.left, x - xOffset, y + verticalSpacing, xOffset / 2);
        }

        if (node.right != null) {
            g.drawLine(x, y, x + xOffset, y + verticalSpacing);
            drawTree(g, node.right, x + xOffset, y + verticalSpacing, xOffset / 2);
        }

        boolean adjustable = true;
        if (adjustable == true ) {
            // Adjust the size of the oval based on the text length
            String nodeText = node.value != null ? String.format("%.2f", node.value) : node.feature + " <= " + String.format("%.2f", node.threshold);
            int textWidth = g.getFontMetrics().stringWidth(nodeText);
            int ovalWidth = Math.max(textWidth + 10, 2 * nodeRadius); // Ensure minimum width

            // Draw a rectangle for leaf nodes and an oval for internal nodes
            if (node.left == null && node.right == null) {
                g.setColor(Color.WHITE);
                g.fillRect(x - ovalWidth / 2, y - nodeRadius, ovalWidth, 2 * nodeRadius);
                g.setColor(Color.BLACK);
                g.drawRect(x - ovalWidth / 2, y - nodeRadius, ovalWidth, 2 * nodeRadius);
            } else {
                g.setColor(Color.WHITE);
                g.fillOval(x - ovalWidth / 2, y - nodeRadius, ovalWidth, 2 * nodeRadius);
                g.setColor(Color.BLACK);
                g.drawOval(x - ovalWidth / 2, y - nodeRadius, ovalWidth, 2 * nodeRadius);
            }
            // Center the text within the oval or rectangle
            g.drawString(nodeText, x - textWidth / 2, y + 5);
        } else { // super simple tree below - not adjustable ...
            g.setColor(Color.WHITE);
            g.fillOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            g.setColor(Color.BLACK);
            g.drawOval(x - nodeRadius, y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            g.drawString(node.value != null ? String.format("%.2f", node.value) : node.feature + " <= " + String.format("%.2f", node.threshold), x - nodeRadius + 5, y + 5);
        }
    }


    private void drawNoTree( Graphics g, TreeNode node, int x, int y, int xOffset ) {
    // private void drawNoTree(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the stroke to dashed
        float[] dashPattern = { 10, 10 };
        g2.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, dashPattern, 0));

        // Set fill color to light grey and draw the oval
        g2.setColor(new Color(211, 211, 211)); // Light grey
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        g2.fillOval(xCenter - 50, yCenter - 30, 100, 60);

        // Set the stroke color to black and draw the dashed oval outline
        g2.setColor(Color.BLACK);
        g2.drawOval(xCenter - 50, yCenter - 30, 100, 60);

        // Draw the "No tree" text
        String text = "No tree";
        FontMetrics metrics = g.getFontMetrics();
        int xText = xCenter - (metrics.stringWidth(text) / 2);
        int yText = yCenter + (metrics.getHeight() / 2) - 3; // Adjust to center the text vertically
        g2.drawString(text, xText, yText);

        // upper part
        g2.setColor(new Color(255, 255, 255)); // White
        g2.fillOval(x - 50, y , 100, 60);
        g2.setColor(Color.BLACK);
        int xMetrics = (metrics.stringWidth(text) / 2);
        int yMetrics = (metrics.getHeight() / 2) - 3;

        g2.drawOval(x - 50, y , 100, 60);
        g2.drawString(text, x-xMetrics, y+25+2*yMetrics);

    }

    public static void display(TreeNode root) {
        JFrame frame = new JFrame("Decision Tree Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TreeVisualizer(root));
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
