import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal 
{
	static Node root;
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

	
	//O(n)
	
	public static void main(String[] args) 
	{
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        printlevel(root);
        
		
	}

}
