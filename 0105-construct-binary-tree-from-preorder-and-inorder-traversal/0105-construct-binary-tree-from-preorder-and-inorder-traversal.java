/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx=0;
    HashMap<Integer,Integer> mp=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      for(int i=0;i<inorder.length;i++){
        mp.put(inorder[i],i);
      }
      return build(preorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder,int st,int end ){
        if(st>end) return null;

        int rootVal=preorder[idx++];
        TreeNode root=new TreeNode(rootVal);

        int mid=mp.get(rootVal);

        root.left=build(preorder,st,mid-1);
        root.right=build(preorder,mid+1,end);

        return root;
    }
}