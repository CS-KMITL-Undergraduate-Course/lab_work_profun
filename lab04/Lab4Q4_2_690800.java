public class Lab4Q4_2_690800
{
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";

	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println(RED + "Error: " + RESET + "Require at least one argument (Can be multiple).");
			return ;
		}

		for (int i = 0; i < args.length; i++)
		{
			int nums = Integer.parseInt(args[i]);
			int sum = 0;

			while (nums / 10 > 0)
			{
				sum += nums % 10;
				nums /= 10;
			}
			sum += nums % 10;
			boolean result = sum == 9;
			System.out.print(result + " ");
		}
		System.out.println();
	}
}
