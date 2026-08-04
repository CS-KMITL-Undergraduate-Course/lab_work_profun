public class Lab5Q5_1_05800 
{
	static void printx(int length, int space_index)
	{
		for (int i = 0; i < length; i++)
		{
			if (i == space_index || i == (length - space_index - 1))
			{
				System.out.print(' ');
				continue;
			}
			System.out.print('x');
		}
		System.out.println();
	}
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Require at only 1 argument.");
			return;
		}

		int n = Integer.parseInt(args[0]);

		for (int i = 0; i <= n; i++)
		{
			if (i < n / 2)
				printx(n, i);
			if (i > n / 2)
				printx(n, i - 1);

		}
	}
}
