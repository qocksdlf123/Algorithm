import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10974 {
    static int N;
    static int[] numbers, out;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N+1];
        out = new int[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = i;
        }
        permutation(numbers,out,0);
    }

    static void permutation(int[] numbers,int[] out, int depth){
        if(depth == N){
            for (int i = 1; i <= N ; i++) {
                System.out.print(out[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N ; i++) {
            if(visited[i] ==false){
                visited[i] = true;
                out[depth+1] = i;
                permutation(numbers,out,depth+1);
                visited[i] = false;
            }
        }
    }
}
