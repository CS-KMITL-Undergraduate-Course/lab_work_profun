class Lab03_Q2_4_690800
{
	public static void main(String[] args)
	{
		int result = 0;

		for (int num = 0; num < 1000; ++num)
		{
			if (num % 3 == 0)
				result += num;
			else if (num % 5 == 0)
				result += num;
		}
		System.out.println(result);
	}
}