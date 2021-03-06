import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;


public class Main {

static InputStream is;
static PrintWriter out;
static String INPUT = "";

private static byte[] inbuf = new byte[1024];
static int lenbuf = 0, ptrbuf = 0;

private static int readByte() {
	if (lenbuf == -1)
		throw new InputMismatchException();
	if (ptrbuf >= lenbuf) {
		ptrbuf = 0;
		try {
			lenbuf = is.read(inbuf);
		} catch (IOException e) {
			throw new InputMismatchException();
		}
		if (lenbuf <= 0)
			return -1;
	}
	return inbuf[ptrbuf++];
}
private static int ni() {
	int num = 0, b;
	boolean minus = false;
	while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
		;
	if (b == '-') {
		minus = true;
		b = readByte();
	}

	while (true) {
		if (b >= '0' && b <= '9') {
			num = num * 10 + (b - '0');
		} else {
			return minus ? -num : num;
		}
		b = readByte();
	}
}
private static final long MOD = (long)1e9+7;
public static long[][] matrixMul(long[][] a,long[][] b)
{
	long[][] c = new long[a.length][a.length];
	for(int i=0;i<a.length;++i)
	{
		for(int j=0;j<a[i].length;++j)
		{
			for(int k=0;k<a.length;++k)
			{
				c[i][j] = (c[i][j] + ((a[i][k]*b[k][j])%MOD))%MOD;
			}
		}
	}
	
	return c;
}
public static long[][] matrixExpo(long[][] a,int n)
{
	if(n==1)
		return a;
	long[][] powerMatrix = matrixExpo(a,n>>1);
	powerMatrix = matrixMul(powerMatrix, powerMatrix);
	if((n&1)==1)
	{
		powerMatrix = matrixMul(powerMatrix,a);
	}
	return powerMatrix;
}
public static void main(String[] args) {
	is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(
			INPUT.getBytes());
	out = new PrintWriter(System.out);
	long[][] matrixForm = {{1,1},{1,0}};
	int tcs = ni();
	for(int t=0;t<tcs;++t)
	{
		int n = ni(), m = ni();
		long[][] resultMatrix = matrixExpo(matrixForm,m+1);
		long result = resultMatrix[0][0];
		if(n!=0)
		{
		resultMatrix = matrixExpo(matrixForm, n);
		result = result - resultMatrix[0][0];
		if(result<0)
			result+=MOD;
		}
		else
		{
			result--;
			if(result<0)
				result+=MOD;
		}
		out.println(result);
	}

	out.flush();
}
}
