public class Lab6Q2_305800
{
	public static void main(String[] args)
	{
		if (args.length != 3)
		{
			System.out.println("Require 3 arguments.");
			return ;
		}

		String	result = "";
		int		startIndex = Integer.parseInt(args[1]);
		int		endIndex = Integer.parseInt(args[2]);

		for (int i = startIndex; i < endIndex; i++)
			result += args[0].charAt(i);

		System.out.println(result);
	}
}
