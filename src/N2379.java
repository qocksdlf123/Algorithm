import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2379 {

    static int N;
    static int[] score;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        score = new int[N+1];
        dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        if(N==1){
            System.out.println(score[1]);
        } else if (N==2) {
            System.out.println(score[1] + score[2]);
        }else{
            dp[1] = score[1];
            dp[2] = score[1] + score[2];
            dp[3] = Integer.max(score[1] + score[3],score[2] + score[3] );
            for (int i = 4; i <= N ; i++) {
                dp[i] = Integer.max(dp[i-2] , score[i-1] + dp[i-3] ) + score[i];
            }
            System.out.println(dp[N]);
        }




    }
}
