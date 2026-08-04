public class Lab4Q2_690800
{
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";

	int price1 = 0;
	int price2 = 0;

	static void swap(Lab4Q2_690800 obj)
	{
		obj.price1 ^= obj.price2;
		obj.price2 ^= obj.price1;
		obj.price1 ^= obj.price2;
	}

	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			System.out.println(RED + "Error: " + RESET + "Require at least two argument.");
			return ;
		}

		Lab4Q2_690800 obj = new Lab4Q2_690800();
		int buf = 0;

		for (int i = 0; i < args.length; i++)
		{
			buf = Integer.parseInt(args[i]);
	
			if (buf > obj.price2)
				obj.price2 = buf;
			if (obj.price2 > obj.price1)
				swap(obj);
		}
		System.out.println("Sum of two max value = " + (obj.price1 + obj.price2));
	}
}
