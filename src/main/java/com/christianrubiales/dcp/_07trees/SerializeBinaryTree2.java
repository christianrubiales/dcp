package com.christianrubiales.dcp._07trees;

import java.util.LinkedList;
import java.util.List;

// My try
public class SerializeBinaryTree2 {

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
	
	static String serialize(Node root) {
		List<Node> level = new LinkedList<>();
		List<Node> nextLevel = new LinkedList<>();
		level.add(root);
		StringBuilder builder = new StringBuilder();
		while (!level.isEmpty()) {
			Node node = level.remove(0);
			
			if (node == null) {
				builder.append("null,");
			} else {
				builder.append(node.val).append(',');
				nextLevel.add(node.left);
				nextLevel.add(node.right);
			}
			
			if (level.isEmpty()) {
				level = nextLevel;
				nextLevel = new LinkedList<>();
			}
		}

		String s = builder.toString();
		return s.substring(0, s.length() - 1);
	}

	static Node deserialize(String serialized) {
		String[] arr = serialized.split(",");
		if (arr[0].equals("null")) {
			return null;
		}
		
		int index = 0;
		Node root = new Node(arr[index], null, null);
		Node node = root;
		
		while (index < arr.length) {
			Node temp = null;
			if (index + 1  < arr.length && !arr[index+1].equals("null")) {
				node.left = new Node(arr[index + 1], null, null);
				temp = node.left;
			}
			if (index + 2  < arr.length && !arr[index+2].equals("null")) {
				node.right = new Node(arr[index + 2], null, null);
				if (temp == null) {
					temp = node.right;
				}
			}
			index += 2;
			node = temp;
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
