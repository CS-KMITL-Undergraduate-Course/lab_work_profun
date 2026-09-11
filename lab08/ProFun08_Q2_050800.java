class ProFun08_Q2_050800
{
    public static void  main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("Require at least 1 argument.");
            return ;
        }

        int max_ending = 0;
        int res = 0;
        for (int i = 0; i < args.length; ++i)
        {
            max_ending += Integer.parseInt(args[i]);

            if (max_ending > res)
                res = max_ending;
            if (max_ending < 0)
                max_ending = 0;
        }
        System.out.println("Max sub array sum : " + res);
    }
}