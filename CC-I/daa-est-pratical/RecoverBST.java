import java.util.*

public class RecoverBST{

    public void recoverBST(TreeNode root){

        if (root == null) {
            return;
        }
        inOrder(root);
        TreeNode first = null
        TreeNode second = null
        
        for (let i = 0; i < nodes.length - 1; i++) {
         if (nodes[i].value > nodes[i + 1].value) {
            if (first == null){
                first = nodes[i]
            }
            second = nodes[i + 1]
        }
    }
        swapNodes(first,second);
    }

    function InOrder(root, nodes){
        if(root == null){
            return;
        }

        InOrder(root.left, nodes);
        nodes.add(root);
        recoverBST(root.right, nodes);
    }

    function swapNodes(node1, node2) {
        let temp = node1.value
        node1.value = node2.value
        node2.value = temp
    }
}