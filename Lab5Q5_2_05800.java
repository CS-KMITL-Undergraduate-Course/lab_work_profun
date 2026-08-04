public class Lab5Q5_2_05800 
{
	public static void main(String[] args)
	{
		if (args.length != 1)
			System.out.println("Require at only 1 argument.");

		int n = Integer.parseInt(args[0]);

		for (int i = 1; i <= n; i++)
		{
			for (int j = 0; j < i; j++)
				System.out.printf("%d ", n - j);
			System.out.println();
		}
	}
}
