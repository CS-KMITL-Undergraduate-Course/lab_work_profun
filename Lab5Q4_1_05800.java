public class Lab5Q4_1_05800 {
	public static void main(String[] args)
	{
		if (args.length != 1)
			System.out.println("Require at least 1 argument.");

		int w = 0;
		int v = 0;

		for (int i = 0; i < args[0].length(); i++)
		{
			char buf = (char) (args[0].charAt(i) | ' ');

			if (buf == 'w')
				w++;
			else
				v++;
		}
		System.out.println("W count: " + w);
		System.out.println("V count: " + v);
	}
}
