import java.util.*;

public class InsertionInBinaryTree 
{
	static Node root;
	public static void insert(Node node,int ele)
	{
		if(node==null)
		{
			node=new Node(ele);
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty())
        {
        	node=q.peek();
        	q.remove();
        	
        	if(node.left==null)
        	{
        		node.left=new Node(ele);
        		break;
        	}
        	else
        	{
        		q.add(node.left);
        	}
        	
        	if(node.right ==null)
        	{
        		node.right=new Node(ele);
        		break;
        	}
        	else
        	{
        		q.add(node.right);
        	}
        }
		
	}
	static void inorder(Node node)
    {
        if (node == null)
            return;
 
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

	public static void main(String[] args) 
	{
		root=new Node(10);
		root.left=new Node(11);
		root.right=new Node(9);
		root.left.left=new Node(7);
		root.right.left=new Node(15);
		root.right.right=new Node(8);
		System.out.println("Inorder traversal before insertion:");
		inorder(root);
		int key = 12;
        insert(root, key);
        System.out.println("\nInorder traversal after insertion:");
        inorder(root);
		
		
		
		
		
	}

}
