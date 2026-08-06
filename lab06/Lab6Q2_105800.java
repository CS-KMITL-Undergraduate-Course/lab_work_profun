/**
 * Lab6Q2_105800
 */
public class Lab6Q2_105800
{
	public static void main(String[] args)
	{
		if (args.length < 1)
		{
			System.out.println("Need at least 1 argument.");
			return ;
		}

		for (int i = 0; i < args.length - 1; i++)
		{
			int arg1 = Integer.parseInt(args[i]);
			int arg2 = Integer.parseInt(args[i + 1]);

			if (arg1 > arg2)
			{
				System.out.println(false);
				return ;
			}
		}
		System.out.println(true);
	}
}