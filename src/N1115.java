import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1115 {
    static int N, cycle;
    static int[] p;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        cycle = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        p = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            if(visited[i] ==false) {
                removeCycle(i);
            }
        }
        if(cycle==1) System.out.println(0);
        else {
            System.out.println(cycle);
        }
    }

    static void removeCycle(int n){
        if(visited[n] == true) {
            cycle++;
            return;
        }
//        System.out.println(n);
        visited[n] =true;
        removeCycle(p[n]);

    }

}
