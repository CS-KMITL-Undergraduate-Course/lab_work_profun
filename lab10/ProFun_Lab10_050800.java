public class ProFun_Lab10_050800
{
    public static boolean q1_isParlindrome(String str)
    {
        if (str.length() <= 1)
            return (true);
        if (str.charAt(0) != str.charAt(str.length() - 1))
            return (false);
        return (q1_isParlindrome(str.substring(1, str.length() - 1)));
    }

    public static int q2_countOccurences(int[] nums, int target)
    {
        if (nums.length == 0)
            return (0);

        int[] new_nums = new int[nums.length - 1];
        for (int i = 1; i < nums.length; ++i)
            new_nums[i - 1] = nums[i];

        if (nums[0] == target)
            return (1 + q2_countOccurences(new_nums, target));
        return (q2_countOccurences(new_nums, target));
    }

    public static String q3_changePi(String str)
    {
        if (str.length() <= 1)
            return (str);
        if (str.charAt(0) == 'p' && str.charAt(1) == 'i')
            return ("3.14" + q3_changePi(str.substring(2, str.length())));
        return (str.charAt(0) + q3_changePi(str.substring(1, str.length())));
    }

    public static void main(String[] args)
    {
       String   demo = "p";
       int[]    arr = {1, 3, 5, 7};

       System.out.println(q3_changePi(demo));
       System.out.println(q2_countOccurences(arr, 2));
    }
}
