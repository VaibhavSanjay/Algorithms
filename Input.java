import java.io.*;

public class Input {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		String s = br.readLine();
		pr.println(s);
		
		pr.close(); // VERY IMPORTANT
	}

}
