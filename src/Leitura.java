import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leitura extends Thread{
	private Socket socket;
	
	public Leitura(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		try{
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String msg = "";
			while(!msg.equals("xau")){
				msg = in.readUTF();
				System.out.println("Leitura do Servidor: "+msg);
			}
		}catch(IOException ex){
			Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
