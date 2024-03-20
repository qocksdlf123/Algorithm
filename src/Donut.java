import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Donut {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double d = Double.parseDouble(br.readLine());
        answer = (int)d;
        System.out.println(answer);
    }
}
