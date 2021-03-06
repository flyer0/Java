import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	public static void main(String[] args) throws Exception {
	    int port = 9001;
		ServerSocket serverSocket = null;
		serverSocket = new ServerSocket(port);

		Socket clientSocket = null;
		while (serverSocket != null) {
		    System.out.println("Server ready on " + port);
			clientSocket = serverSocket.accept();

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputLine, outputLine;
			
		
			//while ((inputLine = in.readLine()) != null) {
			inputLine = in.readLine();
				outputLine = inputLine;
				out.println(outputLine);
			//}
			out.close();
			in.close();
			clientSocket.close();
		}

		serverSocket.close();
	}
}
