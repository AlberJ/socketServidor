import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Servidor {

	public static void main(String[] args) {
		String msg = "";
		try {
			ServerSocket servidor = new ServerSocket(6500);
            System.out.println("Aguardando um pedido de conexão...");
            Socket socket = servidor.accept();
            System.out.println("Conexão estabelecida");
            Leitura leitura = new Leitura(socket);
            leitura.start();
            
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while(!msg.equals("xau")){
            	System.out.println(msg);
            	out.writeUTF(JOptionPane.showInputDialog("Digite a msg para o cliente: "));
            }
            socket.close();
            servidor.close();
            
		}catch(IOException e){
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, e);
		}

	}

}
