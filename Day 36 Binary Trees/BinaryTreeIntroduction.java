public class BinaryTreeIntroduction 
{
	Node root;
	 
	BinaryTreeIntroduction() 
	{ 
		root = null;
		
	}
	static void printInorder(Node node)
    {
        if (node == null)
            return;
 
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
	static void printPostOrder(Node node)
    {
        if (node == null)
            return;
        
        printPostOrder(node.right);
        printPostOrder(node.left);
        System.out.print(node.data + " ");
    
    }
	
	static void printPreOrder(Node node)
    {
        if (node == null)
            return;
 
        
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
	
	
	
	
 
	public static void main(String[] args) 
	{
		
		BinaryTreeIntroduction tree = new BinaryTreeIntroduction();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Inorder :");
        printInorder(tree.root);
        System.out.println("\nPost Order");
        printPostOrder(tree.root);
        System.out.println("\nPre order:");
        printPreOrder(tree.root);
	

}
}
