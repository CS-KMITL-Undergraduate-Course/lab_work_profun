public class ProFun08_Q3_1_050800800
{
    static boolean q3_common_element(int[] a, int[] b)
    {
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length)
        {
            if (a[i] == b[j])
                return (true);

            if (a[i] < b[j])
                ++i;
            else
                ++j;
        }
        return (false);
    }

    public static void main(String[] args)
    {
        int[] a = {2, 3, 5, 7};
        int[] b = {4, 6, 7, 8};

        System.out.println(q3_common_element(a, b));
    }
}
