import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class EchoClient {
	public static void main(String[] args) throws Exception {

		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		echoSocket = new Socket("localhost", 9001);
		out = new PrintWriter(echoSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(echoSocket
				.getInputStream()));

		BufferedReader stdIn = new BufferedReader(
					new InputStreamReader(System.in));

		while (in!=null) {
			System.out.print("client> ");
			out.println(stdIn.readLine());
			System.out.println("echo from server: '" + in.readLine()+"'");
		}

		out.close();
		in.close();
		echoSocket.close();
	}
}
