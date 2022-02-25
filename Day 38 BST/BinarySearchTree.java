import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree 
{
	static Node root;
	
	
	public static Node insert(Node node,int k)
	{
		if(node==null)
		{
			node=new Node(k);
			return node;
			
		}
		if (k < node.data)
            node.left = insert(node.left, k);
        else if (k > node.data)
            node.right = insert(node.right, k);
 
       
        return node;
		
	}
	
	

		public static void printlevel(Node node)
		{
			Queue<Node> q=new LinkedList<>();
			q.add(node);
			while(!q.isEmpty())
			{
				Node temp=q.poll();
				System.out.print(temp.data +" ");
				if(temp.left!=null)
				{
					q.add(temp.left);
				}
				if(temp.right!=null)
				{
					q.add(temp.right);
				}
			}
		}
	

	public static void main(String[] args) 
	{
		root=insert(root,50);
		root=insert(root,30);
		root=insert(root,20);
		root=insert(root,40);
		root=insert(root,70);
		
        printlevel(root);
        

	}

}
