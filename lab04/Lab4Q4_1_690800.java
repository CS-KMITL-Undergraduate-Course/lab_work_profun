public class Lab4Q4_1_690800
{
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";

	static int pow(int base, int power) // time O(pow) space O(pow)
	{
		if (power == 0)
			return (1);
		if (power == 1)
			return (base);
		return (base * pow(base, power - 1));
	}

	static boolean isPrime(int n) // O(sqrt(N))
	{
		if (n <= 1)
			return (false);
		if (n == 2 || n == 3)
			return (true);
		if (n % 2 == 0 || n % 3 == 0)
			return (false);
		for (int i = 5; i * i <= n; i += 6)
		{
			if (n % i == 0 || n % (i + 2) == 0)
				return (false);
		}
		return (true);
	}

	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println(RED + "Error" + RESET + ": Require one argument");
			return ;
		}
		int target = Integer.parseInt(args[0]);
		int curr_num = 1;

		while (target > 0)
		{
			++curr_num;
			if (isPrime(curr_num)) // Check if curr_num is prime number
				--target;
		}
		int perfect_number = pow(2, curr_num - 1) * (pow(2, curr_num) - 1);
		System.out.println("Perfect number is " + perfect_number);
	}
}
