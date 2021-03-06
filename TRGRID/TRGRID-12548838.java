import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter output = new PrintWriter(new OutputStreamWriter(System.out));
		
		int testcases = Integer.parseInt(input.readLine());

		for (int t = 0; t < testcases; ++t) {
			StringTokenizer inputElement = new StringTokenizer(input.readLine());
			int n = Integer.parseInt(inputElement.nextToken()), m = Integer.parseInt(inputElement.nextToken());
			if(n>m)
			{
				if((m&1)==0)
				{
					output.println("U");
				}
				else
				{
					output.println("D");
				}
			}
			else
			{
				if((n&1)==0)
				{
					output.println("L");
				}
				else
				{
					output.println("R");
				}
			}
		}

		output.flush();
	}
}
