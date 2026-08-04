public class Lab5Q5_4_05800
{
	static void printPyramin(int emptySpace, int start_index, int end_index)
	{
		while (start_index <= end_index)
		{
			for (int i = 0; i < emptySpace; i++)
				System.out.print(' ');
			for (int j = start_index; j < end_index; j++)
				System.out.print(' ');
			for (int j = 1; j <= (2 * start_index - 1); j++)
				System.out.print('*');
			System.out.println();
			start_index++;
		}
	}

	static void printSqaure(int n, int emptySpace)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < emptySpace; j++)
				System.out.print(' ');
			for (int j = 0; j < n; j++)
				System.out.print('*');
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Require at only 1 argument.");
			return ;
		}

		int n = Integer.parseInt(args[0]);
		int end_index = 4;

		for (int i = 1; i <= n; i++)
			printPyramin(n - i, i, end_index++);
		printSqaure(n, ((2 * n + 5) - n) / 2);
	}
}
