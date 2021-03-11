package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class Tela_Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtSend;
	private Socket socket;
	private OutputStream ou;
	private Writer ouw;
	private BufferedWriter bfw;
	private Tela_Conexao panel_2;
	private Tela_Conexao painelConexao;
	private JPanel panel_1;
	private JButton btnEnviar;
	private JTextArea txtChatAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Principal frame = new Tela_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela_Principal() {
		
		setOpacity(1.0f);
		setForeground(Color.BLACK);
		setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		setTitle("Memory Flash");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("MEMORY FLASH");
		lblNewLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(this);
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new MigLayout("", "[grow][63px]", "[55px][55px][55px][][55px]"));
		
		JLabel lblNewLabel_1 = new JLabel("Placar:");
		lblNewLabel_1.setFont(new Font("Source Code Pro Black", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1, "cell 0 0,grow");
		
		JLabel lblNewLabel_2 = new JLabel("0  |  0");
		lblNewLabel_2.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2, "cell 1 0,alignx center");
		
		txtChatAll = new JTextArea();
		txtChatAll.setEditable(false);
		panel_1.add(txtChatAll, "cell 0 1 2 2,grow");
		
		txtSend = new JTextField();
		panel_1.add(txtSend, "cell 0 3 2 1,growx");
		txtSend.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "falha ao enviar mensagem");
					
				}
			}
		});
		btnEnviar.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 12));
		panel_1.add(btnEnviar, "cell 0 4,grow");
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 12));
		panel_1.add(btnLimpar, "cell 1 4,grow");
		
		CardLayout Card = new CardLayout();
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(Card);
		
		painelConexao = new Tela_Conexao();
		Tela_Configuracao painelConfiguracao = new Tela_Configuracao();
		painelConfiguracao.getCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Card.show(panel_2, "1");
			}
		});
		painelConfiguracao.getJogar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		panel_2.add(painelConexao,"1");
		panel_2.add(painelConfiguracao,"2");	
		
		Card.show(panel_2, "1");
		
		 painelConexao.getCancelar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sair();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		 painelConexao.getConectar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conectar();
					Card.show(panel_2, "2");
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		});
		contentPane.add(panel_2, BorderLayout.CENTER);
	}
	
	public void conectar() throws IOException {
		
		socket = new Socket(painelConexao.getIP().getText(), Integer.parseInt(painelConexao.getPorta().getText()));
		ou = socket.getOutputStream();
		ouw = new OutputStreamWriter(ou);
		bfw = new BufferedWriter(ouw);
		bfw.write(painelConexao.getNome().getText() + "\r\n");
		bfw.flush();
	}
	
	public void sair() throws IOException {

		bfw.close();
		ouw.close();
		ou.close();
		socket.close();
	}
	public void enviarMessagem() {
		String mensagem = null;
		
		PrintStream ps;
		try {
			ps = new PrintStream(socket.getOutputStream());
			ps.println(mensagem);
			ps.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mensagem = txtChatAll.getText();
		

	}

}
