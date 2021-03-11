package conexoes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConexaoServidor extends Thread{
	
	private static ArrayList<ConexaoServidor> clientes;
	private static ServerSocket server;
	private Socket cliente;
	//faz leitura em byte
	private InputStream in;
	//faz conversão de binários para caracteres
	private InputStreamReader inr;
	//lê bloco inteiro de dados
	private BufferedReader bfr;
	
	
	
	//Construtor Socket
	
	public ConexaoServidor(Socket cliente) {
		
		this.cliente = cliente;
		
		try{
			in = cliente.getInputStream();
			inr = new InputStreamReader(in);
			bfr = new BufferedReader(inr);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public  static void main(String[]args) {
		
		try {
			
			JLabel lblMessage = new JLabel("Porta do Servidor:");
			JTextField txtPorta = new JTextField("12345");
			Object[] texts = { lblMessage, txtPorta };
			JOptionPane.showMessageDialog(null, texts);
			server = new ServerSocket(Integer.parseInt(txtPorta.getText()));
			clientes = new ArrayList<ConexaoServidor>();
			JOptionPane.showMessageDialog(null, "Servidor ativo na porta: " + txtPorta.getText());

			while(true) {
				System.out.println("Aguardando conexão ...");
				Socket cliente = server.accept();
				System.out.println("Cliente conectado ...");
				Thread t = new ConexaoServidor(cliente);
				t.start();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
}
