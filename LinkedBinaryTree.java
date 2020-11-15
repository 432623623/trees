//package jsjf;
import java.util.*;
//import jsjf.exceptions.*;
/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 *
 * @author Java Foundations
 * @version 4.0
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {
    protected BinaryTreeNode<T> root;
    protected int modCount;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() {
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(T element) {
        root = new BinaryTreeNode<T>(element);
    }

    /**
     * Creates a binary tree with the specified element as its root and the
     * given trees as its left child and right child
     *
     * @param element the element that will become the root of the binary tree
     * @param left    the left subtree of this tree
     * @param right   the right subtree of this tree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left,
                            LinkedBinaryTree<T> right) {
        root = new BinaryTreeNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree. Throws a ElementNotFoundException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if the element is not in the tree
     */
    public T find(T targetElement) throws ElementNotFoundException {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        if (current == null)
            throw new ElementNotFoundException("LinkedBinaryTree");
        return (current.getElement());
    }

    public T getRootElement() throws ElementNotFoundException {
        return getRootElement();
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next          the element to begin searching from
     */
    private BinaryTreeNode<T> findNode(T targetElement,
                                       BinaryTreeNode<T> next) {
        if (next == null)
            return null;
        if (next.getElement().equals(targetElement))
            return next;
        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
        if (temp == null)
            temp = findNode(targetElement, next.getRight());
        return temp;
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iteratorInOrder() {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);
        return new TreeIterator((BinaryNode) tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node     the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inOrder(BinaryTreeNode<T> node,
                           ArrayUnorderedList<T> tempList) {
        if (node != null) {
            inOrder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }
}