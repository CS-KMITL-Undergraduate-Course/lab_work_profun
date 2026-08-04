public class Lab4Q3_690800
{
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";

	static final int DAY_HOURS = 24;

	static int abs(int num)
	{
		int mask = num >> 31;
		return (num + mask) ^ mask;
	}

	static int fee_calculate(int parking_hours)
	{
		int fee = (parking_hours / DAY_HOURS) * 24;

		parking_hours %= DAY_HOURS;
		if (parking_hours < 4) // first rate fee
			return (fee + 4 + (3 * ((parking_hours - 2) + abs(parking_hours - 2)) / 2));
		if (parking_hours < 18) // second rate fee
			return (fee + 10 + (parking_hours - 4));
		return (fee + 24);
	}

	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println(RED + "Error: " + RESET + "Require at least one argument (Can be multiple).");
			return ;
		}
		for (int i = 0; i < args.length; ++i)
		{
			int parking_hours = Integer.parseInt(args[i]);

			System.out.printf("parking for %d hrs, pay %d bath.\n",
								parking_hours, fee_calculate(parking_hours));
		}
	}
}
