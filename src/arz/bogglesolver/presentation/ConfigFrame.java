package arz.bogglesolver.presentation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ConfigFrame extends JDialog {

	private JTextField nbLineTxt;

	private JTextField nbColTxt;

	private int _nbline;

	private int _nbcol;

	public ConfigFrame() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		
		setTitle("Configuration");

		_nbcol = 6;
		_nbline = 6;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel nbLineLbl = new JLabel("Nombre de ligne :");
		GridBagConstraints gbc_nbLineLbl = new GridBagConstraints();
		gbc_nbLineLbl.fill = GridBagConstraints.VERTICAL;
		gbc_nbLineLbl.anchor = GridBagConstraints.WEST;
		gbc_nbLineLbl.insets = new Insets(5, 5, 5, 5);
		gbc_nbLineLbl.gridx = 0;
		gbc_nbLineLbl.gridy = 0;
		getContentPane().add(nbLineLbl, gbc_nbLineLbl);

		nbLineTxt = new JTextField();
		nbLineTxt.setText(String.valueOf(_nbline));
		GridBagConstraints gbc_nbLineTxt = new GridBagConstraints();
		gbc_nbLineTxt.insets = new Insets(5, 0, 5, 5);
		gbc_nbLineTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nbLineTxt.gridx = 1;
		gbc_nbLineTxt.gridy = 0;
		getContentPane().add(nbLineTxt, gbc_nbLineTxt);
		nbLineTxt.setColumns(10);

		JLabel nbColLbl = new JLabel("Nombre de colonne :");
		GridBagConstraints gbc_nbColLbl = new GridBagConstraints();
		gbc_nbColLbl.fill = GridBagConstraints.VERTICAL;
		gbc_nbColLbl.anchor = GridBagConstraints.WEST;
		gbc_nbColLbl.insets = new Insets(0, 5, 5, 5);
		gbc_nbColLbl.gridx = 0;
		gbc_nbColLbl.gridy = 1;
		getContentPane().add(nbColLbl, gbc_nbColLbl);

		nbColTxt = new JTextField();
		nbColTxt.setText(String.valueOf(_nbcol));
		GridBagConstraints gbc_nbColTxt = new GridBagConstraints();
		gbc_nbColTxt.insets = new Insets(0, 0, 5, 5);
		gbc_nbColTxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_nbColTxt.gridx = 1;
		gbc_nbColTxt.gridy = 1;
		getContentPane().add(nbColTxt, gbc_nbColTxt);
		nbColTxt.setColumns(10);

		JButton okBut = new JButton("Ok");
		GridBagConstraints gbc_okBut = new GridBagConstraints();
		gbc_okBut.gridwidth = 2;
		gbc_okBut.fill = GridBagConstraints.VERTICAL;
		gbc_okBut.insets = new Insets(5, 5, 5, 5);
		gbc_okBut.gridx = 0;
		gbc_okBut.gridy = 2;
		getContentPane().add(okBut, gbc_okBut);

		okBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					_nbline = Integer.parseInt(nbLineTxt.getText().trim());
					_nbcol = Integer.parseInt(nbColTxt.getText().trim());
				} catch (NumberFormatException ex) {
					
					JOptionPane.showMessageDialog(ConfigFrame.this, "Erreur dans la sasie des paramètres./nLes valeurs par défaut seront utilisées", "Erreur", JOptionPane.ERROR_MESSAGE);
					
				}
				
				ConfigFrame.this.dispose();

			}
		});

		pack();

	}
	
	
	public int getNbCol(){
		return _nbcol;
	}
	
	
	public int getNbLine(){
		return _nbline;
	}

}
