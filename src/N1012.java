import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1012 {
    static int T, R, C, K, r, c, result;
    static boolean[][] map;

    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            result = 0;
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st1.nextToken());
            C = Integer.parseInt(st1.nextToken());
            K = Integer.parseInt(st1.nextToken());

            map = new boolean[R][C];
            for (int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st2.nextToken());
                c = Integer.parseInt(st2.nextToken());
                map[r][c] = true;
            }

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if(map[r][c] == true){
                        map[r][c] = false;
                        bfs(r,c);
                        result += 1;
                    }
                }
            }
            System.out.println(result);

        }


    }

    public static void bfs(int r, int c) {


        for (int i = 0; i < 4; i++) {
            if(inofindex(r+dr[i],c+dc[i]) && map[r+dr[i]][c+dc[i]] == true){
                map[r+dr[i]][c+dc[i]] = false;
                bfs(r+dr[i],c+dc[i]);
            }
        }
    }

    public static boolean inofindex(int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C) return false;
        return true;
    }

}
