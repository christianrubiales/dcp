package com.christianrubiales.dcp._07trees;

import java.util.LinkedList;
import java.util.List;

/*
 * @see https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74264/Short-and-straight-forward-BFS-Java-code-with-a-queue
 */
public class SerializeBinaryTree {

	static class Node {
		String val;
		Node left;
		Node right;	

		Node(String val) {
			this.val = val;
		}
		
		Node(String val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static String serialize(Node root) {
		if (root == null) {
			return "null";
		}
		
		List<Node> list = new LinkedList<>();
		list.add(root);
		StringBuilder builder = new StringBuilder();
		
		while (!list.isEmpty()) {
			Node node = list.remove(0);
			if (node == null) {
				builder.append("null,");
			} else {
				builder.append(node.val).append(',');
				list.add(node.left);
				list.add(node.right);
			}
		}

		String s = builder.toString();
		return s.substring(0, s.length() - 1);
	}

	static Node deserialize(String serialized) {
		if (serialized.equals("null")) {
			return null;
		}

		List<Node> list = new LinkedList<>();
		String[] array = serialized.split(",");
		Node root = new Node(array[0]);
		list.add(root);
		
		for (int i = 1; i < array.length; i++) {
			Node node = list.remove(0);

			if (!array[i].equals("null")) {
				node.left = new Node(array[i]);
				list.add(node.left);
			}

			if (!array[++i].equals("null")) {
				node.right = new Node(array[i]);
				list.add(node.right);
			}
		}
		
		return root;
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
