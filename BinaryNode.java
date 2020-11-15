
public class BinaryNode<T> {
    /* three data fields, the first to store the item itself,
     * the other two for the left and right subtree,
     * either or both of which may be null.
     */
    protected T item;
    protected BinaryNode<T> left;
    protected BinaryNode<T> right;

    /* no-argument constructor sets everything to null */
    public BinaryNode() {
        item = null;
        left = null;
        right = null;
    }

    /* one-argument constructor: value as given, subtrees are null
     * @param	value, the value for the node
     */
    public BinaryNode(T value) {
        item = value;
        left = null;
        right = null;
    }

    /* constructor:
     * @param	value, the value for the node
     * @param	left, the left subtree
     * @param	right, the right subtree
     */
    public BinaryNode(T value, BinaryNode<T> leftSubtree,
                      BinaryNode<T> rightSubtree) {
        item = value;
        left = leftSubtree;
        right = rightSubtree;
    }

    /* accessor methods */
    public T getValue() {
        return item;
    }
    public BinaryNode<T> getLeft() {
        return left;
    }
    public BinaryNode<T> getRight() {
        return right;
    }

    /* mutator methods */
    public void setValue(T value) {
        item = value;
    }
    public void setLeft(BinaryNode<T> newLeft) {
        left = newLeft;
    }
    public void setRight(BinaryNode<T> newRight) {
        right = newRight;
    }

    /* toString
     * @returns	the string representation of the item.
     */
    public String toString() {
        return item + "";
    }

    /* unit test
     * @param	arguments, ignored
     */
    public static void main(String[] arguments) {
        BinaryNode<Integer> x = new BinaryNode<Integer>(); // no-arguments constructor
        BinaryNode<Integer> y = new BinaryNode<Integer>(3);
        BinaryNode<Integer> z = new BinaryNode<Integer>(9, x, y);

        printXyz(x, y, z);
        z.setValue(65);
        x.setValue(new Integer(16));
        printXyz(x, y, z);
    }