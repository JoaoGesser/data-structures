package com.data.structures.binary;

import lombok.Data;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class MyOwnBinarySearchTree {
    private BinaryNode root;

    public void insert(Integer data) {
        if (Objects.isNull(data) || data < 1) return;
        if (Objects.isNull(root)) {
            this.root = generateNode(data);
        } else {
            recursiveInsert(data, this.root);
        }
    }

    private BinaryNode recursiveInsert(Integer data, BinaryNode root) {
        if (Objects.isNull(root)) {
            return generateNode(data);
        } else if (isLeftData(data, root.getData())) {
            root.setLeftNode(recursiveInsert(data, root.getLeftNode()));
        } else {
            root.setRighNode(recursiveInsert(data, root.getRighNode()));
        }

        return root;
    }

    /**
     * <root><left><right> Preorder
     */
    public List<Integer> traversalPreorder() {
        var preOrderList = new ArrayList<Integer>();
        recursiveTraversalPreorder(root, preOrderList);
        return preOrderList;
    }

    private void recursiveTraversalPreorder(BinaryNode root, ArrayList<Integer> preOrderList) {
        if (Objects.isNull(root)) return;
        preOrderList.add(root.getData());
        recursiveTraversalPreorder(root.getLeftNode(), preOrderList);
        recursiveTraversalPreorder(root.getRighNode(), preOrderList);
    }

    /**
     * <left><root><right> Inorder
     */
    public List<Integer> traversalInorder() {
        var inOrderList = new ArrayList<Integer>();
        recursiveTraversalInorder(root, inOrderList);
        return inOrderList;
    }

    private void recursiveTraversalInorder(BinaryNode root, ArrayList<Integer> inOrderList) {
        if (Objects.isNull(root)) return;
        recursiveTraversalInorder(root.getLeftNode(), inOrderList);
        inOrderList.add(root.getData());
        recursiveTraversalInorder(root.getRighNode(), inOrderList);
    }

    /**
     * <left><right><root> Postorder
     */
    public List<Integer> traversalPostorder() {
        var traversalList = new ArrayList<Integer>();
        recursiveTraversalPostorder(root, traversalList);
        return traversalList;
    }

    private void recursiveTraversalPostorder(BinaryNode root, ArrayList<Integer> postorderList) {
        if (Objects.isNull(root)) return;
        recursiveTraversalPostorder(root.getLeftNode(), postorderList);
        recursiveTraversalPostorder(root.getRighNode(), postorderList);
        postorderList.add(root.getData());
    }

    public List<Integer> traversalLevelorder() {
        var traversalList = new ArrayList<Integer>();
        var queueNodes = new LinkedList<BinaryNode>();
        queueNodes.add(root);

        do {
            BinaryNode node = queueNodes.getFirst();
            traversalList.add(node.getData());
            if (Objects.nonNull(node.getLeftNode())) {
                queueNodes.add(node.getLeftNode());
            }
            if (Objects.nonNull(node.getRighNode())) {
                queueNodes.add(node.getRighNode());
            }
            queueNodes.remove(node);
        } while (!queueNodes.isEmpty());


        return traversalList;
    }

    public boolean isBinarySearchTree() {
        return checkNodes(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkNodes(BinaryNode root, int minValue, int maxValue) {
        if (Objects.isNull(root)) return true;
        var data = root.getData();

        return data > minValue
                && data <= maxValue
                && checkNodes(root.getLeftNode(), minValue, data)
                && checkNodes(root.getRighNode(), data, maxValue);
    }

    public Integer getHeightFromTree() {
        return currentNodeLevel(root, -1);
    }

    private Integer currentNodeLevel(BinaryNode root, int level) {
        if (Objects.isNull(root)) return level;
        level++;

        Integer leftNodeLevel = currentNodeLevel(root.getLeftNode(), level);
        Integer rightNodeLevel = currentNodeLevel(root.getRighNode(), level);

        return leftNodeLevel > rightNodeLevel
                ? leftNodeLevel
                : rightNodeLevel;
    }

    public void deleteNode(Integer data) {
        findAndDeleteNode(root, data);
    }

    private BinaryNode findAndDeleteNode(BinaryNode root, Integer data) {
        if (Objects.isNull(root)) return null;

        if (data < root.getData()) {
            root.setLeftNode(findAndDeleteNode(root.getLeftNode(), data));
        } else if (data > root.getData()) {
            root.setRighNode(findAndDeleteNode(root.getRighNode(), data));
        } else {
            if (isNodeHasNoChild(root)) {
                root = null;
            } else if (isNodeHasLeftChild(root)) {
                root = root.getLeftNode();
            } else if (isNodeHasRightChild(root)) {
                root = root.getRighNode();
            } else {
                BinaryNode minNode = findMin(root.getRighNode());
                root.setData(minNode.getData());
                root.setRighNode(findAndDeleteNode(root.getRighNode(), data));
            }
        }

        return root;
    }

    public boolean isExistsData(BinaryNode root, Integer data) {
        if (data.equals(root.getData())) return true;

        if (data < root.getData() && Objects.nonNull(root.getLeftNode())) {
            return isExistsData(root.getLeftNode(), data);
        } else if (Objects.nonNull(root.getRighNode())) {
            return isExistsData(root.getRighNode(), data);
        }

        return false;
    }

    public String getTopView() {
        if (Objects.isNull(root)) return null;

        String data = String.valueOf(root.getData());
        data += getTopViewLeft(root.getLeftNode());
        data += getTopViewRight(root.getRighNode());

        return data;
    }

    public static String getTopViewLeft(BinaryNode root) {
        if (Objects.isNull(root)) return "";
        String data = " " + root.getData();
        List<String[]> a = new ArrayList<>();
        a.add(data.split(" "));
        //a.stream().sorted(Comparator.comparingInt())

        return data + getTopViewLeft(root.getLeftNode());
    }

    public static String getTopViewRight(BinaryNode root) {
        if (Objects.isNull(root)) return "";
        String data = " " + root.getData();
        return data + getTopViewRight(root.getRighNode());
    }


    public BinaryNode findMin(BinaryNode root) {
        if (Objects.isNull(root)) return null;

        return Objects.nonNull(root.getLeftNode()) ? findMin(root.getLeftNode()) : root;
    }

    private boolean isNodeHasRightChild(BinaryNode root) {
        return Objects.nonNull(root.getRighNode());
    }

    private boolean isNodeHasLeftChild(BinaryNode root) {
        return Objects.nonNull(root.getLeftNode());
    }

    private boolean isNodeHasNoChild(BinaryNode root) {
        return Objects.isNull(root.getLeftNode()) && Objects.isNull(root.getRighNode());
    }


    private boolean isLeftData(Integer data, Integer rootData) {
        return data <= rootData;
    }

    private BinaryNode generateNode(Integer data) {
        return new BinaryNode(data);
    }

    public BinaryNode generateTreeFromArray(int[] arr) {
        for (int v : arr) {
            insert(v);
        }
        return null;
        //return insertLevelOrder(arr, 0);
    }

    private BinaryNode insertLevelOrder(int[] arr, int i) {
        BinaryNode root = null;
        if (i < arr.length) {
            root = new BinaryNode(arr[i]);
            root.setLeftNode(insertLevelOrder(arr, 2 * i + 1));
            root.setRighNode(insertLevelOrder(arr, 2 * i + 2));
        }

        return root;
    }


}
