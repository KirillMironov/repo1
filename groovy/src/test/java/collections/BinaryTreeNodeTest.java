package collections;

import org.junit.Test;

/**
 * Created by kmiro on 26.02.2017.
 */
public class BinaryTreeNodeTest {
    //Создать дерево, состоящее из 7 узлов(!!!nodes!!!).
    //Распечатать строчки, хранящиеся в узлах дерева в любом порядке.
    //INFIX_TRAVERSE (tr) — обойти всё дерево, следуя порядку (левое поддерево, вершина, правое поддерево). Элементы по возрастанию
    //PREFIX_TRAVERSE (tr) — обойти всё дерево, следуя порядку (вершина, левое поддерево, правое поддерево). Элементы, как в дереве
    //POSTFIX_TRAVERSE (tr) — обойти всё дерево, следуя порядку (левое поддерево, правое поддерево', вершина). Элементы в обратном порядке, как в дереве

    @Test
    public void test(){
        BinaryTreeNode root = new BinaryTreeNode("root",0);//                 root
        BinaryTreeNode node1 = new BinaryTreeNode("a",1);//                    / \
        BinaryTreeNode node2 = new BinaryTreeNode("b",2);//                   b   d
        BinaryTreeNode node3 = new BinaryTreeNode("c",3);//                  /\   /\
        BinaryTreeNode node4 = new BinaryTreeNode("d",4);//                 a  c f  e
        BinaryTreeNode node5 = new BinaryTreeNode("e",5);//                /
        BinaryTreeNode node6 = new BinaryTreeNode("f",6);//               g
        BinaryTreeNode node7 = new BinaryTreeNode("g",7);//

        root.leftChild = node2;
        root.leftChild.leftChild = node1;
        root.leftChild.rightChild = node3;
        root.leftChild.leftChild.leftChild = node7;
        root.rightChild = node4;
        root.rightChild.leftChild = node6;
        root.rightChild.rightChild = node5;

        int currMax = -1;

        currMax = traverse(root, currMax);

        System.out.println(String.format("currMax=%d",currMax));

    }

    private int traverse(BinaryTreeNode node, int currMax){
        if ( node == null ){
            return currMax;
        }
        currMax = traverse(node.leftChild, currMax);
        currMax = Math.max(currMax, node.value);
        System.out.println(String.format("label=%s, value=%d, currMax=%d", node.label, node.value, currMax));
        currMax = traverse(node.rightChild, currMax);
        return currMax;
    }

}
