import java.util.Arrays;

public class ProFun09_050800
{
    static int right_diag_sum(int[][] input)
    {
        int sum = 0;
        int row_size = input.length;

        for (int row = 0; row < row_size; ++row)
            sum += input[row][row % row_size];
        return (sum);
    }

    static int [] max_sum_row(int [][] input)
    {
        int max_sum = 0;
        int row_size = input.length;
        int col_size = input[0].length;
        int sum = 0;
        int ret_row = 0;

        for (int row = 0; row < row_size; ++row)
        {
            sum = 0;
            for (int col = 0; col < col_size; ++col)
                sum += input[row][col];
            if (sum > max_sum)
            {
                max_sum = sum;
                ret_row = row;
            }
        }
        return (input[ret_row]);
    }

    static int[] retrieve_main_diagonal(int[][] input)
    {
        int row_size = input.length;
        int col_size = input[0].length;
        int diagonal_arr[] = new int[row_size * col_size];
        int i = 0;

        for (int col = 0; col < col_size; ++col)
        {
            for (int row = 0; row < row_size; ++row)
                diagonal_arr[i++] = input[row][(col + row) % col_size];
        }
        return (diagonal_arr);
    }

    static int[][] transpose(int[][] mat)
    {
        int size = mat[0].length;
        int tp_mat[][] = new int[size][size];

        for (int row = 0; row < size; ++row)
        {
            for (int col = 0; col < size; ++col)
                tp_mat[row][col] = mat[col][row];
        }
        return (tp_mat);
    }

    static void print_matrix(int[][] mat)
    {
        for (int row[] : mat)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }

    static int get_max(int[][] arr)
    {
        int max = 0;

        for (int i = 0; i < arr[0].length; ++i)
            if (arr[i][1] > max)
                max = arr[i][1];
        return (max);
    }

    static int[][] counting_sort(int[][] arr, int exp)
    {
        int size = arr.length;
        int[][] output = new int[size][2];
        int[] count = new int[10];

        // count occourence of each element
        for (int i = 0; i < size; ++i)
            ++count[(arr[i][1] / exp) % 10];

        // computer prefix
        for (int i = 1; i < 10; ++i)
            count[i] += count[i - 1];

        // build new sort array
        for (int i = size - 1; i >= 0; --i)
        {
            output[size - (count[(arr[i][1] / exp) % 10] - 1) - 1][0] = arr[i][0];
            output[size - (count[(arr[i][1] / exp) % 10] - 1) - 1][1] = arr[i][1];
        }
        return (output);
    }

    static int[][] by_points(int[][] raw_score)
    {
        int max = get_max(raw_score);
        int[][] sort_arr = raw_score;

        for (int exp = 1; max / exp > 0; exp *= 10)
            sort_arr = counting_sort(sort_arr, exp);
        return (sort_arr);
    }

    public static void main(String[] args)
    {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] raw_score = {{22, 88}, {11, 99}, {33, 77}};

        System.out.println(right_diag_sum(mat));
        System.out.println(Arrays.toString(max_sum_row(mat)) + "\n");
        System.out.println(Arrays.toString(retrieve_main_diagonal(mat)) + "\n");
        print_matrix(transpose(mat));
        print_matrix(by_points(raw_score));
    }
}
