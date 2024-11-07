```java
  
import java.util.*;
public class knapsack {

	public static int knap(int wt[],int W,int profit[],int n)
	{
		if(n==0 || W==0)
		{
			return 0;
		}
		int dp[][]=new int [n+1][W+1];
		for(int i=0;i<=n;i++)
		{
			dp[i][0]=0;
		}
		for(int w=0;w<=W;w++)
		{
			dp[0][w]=0;
		}
		for(int i=1;i<=n;i++)
		{
			for(int w=0;w<=W;w++)
			{
				if(wt[i-1]<=w)
				{
					dp[i][w]=Math.max(dp[i-1][w],dp[i-1][w-wt[i-1]]+profit[i-1]);
				}else {
					dp[i][w]=dp [i-1][w];
				}
			}
		}
		return dp[n][W];
	}
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n;
		System.out.println("Enter the number of products :");
		n=in.nextInt();
		int wt[]=new int[n];
		int profit[]=new int[n];
		System.out.println("Enter the total weight of the knapsack :");
		int W=in.nextInt();
		System.out.println("Enter the weight and the profits of the product respectively :");
		for(int i=0;i<n;i++)
		{
			wt[i]=in.nextInt();
            profit[i]=in.nextInt();	
		}
		int solution=knap(wt,W,profit,n);
		System.out.println("The total cost of the knapsact :"+solution);
		in.close();
	}
}
