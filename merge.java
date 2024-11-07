```java

import java.util.*;
public class merge {
	
	public void sort(int a[], int low, int high)
	{
		if(low>=high)return;
		int mid=(low+high)/2;
		sort(a,low,mid);
		sort(a,mid+1,high);
		combine(a,mid,low,high);
	}
	public void combine(int a[], int mid, int low, int high)
	{
		int left=low;
		int right=mid+1;
		Vector<Integer>temp=new Vector<>();
		while(left<=mid && right<=high)
		{
			if(a[left]<a[right])
			{
				temp.add(a[left]);left++;
			}else if(a[right]<a[left])
			{
				temp.add(a[right]);right++;
			}
		}
		while(left<=mid)
		{
			temp.add(a[left]);left++;
		}
		while(right<=high)
		{
			temp.add(a[right]);right++;
		}
	   for(int ele:temp)
	   {
		   a[low]=ele;
		   low++;
	   }
		
	}
	public static void main(String args[])
	{
		Scanner in= new Scanner(System.in);
		int n;
		System.out.println("Enter the size of the array :");
		n=in.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the elements of the array :");
		for(int i=0;i<n;i++)
		{
			a[i]=in.nextInt();
		}
		merge m=new merge();
		int low=0;int high=n-1;
		m.sort(a,low,high);
		System.out.println("Array after merge sort :");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		in.close();
	}
}
