```java

public class horspool {
   final static int No_char=246;
   public void badcharHeustric(int m, char pat[], int badchar[])
   {
	   for(int i=0;i<No_char;i++)
	   {
		   badchar[i]=-1;
	   }
	   for(int i=0;i<m-1;i++)
	   {
		   badchar[i]=0;
	   }
   }
	public void search(char pat[], char txt[])
	{
		int m=pat.length;
		int n=txt.length;
		int badchar[]=new int[No_char];
		badcharHeustric(m,pat,badchar);
		int s=0;
		while(s<=(n-m))
		{
			int j=m-1;
			while(j>=0 && pat[j]==txt[s+j])
			{
				j--;
			}
			if(j<0)
			{
				System.out.println("Pattern present at the shift :"+s);
				if(s+m<n)
				{
					s=s+m-badchar[txt[s+m]];
					
				}else {
					s=s+1;
				}
			}else 
			{
				s=s+Math.max(1,j-badchar[txt[s+j]]);
			}
		}
	}
	public static void main(String args[])
	{
		horspool h=new horspool();
		char pat[]="ABC".toCharArray();
		char txt[]="ABBABAABCD".toCharArray();
		h.search(pat,txt);
	}
}
