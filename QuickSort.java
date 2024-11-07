```java
import java.util.*;
public class quicksort {
  
	public void quick(int a[], int low,int high)
	{
		if(low>=high)return;
		int pivot=find(a,low,high);
		quick(a,low,pivot-1);
		quick(a,pivot+1,high);
	}
	public int find(int a[], int low, int high)
	{
		int i=low;
		int j=high;
		int pivot=a[low];
		while(i<j)
		{
			while(i<=high && a[i]<=pivot)
			{
				i++;
			}
			while(j>=low && a[j]>pivot)
			{
				j--;
			}
			if(i<j)
			{
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		int temp1=a[j];
		a[j]=a[low];
		a[low]=temp1;
		return j;
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
		quicksort m=new quicksort();
		int low=0;int high=n-1;
		m.quick(a, low, high);
		System.out.println("Array after merge sort :");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		in.close();
	}
}
