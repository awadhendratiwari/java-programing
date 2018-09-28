package tree;

import java.util.List;

/*
* This interface represents contract defined by binary tree.
* It will represent basic functionality supported by binary tree.
* This is education purpose program only.
* */
public interface IBinaryTree<T extends Comparable<T>> {
    /*
    * This method is used to add new elements in binary tree.
    * If added element is first element in tree then it will be root element
    * and corresponding node is root node.
    * */
    void addElement(T element);

    /*
    * This method will create binary tree containing all elements in List.
    * If the first element in List<T> is the first element is binary tree
    * then it will be root element. Next element will added left to root
    * element and them right. This pattern will be followed for all elements.
    * */
    void addElements(List<T> elements);

    /*
    * This method will add another binary tree in existing binary tree.
    * Element extraction will be started from root, left and right and
    * will be added in same order in existing binary tree.
    * */
    void addBinaryTree(IBinaryTree<T> binaryTree);

    /*
    * This method will make binary tree using inorder traversal.
    * When binary tree will be ready then inorder traversal of binary
    * tree will be same as given inorder traversal.
    * */
    void makeTreeByInOrderElement(List<T> inOrderData);

    /*
    * This method will make binary tree using pre-order traversal.
    * When binary tree will be ready then pre order traversal of binary
    * tree will be same as given pre-order traversal.
    * */
    void makeTreeByPreOrderElement(List<T> preOrderData);

    /*
     * This method will make binary tree using post-order traversal.
     * When binary tree will be ready then post order traversal of binary
     * tree will be same as given post-order traversal.
     * */
    void makeTreeByPostOrderElement(List<T> postOrderData);

    /*
    * This method is used to check whether given element exist in
    * binary tree or not. True if element exist otherwise False.
    * */
    boolean findElement(T element);

    /*
    * This method will give you next element of given element in in-order traversal.
    * */
    T getInOrderSuccessor(T element);

    /*
    * This method will give previous element of given element in in-order traversal.
    * */
    T getInOrderPredecessor (T element);

    /*
    * This method will give you next element of given element in pre-order traversal.
    * */
    T getPreOrderSuccessor(T element);

    /*
    * This method will give you previous element of given element in pre-order traversal.
    * */
    T getPreOrderPredecessor(T element);

    /*
     * This method will give you next element of given element in post-order traversal.
     * */
    T getPostOrderSuccessor(T element);

    /*
     * This method will give you previous element of given element in post-order traversal.
     * */
    T getPostOrderPredecessor(T element);

    /*
    * This method is used to find minimum element in binary tree.
    * */
    T getMinElement();

    /*
    * This method is used to find maximum element in binary tree.
    * */
    T getMaxElement();

    /*
    * This method will return number of elements in binary tree.
    * */
    int getNumberOfElements();

    /*
    * This method will return level of node corresponding to given element.
    * */
    int getLevelOfElement(T element);

    /*
    *This method will return height of binary tree.
    * */
    int getHeightOfTree();

    /*
    * This method will return subtree corresponding to given element.
    * */
    IBinaryTree<T> getSubTree(T element);

    /*
    * This method will give you in-order traversal of binary tree.
    * In-order traversal defined as left-root-right.
    * */
    List<T> getInOrderElement();

    /*
    * This method will give you pre-order traversal of binary tree.
    * Pre-order traversal defined as root-left-right.
    * */
    List<T> getPreOrderElement();

    /*
    * This method will return post-order traversal of binary tree.
    * Post-order traversal defined as left-right-root.
    * */
    List<T> getPostOrderElement();

    /*
    * This method will return level-order traversal of binary tree.
    * */
    List<T> getLevelOrderElement();

    /*
    * This method will delete an element in binary tree.
    * */
    boolean delete(T element);

    /*
    * This method will delete binary tree.
    * In summary this method will delete all elements in binary tree.
    * */
    boolean deleteAll();
}
