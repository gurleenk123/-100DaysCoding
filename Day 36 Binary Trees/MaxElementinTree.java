public class MaxElementinTree 
{
	Node root;
	public static int maxEle(Node root)
	{
		int max=Integer.MIN_VALUE;
		if(root!=null)
		
	{
		int leftmax=maxEle(root.left);
		int rightmax=maxEle(root.right);
		
		if(leftmax > rightmax)
		{
			max=leftmax;
		}
		else
		{
			max=rightmax;
		}
		if(root.data > max)
			max=root.data;
		
	  }
		
		return max;
	}
	
	//O(n)

	public static void main(String[] args) 
	{
		MaxElementinTree  tree = new MaxElementinTree ();
        tree.root = new Node(1);
        tree.root.left = new Node(22);
        tree.root.right = new Node(13);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(5);
        
        System.out.println(maxEle(tree.root));
        
		
	}

}
