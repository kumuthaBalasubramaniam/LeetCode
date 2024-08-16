class Solution
 {
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res=new ArrayList<>();
        Queue <TreeNode> q=new LinkedList<>();
        if(root==null)
        {
            return res;
        }
        q.offer(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer>List=new ArrayList<>();
            TreeNode temp=null;
            for(int i=0;i<size;i++)
            {
                temp=q.poll();
                List.add(temp.val);
                if(temp.left!=null)
                {
                    q.offer(temp.left);
                }
                if(temp.right!=null)
                {
                    q.offer(temp.right);
                }
            }
            res.add(List);
        }
        return res;
    }

        
    
}