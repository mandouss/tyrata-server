import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
	try {
	    ServerSocket ss = new ServerSocket(8888);
	    System.out.println("start the server");
	    Socket s = ss.accept();
	    System.out.println(+s.getInetAddress().getLocalHost()+"link to the server");

	    BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    String mess = br.readLine();
	    System.out.println("client"+mess);
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	    bw.write(mess+"\n");
	    bw.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
