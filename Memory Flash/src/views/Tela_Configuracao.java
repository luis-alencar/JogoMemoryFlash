package views;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
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

public class Tela_Configuracao extends JPanel {
	private JComboBox comboDificuldade;
	private JButton btnJogar;
	private JButton btnCancelar;

	/**
	 * Create the panel.
	 */
	public Tela_Configuracao() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JLabel lblNewLabel = new JLabel("STARTED");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnJogar = new JButton("Jogar");
		panel_1.add(btnJogar);
		
		btnCancelar = new JButton("Cancelar");
		panel_1.add(btnCancelar);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Nivel:");
		lblNewLabel_2.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 4;
		gbc_lblNewLabel_2.gridy = 3;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		comboDificuldade = new JComboBox();
		comboDificuldade.setModel(new DefaultComboBoxModel(new String[] {"F\u00E1cil", "M\u00E9dio", "Guiliano"}));
		GridBagConstraints gbc_comboDificuldade = new GridBagConstraints();
		gbc_comboDificuldade.insets = new Insets(0, 0, 5, 5);
		gbc_comboDificuldade.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDificuldade.gridx = 6;
		gbc_comboDificuldade.gridy = 3;
		panel_2.add(comboDificuldade, gbc_comboDificuldade);

	}
	
	public JComboBox getDificuldade() {
		return this.comboDificuldade;
	}
	public JButton getJogar() {
		return this.btnJogar;
	}
	public JButton getCancelar() {
		return this.btnCancelar;
	}
}
