package pattern;

import java.util.Scanner;

/*

*
* *
* * *
* * * *


* */

public class Pattern1 {
    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.next());
//        int  n =-3;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }

    }


}
