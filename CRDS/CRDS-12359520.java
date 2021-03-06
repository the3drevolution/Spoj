import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class Main {
	private static final int MOD = (int)1e6+7;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int[] cards = new int[(int)1e6+1];
		for(int i=1;i<(int)1e6+1;++i)
		{
			cards[i] = (cards[i-1] + i-1 + 2*i)%MOD;
		}
		int testcases = Integer.parseInt(br.readLine());
		for(int t=0;t<testcases;++t)
		{
			pw.println(cards[Integer.parseInt(br.readLine())]);
		}

		pw.flush();
		pw.close();
	}

}
