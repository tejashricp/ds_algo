package pattern;

import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args){
//        Scanner scn = new Scanner(System.in);
//        int n = Integer.parseInt(scn.next());
        int n=3;
        for(int i=1;i<=n;i++){
            for(int j=n+1-i;j>0;j--){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}
