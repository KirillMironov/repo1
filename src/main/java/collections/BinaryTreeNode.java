package collections;

/**
 * Created by kmiro on 26.02.2017.
 */
public class BinaryTreeNode {

    public String label;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;
    public int value;

    public BinaryTreeNode(String label, int value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "label='" + label + '\'' +
                ", value=" + value +
                '}';
    }
}
