package views;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela_Conexao extends JPanel {
	private JTextField txtIP;
	private JTextField txtPorta;
	private JTextField txtNome;
	private JButton btnConectar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public Tela_Conexao() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setBackground(Color.BLUE);
		
		JLabel lblNewLabel = new JLabel("TO CONNECT");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel_1.add(btnConectar);
		
		btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("IP:");
		lblNewLabel_1.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 3;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtIP = new JTextField();
		txtIP = new JTextField("127.0.0.1");
		GridBagConstraints gbc_txtIP = new GridBagConstraints();
		gbc_txtIP.insets = new Insets(0, 0, 5, 5);
		gbc_txtIP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIP.gridx = 6;
		gbc_txtIP.gridy = 3;
		panel_2.add(txtIP, gbc_txtIP);
		txtIP.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Porta:");
		lblNewLabel_2.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 4;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtPorta = new JTextField();
		GridBagConstraints gbc_txtPorta = new GridBagConstraints();
		gbc_txtPorta.insets = new Insets(0, 0, 5, 5);
		gbc_txtPorta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPorta.gridx = 6;
		gbc_txtPorta.gridy = 4;
		panel_2.add(txtPorta, gbc_txtPorta);
		txtPorta.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nick:");
		lblNewLabel_3.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 5;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 5, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 6;
		gbc_txtNome.gridy = 5;
		panel_2.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

	}
	public JButton getConectar() {
		return this.btnConectar;
	}
	public JButton getCancelar() {
		return this.btnCancelar;
	}
	public JTextField getIP() {
		return this.txtIP;
	}
	public JTextField getPorta() {
		return this.txtPorta;
	}
	public JTextField getNome() {
		return this.txtNome;
	}
}
