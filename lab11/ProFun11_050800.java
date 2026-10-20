import java.util.Arrays;

public class ProFun11_050800
{
    static void q2_toi0_68_02_024(int[] leap_distances, int[] track, int dist)
    {
        int winner = 0;
        int highest_reward = 0;

        for (int distances: leap_distances)
        {
            int reward = 0;

            for (int curr = 0; curr <= dist; curr += distances)
            {
               reward += track[curr];
            }

            if (reward > highest_reward)
            {
                highest_reward = reward;
                ++winner;
            }
        }

        switch (winner)
        {
            case 1:
                System.out.println("Rabbit " + highest_reward);
                break;
            case 2:
                System.out.println("Monkey " + highest_reward);
                break;
            case 3:
                System.out.println("Frog " + highest_reward);
                break;
            default:
                System.out.println("Error occur");
        }
    }

	static int[][] q3_markMap(int[][] bMap)
	{
		int		row_length = bMap.length;
		int		col_length = bMap[0].length;
		int[][]	markMap = new int[row_length][col_length];

		for (int i = 0; i < row_length; ++i)
		{
			int count = 0;

			for (int j = 0; j < col_length; ++j)
			{
				if (bMap[i][j] == 9)
				{
					markMap[i][j] = 9;
					continue;
				}
				if (i - 1 >= 0 && bMap[i - 1][j] == 9)
					++count;
				if (i + 1 < row_length && bMap[i + 1][j] == 9)
					++count;
				if (j - 1 >= 0 && bMap[i][j - 1] == 9)
					++count;
				if (j + 1 <= col_length && bMap[i][j + 1] == 9)
					++count;
				markMap[i][j] = count;
			}
		}
		return (markMap);
	}

	static int parkingFee_v2(int hrIn, int minIn, int hrOut, int minOut, boolean hasCoupon)
	{
		int totalMins = (hrOut - hrIn) * 60 + (minOut - minIn);

		if (hasCoupon)
		{
			if (totalMins <= 60)
			{
				return 0;
			}

			if (totalMins <= 180)
			{
				return 80;
			}

			int extraMins = totalMins - 180;
			int blocks = (int) Math.ceil(extraMins / 30.0);
			return 80 + (blocks * 30);

		}
		else
		{
			if (totalMins <= 15)
			{
				return 0;
			}

			if (totalMins <= 120)
			{
				if (totalMins <= 105)
				{
					int billableMins = totalMins - 15;
					int blocks = (int) Math.ceil(billableMins / 30.0);
					return blocks * 20;
				}
				return 80;
			}

			int extraMins = totalMins - 120;
			int blocks = (int) Math.ceil(extraMins / 30.0);
			return 80 + (blocks * 30);
		}
	}

    public static void main(String[] args)
    {
        int[]   leap = {1, 10, 8};
        int     dist = 100;
        int[][] rewards = {{10, 1}, {16, 50}, {80, 10}, {100, 20}};
        int[]   track = new int[dist + 1];

        for (int i = 0; i < rewards.length; i++)
        {
            track[rewards[i][0]] = rewards[i][1];
        }
        q2_toi0_68_02_024(leap, track, dist);
		System.out.println("Parking fee: " + parkingFee_v2(8, 15, 8, 25, false));
		System.out.println("Parking fee: " + parkingFee_v2(8, 15, 10, 25, true));
		System.out.println("Parking fee: " + parkingFee_v2(8, 15, 10, 25, false));
		System.out.println("Parking fee: " + parkingFee_v2(8, 15, 12, 10, true));
		System.out.println("Parking fee: " + parkingFee_v2(8, 15, 12, 10, false));
		System.out.println("Parking fee: " + parkingFee_v2(8, 15, 9, 5, true));
    }
}
