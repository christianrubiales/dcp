package com.christianrubiales.dcp._07trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @see https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
 */
public class SerializeBinaryTree1 {

	static class Node {
		String val;
		Node left;
		Node right;
		
		Node(String val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	public static String serialize(Node root) {
        StringBuilder builder = new StringBuilder();
        buildString(root, builder);

        return builder.toString();
    }

	// Preorder traversal
    private static void buildString(Node node, StringBuilder builder) {
        if (node == null) {
            builder.append("null").append(',');
        } else {
            builder.append(node.val).append(',');
            buildString(node.left, builder);
            buildString(node.right, builder);
        }
    }

    public static Node deserialize(String data) {
    	List<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));

        return buildTree(nodes);
    }

	// Preorder traversal
    private static Node buildTree(List<String> nodes) {
        String val = nodes.remove(0);
        Node node = null;

        if (!val.equals("null")) {
        	node = new Node(val, null, null);
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
        }

        return node;
    }

	public static void main(String[] args) {
		Node root = new Node("root", new Node("left", new Node("left.left", null, null), null), new Node("right", null, null));
		System.out.println(serialize(root));
		System.out.println(deserialize(serialize(root)).left.val);
		System.out.println(deserialize(serialize(root)).right.val);
		System.out.println(deserialize(serialize(root)).left.left.val);
		System.out.println();

		root = new Node("root", null, new Node("right", null, new Node("right.right", null, null)));
		System.out.println(serialize(root));
		System.out.println(deserialize(serialize(root)).right.val);
		System.out.println(deserialize(serialize(root)).right.right.val);
		System.out.println();

		System.out.println(serialize(null));
		System.out.println(deserialize(serialize(null)));

	}
}
