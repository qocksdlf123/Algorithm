import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N6603 {
    static boolean[] visited;
    static int k;
    static int[] lotto;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            lotto = new int[k+1];
            if(k==0) break;
            for (int i = 1; i <= k; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[k+1];
            dfs(lotto,0,visited,1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int[] lotto, int depth, boolean[] visited, int start){     //조합에서는 i가 직전 start(직전 i)보다 커야한다
        if(depth == 6) {
            for (int i = 1; i <= k; i++) {
                if(visited[i]==true) sb.append(lotto[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= k ; i++) {
            if(visited[i]==false) {
                visited[i] = true;
                dfs(lotto, depth + 1, visited,i+1);
                visited[i] = false;
            }
        }
    }
}