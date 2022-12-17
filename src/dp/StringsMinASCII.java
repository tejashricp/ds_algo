package dp;

public class StringsMinASCII {

    public static int getMinAscii(String str1,String str2){
        int m = str1.length();
        int n = str2.length();

        /*
                    -       s           e           a
            -       0      115       216         313

            e     101      216      115          212

            a     198      313      212          115

            t     314     429       328         231

            ans = 231

         */


        int [][] dp = new int [m+1][n+1];

        for(int i=0;i<= m;i++){

            for(int j=0;j<= n;j++){

                if(i==0 && j==0){
                    dp[i][j] = 0;
                } else if(i==0){
                    dp[i][j] = dp[i][j-1] + (int) str2.charAt(j-1);
                } else if(j==0){
                    dp[i][j] = dp[i-1][j] + (int) str1.charAt(i-1);
                } else {
                    if(str1.charAt(i-1) == str2.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        int factor1 = dp[i][j-1] + str2.charAt(j-1);
                        int factor2 = dp[i-1][j] + str1.charAt(i-1);
                        dp[i][j] = Math.min(factor1,factor2);
                    }
                }
            }
        }

        for(int i=0;i< dp.length;i++){
            for(int j=0;j< dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[m][n];
    }


    public static void main(String []args){
        System.out.println(getMinAscii("eat","sea"));

    }

}
