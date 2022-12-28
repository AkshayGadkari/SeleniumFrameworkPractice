package practice;

import java.util.Arrays;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {

        int a[]= {1,12,5,6,11};


        Arrays.sort(a);
        int length=a.length;
        System.out.println("2nd Highest = " + a[length - 2]);

        //1 way to print
        for (int num : a) {
            System.out.print(num + " ");
        }

        System.out.println();

        //2nd way to print
        System.out.println("Modified arr[] : "
                + Arrays.toString(a));

        Arrays.sort(a,1,2);

// Collections.reverseOrder() is not supported for int primitive type but with Integer
 //       Arrays.sort(a, Collections.reverseOrder());






    }
}
