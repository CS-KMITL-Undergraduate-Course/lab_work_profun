public class Test2
{
	public static void main(String[] args)
	{
		int price[] = { 0, 3, 4, 5, 20, 22, 123 };
		int fee = 0;

		for (int i = 0; i < price.length; ++i)
		{
			int hour = price[i] % 24;
			fee = hour <= 2 ? hour * 2 : hour <= 4 ? 4 + (hour - 2) * 3 : 4 + 6+ (hour - 4) * 1;
			fee = fee > 24 ? 24 : fee;
			System.out.println((price[i] / 24) * 24 + fee);
		}
	}
}
