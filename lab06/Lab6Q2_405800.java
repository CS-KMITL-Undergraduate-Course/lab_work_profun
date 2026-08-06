public class Lab6Q2_405800
{
		public static void main(String[] args)
		{
				if (args.length != 5)
				{
						System.out.println("Require 5 arguments.");
						return ;
				}

				int[]		hashTable = new int[10];
				boolean	hasPrint = false;

				for (int i = 0; i < 5; ++i)
				{
						int buf = Integer.parseInt(args[i]);

						if (hashTable[buf] == 1)
						{
								System.out.printf("%d ", buf);
								hasPrint = true;
						}
						else
								hashTable[buf]++;
				}
				if (hasPrint)
						System.out.println();
				else
						System.out.println(-1);
		}
}
