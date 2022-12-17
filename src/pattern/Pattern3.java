package pattern;

/*
                *
            *   *
        *   *   *
    *   *   *   *
*   *   *   *   *


* */
public class Pattern3 {
    public static void main(String[] args){
//        Scanner scn = new Scanner(System.in);
//        int n = Integer.parseInt(scn.next());
        int n=3;
        for(int i=1;i<=n;i++){
            for(int k=1;k<=n;k++){
                if(k>n-i){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }

            }
            System.out.println();
        }

        System.out.println();

        for(int i=1;i<=n;i++){
            for(int k=1;k<=n;k++){
                if(k<=i){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }

            }
            System.out.println();
        }

        System.out.println();

        for(int i=1;i<=n;i++){
            for(int k=1;k<=n;k++){
                if(i<=k){
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }

            }
            System.out.println();
        }
    }
}
