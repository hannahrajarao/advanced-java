public class FindIt extends Thread
{
	int search; //random number to search for
	int start; //beginning index of range to search within
	int end; //end index of range to search within
	
	FindIt(int s, int b, int e)
	{
		search = s;
		start = b;
		end = e;
	}
	public void run()
	{
		int i=start;
		loop:
		while(i<=end)
		{
			for(int j=i; j<Math.min(end,i+10); j++)
			{
				if(j==search)
				{
					System.out.println(this.getName()+" found target value "+j);
					break loop;
				}

			}
			Thread.yield();
			i += 10;
		}
	}
}