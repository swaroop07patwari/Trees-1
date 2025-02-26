//Time Complexity:O(N)
//Space Complexity:O(N) - O(N) for map and O(h) for stack space
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderandInorder {
    Map<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || inorder == null || preorder.length == 0){
            return null;
        }

        map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }


        return helper(preorder, 0, preorder.length - 1);

    }

    private TreeNode helper(int[] preorder, int start, int end){

        //base
        if(start > end){
            return null;
        }

        //logic
        int rootVal = preorder[idx];
        idx++;
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx-1);

        root.right = helper(preorder, rootIdx + 1, end);

        return root;

    }
}
