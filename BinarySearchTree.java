```java

import java.util.*;
public class BST {

	static class Node
	{
		int data;
		Node left,right;
		
		public Node(int item)
		{
			this.data=item;
			left=right=null;
		}
	}
	Node root;
	BST()
	{
		root=null;
	}
	void insert(int data)
	{
		root=insertRec(root,data);
	}
	Node insertRec(Node root,int data)
	{
		if(root==null)
		  root=new Node(data);
		if(root.data>data)
		{
			root.left=insertRec(root.left,data);
		}else if(root.data<data)
		{
			root.right=insertRec(root.right,data);
		}
		return root;
	}
	void inorder()
	{
		inorderRec(root);
	}
	void inorderRec(Node root)
	{
		if(root!=null)
		{
			inorderRec(root.left);
			System.out.print(root.data+" ");
			inorderRec(root.right);
		}

	}
	void delete(int data)
	{
		root=deleteRec(root,data);
	}
	Node deleteRec(Node root,int data)
	{
		 if(root==null)return root;
		    if(root.data>data)
		    {
		    	root.left=deleteRec(root.left,data);
		    }else if(root.data<data)
		    {
		    	root.right=deleteRec(root.right,data);
		    }else {
		    if(root.left==null && root.right==null)
		    {
		    	return null;
		    }
		    if(root.left==null)
		    {
		    	return root.right;
		    }else if(root.right==null)
		    {
		    	return root.left;
		    }
	         
		    root.data=min(root.right);
		    root.right=deleteRec(root.right,root.data);
		    }
		    return root;
	}
	int min(Node root)
	{
		int minvalue=root.data;
		while(root.left!=null)
		{
			root=root.left;
			minvalue=root.data;
		}
		return minvalue;
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		BST b=new BST();
		int n;
		System.out.println("enter the size of the array :");
		n=in.nextInt();
		System.out.println("enter the elements of the array :");
		for(int i=0;i<n;i++)
		{
			int ele=in.nextInt();
			b.insert(ele);
		}
		
		System.out.println("Inorder traversal :");
		b.inorder();
		System.out.println(" ");
		System.out.println("Enter the element to be deleted :");
		int d=in.nextInt();
		b.delete(d);
		System.out.println(" ");
		System.out.println("Inorder traversal :");
		b.inorder();
		
		in.close();
	}
}
