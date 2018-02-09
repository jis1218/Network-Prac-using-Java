import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
	int port = 9092;
	
	
	public void runSocket() throws IOException{
		Socket socket = new Socket("192.168.0.9", port);
		System.out.println("입력하시오");
		// 키보드의 입력을 받아서 문자열로 저장해 둔다
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = input.readLine();
		
		// 소켓에서 아웃풋스트림을 열어서 위에서 입력받은 문자열을 전송한다
		OutputStream os = socket.getOutputStream();
		os.write(str.getBytes());
		// buffer가 다 차지 않으면 전송을 안하므로 flush를 해줘야 다 차지 않아도 전송이 된다.
		os.flush();
		
		socket.close();
	}

}
