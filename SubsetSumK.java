```java
import java.util.*;
public class subset {

    public static boolean subset(int a[], int n, int k) {
        boolean dp[][]=new boolean[n+1][k+1];
        dp[0][0]=true;
        for(int i=0;i<n;i++) {
            dp[i][0]=true;
            if(a[0]<=k) {
                dp[0][a[0]]=true;
            }
        }
        
        for(int i=1;i<=n;i++) {
            for(int target=0;target<=k;target++) {
                boolean nottake=dp[i-1][target];
                boolean take=false;
                if(a[i-1]<=target) {
                    take=dp[i-1][target-a[i-1]];
                }
                dp[i][target]=take || nottake;
            }
        }
        
        if(!dp[n][k]) {
            System.out.println("Subset does not exist ");
            return false;
        }
        List<Integer>sset=new ArrayList<>();
        int i=n;
        int j=k;
        while(i>0 && j>0) {
            if(a[i-1]<=j) {
                sset.add(a[i-1]);
                j=j-a[i-1];
            }
            i--;
        }
        System.out.println("Subset of the sum k are :"+sset);
        return dp[n][k];
    }

    public static void main(String args[]) {
        Scanner in =new Scanner(System.in);
        int n;
        System.out.println("Enter the size of array :");
        n=in.nextInt();
        int a[]=new int[n];
        System.out.println("Enter the elements of array :");
        for(int i=0;i<n;i++) {
            a[i]=in.nextInt();
        }
        System.out.println("Enter the target sum :");
        int k=in.nextInt();
        boolean solution=subset(a,n,k);
        System.out.println("Does the subset of sum k exists :"+solution);
        in.close();
    }
}
