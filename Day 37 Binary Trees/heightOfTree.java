//maximum depth or height of tree
public class heightOfTree 
{
	static Node root;
	public static int height(Node temp)
	{
		if(temp==null)
			return -1;
		
		int leftheight=height(temp.left);
		int rightheight=height(temp.right);
		if(leftheight > rightheight)
			return 1+ leftheight;
		else
			return 1+ rightheight;
	}
	

	//O(n)
	public static void main(String[] args) 
	{
		
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
		System.out.println(height(root));
		
	}

}
