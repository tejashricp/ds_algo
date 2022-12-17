package dp;

public class StringsEqualCost {

    public static int solution(String s1, String s2, int c1, int c2) {
        int m = s1.length();
        int n = s2.length();
        int [][] dp = new int[m+1][n+1];

        for (int i = m;i>=0;i--){

            for(int j = n;j>=0;j--){

                if(i==m && j==n){
                    dp[i][j]=0;
                } else if(i==m){
                    dp[i][j]=0;
                } else if(j==n){
                    dp[i][j]=0;
                } else{

                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = 1 +  dp[i+1][j+1];
                    }else{
                        int f1 = dp[i+1][j];
                        int f2 = dp[i][j+1];
                        dp[i][j] = Math.max(f1,f2);
                    }
                }
                System.out.print(dp[i][j]+ " ");
            }

            System.out.println();

        }

        int lcs = dp[0][0];
        int s1d = m - lcs;
        int s2d = n - lcs;

        int cost = ((c1 * s1d) + (c2 * s2d));


        return cost;
    }

    public static void main(String[] args) {
        System.out.println(solution("sea", "eat",10, 7));
    }
}
