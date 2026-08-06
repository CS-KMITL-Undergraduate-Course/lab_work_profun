public class Lab6Q2_205800
{
	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Need at least 1 argument.");
			return ;
		}

		int count = 0;
		for (int i = 0; i < args.length - 1; i++)
		{
			String arg1 = args[i];
			String arg2 = args[i + 1];

			if (arg1.compareTo(arg2) != 0)
				count++;
		}
		System.out.println(++count);
	}
}
