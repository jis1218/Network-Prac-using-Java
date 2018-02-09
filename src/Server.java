import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	int port = 9092;

	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		Socket client = null;
		try(ServerSocket serverSocket = new ServerSocket(port);) {
			while(true){
				client = serverSocket.accept();
				if(client!=null){
					bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
					String str = bufferedReader.readLine();
					System.out.println(str + "heyhey");
				}				
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(bufferedReader!=null){
					bufferedReader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				if(client!=null){
					client.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
