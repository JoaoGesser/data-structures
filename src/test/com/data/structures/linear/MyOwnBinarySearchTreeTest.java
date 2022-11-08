package com.data.structures.linear;

import com.data.structures.binary.BinaryNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class MyOwnBinarySearchTreeTest {

    @Test
    public void generateTreeFromArray() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        int[] arr = { 3, 5, 2, 1, 4, 6, 7 };
        var root = b.generateTreeFromArray(arr);
        //b.setRoot(root);
        System.out.println(b.getHeightFromTree());

        Assert.assertTrue(b.isBinarySearchTree());

    }

    @Test
    public void getTreeTopView() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        int[] arr = { 37,23,108,59,86,64,94,14,105,17,111,65,55,31,79,97,78,25,50,22,66,46,104,98,81,90,68,40,103,77,74,18,69,82,41,4,48,83,67,6,2,95,54,100,99,84,34,88,27,72,32,62,9,56,109,115,33,15,91,29,85,114,112,20,26,30,93,96,87,42,38,60,7,73,35,12,10,57,80,13,52,44,16,70,8,39,107,106,63,24,92,45,75,116,5,61,49,101,71,11,53,43,102,110,1,58,36,28,76,47,113,21,89,51,19,3 };
        var root = b.generateTreeFromArray(arr);
        //b.setRoot(root);
        System.out.println(b.getTopView());
    }


    @Test
    public void insertSimpleDataPerfectTree() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        var root = b.getRoot();
        Assert.assertEquals(Integer.valueOf(50), root.getData());
        Assert.assertEquals(Integer.valueOf(49), root.getLeftNode().getData());
        Assert.assertEquals(Integer.valueOf(51), root.getRighNode().getData());

    }

    @Test
    public void simpleDataPerfectTreeTraversalPreorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        var preOrderList = b.traversalPreorder();
        Assert.assertEquals(Arrays.asList(50, 49, 51), preOrderList);

    }

    @Test
    public void simpleDataPerfectTreeTraversalGetHeight() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        var height = b.getHeightFromTree();
        Assert.assertEquals(Integer.valueOf(0), height);
    }

    @Test
    public void simpleDataPerfectTreeDeletaData() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        b.deleteNode(51);
        Assert.assertFalse(b.isExistsData(b.getRoot(), 51));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 50));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 49));
        Assert.assertTrue(b.isBinarySearchTree());

    }

    @Test
    public void simpleDataPerfectTreeIsExistsData() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        Assert.assertTrue(b.isExistsData(b.getRoot(), 50));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 51));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 49));
        Assert.assertFalse(b.isExistsData(b.getRoot(), 12));
    }

    @Test
    public void simpleDataPerfectTreeTraversalInorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        var traversal = b.traversalInorder();
        Assert.assertEquals(Arrays.asList(49, 50, 51), traversal);
    }

    @Test
    public void simpleDataPerfectTreeTraversalPostorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        var traversal = b.traversalPostorder();
        Assert.assertEquals(Arrays.asList(49, 51, 50), traversal);

    }

    @Test
    public void simpleDataPerfectTreeTraversalLevelorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        var traversal = b.traversalLevelorder();
        Assert.assertEquals(Arrays.asList(50, 49, 51), traversal);

    }

    @Test
    public void simpleDataPerfectTreeFindMin() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        BinaryNode node = b.findMin(b.getRoot());
        Assert.assertEquals(Integer.valueOf(49), node.getData());

    }

    @Test
    public void simpleDataPerfectTreeDelete() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);

        BinaryNode node = b.findMin(b.getRoot());
        Assert.assertEquals(Integer.valueOf(49), node.getData());

    }

    @Test
    public void insertSimpleDataUnbalancedTree() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        var root = b.getRoot();
        Assert.assertEquals(Integer.valueOf(50), root.getData());
        Assert.assertEquals(Integer.valueOf(51), root.getRighNode().getData());

        Assert.assertEquals(Integer.valueOf(49), root.getLeftNode().getData());
        Assert.assertEquals(Integer.valueOf(48), root.getLeftNode().getLeftNode().getData());
        Assert.assertEquals(Integer.valueOf(47), root.getLeftNode().getLeftNode().getLeftNode().getData());

    }

    @Test
    public void simpleDataUnbalancedTreeExistsData() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        Assert.assertTrue(b.isExistsData(b.getRoot(), 50));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 51));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 49));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 48));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 47));
        Assert.assertFalse(b.isExistsData(b.getRoot(), 12));

    }

    @Test
    public void simpleDataUnbalancedTreeGetHeight() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        var height = b.getHeightFromTree();
        Assert.assertEquals(Integer.valueOf(2), height);

    }

    @Test
    public void simpleDataUnbalancedTreeDelete() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        b.deleteNode(49);
        Assert.assertTrue(b.isExistsData(b.getRoot(), 50));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 51));
        Assert.assertFalse(b.isExistsData(b.getRoot(), 49));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 48));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 47));

        Assert.assertTrue(b.isBinarySearchTree());

    }



    @Test
    public void simpleDataUnbalancedTreeFindMin() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        BinaryNode node = b.findMin(b.getRoot());
        Assert.assertEquals(Integer.valueOf(47), node.getData());
    }


    @Test
    public void simpleDataUnbalancedTreeTraversalPreorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        var traversal = b.traversalPreorder();
        Assert.assertEquals(Arrays.asList(50, 49, 48, 47, 51), traversal);

    }

    @Test
    public void simpleDataUnbalancedTreeTraversalInorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        var traversal = b.traversalInorder();
        Assert.assertEquals(Arrays.asList(47, 48, 49, 50, 51), traversal);
    }

    @Test
    public void simpleDataUnbalancedTreeTraversalLevelorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        var traversal = b.traversalLevelorder();
        Assert.assertEquals(Arrays.asList(50, 49, 51, 48, 47), traversal);
    }

    @Test
    public void simpleDataUnbalancedTreeTraversalPostorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(49);
        b.insert(48);
        b.insert(47);

        var traversal = b.traversalPostorder();
        Assert.assertEquals(Arrays.asList(47, 48, 49, 51, 50), traversal);
    }

    @Test
    public void secondTestSimpleDataUnbalancedTreeTraversalPreorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(55);
        b.insert(54);
        b.insert(49);
        b.insert(48);
        b.insert(40);
        b.insert(41);

        var traversal = b.traversalPreorder();
        Assert.assertEquals(Arrays.asList(50, 49, 48, 40, 41, 51, 55,54), traversal);

    }

    @Test
    public void secondTestSimpleDataUnbalancedTreeGetHeight() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(55);
        b.insert(54);
        b.insert(49);
        b.insert(48);
        b.insert(40);
        b.insert(41);

        var height = b.getHeightFromTree();
        Assert.assertEquals(Integer.valueOf(3), height);

    }

    @Test
    public void secondTestSimpleDataUnbalancedTreeTraversalInorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(55);
        b.insert(54);
        b.insert(49);
        b.insert(48);
        b.insert(40);
        b.insert(41);

        var traversal = b.traversalInorder();
        Assert.assertEquals(Arrays.asList(40, 41, 48, 49, 50, 51, 54, 55), traversal);

    }

    @Test
    public void secondTestSimpleDataUnbalancedTreeTraversalPostorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(55);
        b.insert(54);
        b.insert(49);
        b.insert(48);
        b.insert(40);
        b.insert(41);

        var traversal = b.traversalPostorder();
        Assert.assertEquals(Arrays.asList(41, 40, 48, 49, 54, 55, 51,50), traversal);

    }

    @Test
    public void secondTestSimpleDataUnbalancedTreeTraversalLevelorder() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(55);
        b.insert(54);
        b.insert(49);
        b.insert(48);
        b.insert(40);
        b.insert(41);

        var traversal = b.traversalLevelorder();
        Assert.assertEquals(Arrays.asList(50, 49, 51, 48, 55, 40, 54,41), traversal);

    }

    @Test
    public void secondTestSimpleDataUnbalancedTreeFindMin() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(55);
        b.insert(54);
        b.insert(49);
        b.insert(48);
        b.insert(40);
        b.insert(41);

        BinaryNode node = b.findMin(b.getRoot());
        Assert.assertEquals(Integer.valueOf(40), node.getData());
    }


    @Test
    public void secondTestSimpleDataUnbalancedDelete() {
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(50);
        b.insert(51);
        b.insert(55);
        b.insert(54);
        b.insert(49);
        b.insert(48);
        b.insert(40);
        b.insert(41);

        b.deleteNode(51);
        b.deleteNode(40);

        Assert.assertFalse(b.isExistsData(b.getRoot(), 51));
        Assert.assertFalse(b.isExistsData(b.getRoot(), 40));
        Assert.assertTrue(b.isExistsData(b.getRoot(), 41));
        Assert.assertTrue(b.isBinarySearchTree());
    }




    @Test
    public void generateRandomBinaryTree80() {
        com.data.structures.binary.MyOwnBinarySearchTree b = createRandomBinaryTree(80);

        Assert.assertTrue(b.isBinarySearchTree());
    }


    com.data.structures.binary.MyOwnBinarySearchTree createRandomBinaryTree(Integer root) {
        var ran = new Random();
        int iterations = ran.nextInt(2, 100);
        var b = new com.data.structures.binary.MyOwnBinarySearchTree();
        b.insert(root);
        for (int i = 0; i < iterations; i++) {
            b.insert(ran.nextInt(2, 100));
        }

        return b;
    }


}


