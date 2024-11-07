```java
import java.util.*;
public class Nqueen {

	public boolean NQUEEN(int n)
	{
		int board[][]=new int [n][n];
		if(!solveNqueen(board,0,n))
		{
			return false;
		}
		display(board,n);
		return true;
	}
	public boolean solveNqueen(int board[][], int col,int n)
	{
		if(col>=n)return true;
		for(int i=0;i<n;i++)
		{
			if(isSafe(board,i,col,n))
			{
				board[i][col]=1;
				if(solveNqueen(board,col+1,n))
				{
					return true;
				}
				board[i][col]=0;
			}
		}
		return false;
	}
	public boolean isSafe(int board[][], int row,int col,int n)
	{
		for(int i=0;i<col;i++)
		{
			if(board[row][i]==1)return false;
		}
		for(int i=row,j=col;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]==1)return false;
		}
		for(int i=row,j=col;i<n && j>=0;i++,j--)
		{
			if(board[i][j]==1)return false;
		}
		return true;
	}
	public void display(int board[][], int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(board[i][j]==1)
				{
					System.out.print("Q");	
				}else
				{
					System.out.print("-");	
				}
			
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		Nqueen p=new Nqueen();
		System.out.println("Enter the number of queens :");
		int n=in.nextInt();
		p.NQUEEN(n);
		in.close();
	}
}
