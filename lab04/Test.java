public class Test {
	static int calculate_parking_fees(int parking_hours) {
		int parking_fees = 0;
		final int day_hours = 24;
		final int fee_day_limit = 24;
		final int fee_first_two_hours = 4;
		final int fee_after_two_hours = 3;
		final int fee_after_four_hours = 1;

		if (parking_hours > 24) {
			parking_fees += (parking_hours / day_hours) * fee_day_limit;
			parking_fees %= day_hours;
		}
		if (parking_fees >= 0)
			parking_fees += fee_first_two_hours;
		if (parking_fees >= 2)
			parking_fees += (parking_fees - 2) * fee_after_two_hours;
		if (parking_fees >= 4 && parking_fees - 4 < 18)
			parking_fees += (parking_fees - 4) * fee_after_four_hours;
		return (parking_fees);
	}

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			int parking_hours = Integer.parseInt(args[i]);
			int parking_fees = calculate_parking_fees(parking_hours);
			System.out.printf(
				"parking for %d hrs, pay %d bath.\n",
				parking_hours, parking_fees);
		}
	}
}
