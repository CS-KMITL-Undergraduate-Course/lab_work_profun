public class ProFun08_Q4_1_050800
{
    public static void  main(String[] args)
    {
        int arr2[] = new int[args.length];
        int i = args.length / 2;
        int j = args.length / 2 + 1;
        int k = 0;

        while (i >= 0 && j < arr2.length)
        {
            int square1 = Integer.parseInt(args[i]) * Integer.parseInt(args[i]);
            int square2 = Integer.parseInt(args[j]) * Integer.parseInt(args[j]);

            if (square1 < square2)
            {
                arr2[k++] = square1;
                --i;
            }
            else
            {
                arr2[k++] = square2;
                ++j;
            }
        }
        while (i >= 0)
        {
            arr2[k++] = Integer.parseInt(args[i]) * Integer.parseInt(args[i]);
            --i;
        }
        while (j < arr2.length)
        {
            arr2[k++] = Integer.parseInt(args[j]) * Integer.parseInt(args[j]);
            ++j;
        }
        for (int l = 0; l < arr2.length; ++l)
            System.out.print(arr2[l] + " ");
    }
}
