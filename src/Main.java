import java.io.IOException;

public class Main {
	
	public static void main(String args[]){
		
		Client client = new Client();
		Server server = new Server();
		
		server.start();
		try {
			client.runSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
