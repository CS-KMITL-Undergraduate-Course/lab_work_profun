import java.util.Arrays;

public class ProFun08_Q6_1_050800
{
    static void shift_arr(int[] data, int start, int end)
    {
        for (int i = start; i < end; i++)
            data[i + 1] = data[i];
    }

    static void q6_bookShelving(int x, int[] data)
    {
        int len = data.length;

        if (data[0] == 0)
        {
            data[0] = x;
            System.out.println(Arrays.toString(data));
            return ;
        }
        for (int i = 0; i < len - 1; i++)
        {
           if (data[i] < x)
           {
               int j = i;

               while (data[j] != 0)
                ++j;
               shift_arr(data, i, j);
               data[i] = x;
           }
        }
        System.out.println(Arrays.toString(data));
    }

    public static void  main(String[] args)
    {
        int data[] = new int[10];

        q6_bookShelving(5, data);
        q6_bookShelving(3, data);
        q6_bookShelving(1, data);
        q6_bookShelving(8, data);
    }
}
