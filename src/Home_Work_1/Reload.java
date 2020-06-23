package Home_Work_1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reload {
    static Scanner scan = new Scanner(System.in);
    public static String[] mass = {"Apple", "Orange", "Banana"};
    public int first, second;
    static List list;


    public static void main(String[] args) {
        String tmp1 = null, tmp2 = null;
        System.out.println(Arrays.toString(mass));
        int first = scan.nextInt();
        int second = scan.nextInt();
        tmp1 = mass[first];
        tmp2 = mass[second];
        mass[first] = tmp2;
        mass[second] = tmp1;
        System.out.println(Arrays.toString(mass));

        list = new ArrayList();
        list = Arrays.asList(mass);
        System.out.println(list);


    }

}
