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
		System.out.println("�Է��Ͻÿ�");
		// Ű������ �Է��� �޾Ƽ� ���ڿ��� ������ �д�
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String str = input.readLine();
		
		// ���Ͽ��� �ƿ�ǲ��Ʈ���� ��� ������ �Է¹��� ���ڿ��� �����Ѵ�
		OutputStream os = socket.getOutputStream();
		os.write(str.getBytes());
		// buffer�� �� ���� ������ ������ ���ϹǷ� flush�� ����� �� ���� �ʾƵ� ������ �ȴ�.
		os.flush();
		
		socket.close();
	}

}
