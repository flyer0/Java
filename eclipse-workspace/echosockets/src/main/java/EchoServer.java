import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(9001);

		Socket clientSocket = null;
		while (serverSocket != null) {
			clientSocket = serverSocket.accept();

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String inputLine, outputLine;

			while ((inputLine = in.readLine()) != null) {
				outputLine = inputLine;
				out.println(outputLine);
			}
			out.close();
			in.close();
			clientSocket.close();
		}

		serverSocket.close();
	}
}