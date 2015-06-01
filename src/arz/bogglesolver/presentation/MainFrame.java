package arz.bogglesolver.presentation;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;

import javax.swing.border.TitledBorder;

import java.awt.Insets;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import arz.bogglesolver.application.BoggleManager;
import arz.bogglesolver.domain.BoggleCase;

import java.awt.Color;

public class MainFrame extends JFrame {
	
	
	
	
	
	public MainFrame(){
		
		
		setTitle("Boggle Solver");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 100};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new TitledBorder(null, "Grille", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_gridPanel = new GridBagConstraints();
		gbc_gridPanel.insets = new Insets(0, 0, 5, 0);
		gbc_gridPanel.fill = GridBagConstraints.BOTH;
		gbc_gridPanel.gridx = 0;
		gbc_gridPanel.gridy = 0;
		getContentPane().add(gridPanel, gbc_gridPanel);
		GridBagLayout gbl_gridPanel = new GridBagLayout();
		gbl_gridPanel.columnWidths = new int[]{0, 0};
		gbl_gridPanel.rowHeights = new int[]{0, 0};
		gbl_gridPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_gridPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		gridPanel.setLayout(gbl_gridPanel);
		
		JPanel grid = new JPanel();
		grid.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_grid = new GridBagConstraints();
		gbc_grid.insets = new Insets(2, 2, 2, 2);
		gbc_grid.fill = GridBagConstraints.BOTH;
		gbc_grid.gridx = 0;
		gbc_grid.gridy = 0;
		gridPanel.add(grid, gbc_grid);
		GridBagLayout gbl_grid = new GridBagLayout();
		grid.setLayout(gbl_grid);
		
		for(int i=0;i<BoggleManager.getInstance().getNbLine();i++){
			
			for(int j=0;j<BoggleManager.getInstance().getNbCol();j++){
				
				
				BoggleCaseUI cUi = new BoggleCaseUI();
				
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.insets = new Insets(2, 2, 2, 2);
				gbc.fill = GridBagConstraints.BOTH;
				gbc.gridx = i;
				gbc.gridy = j;
				gbc.weightx = 1.0;
				gbc.weighty = 1.0;
				grid.add(cUi, gbc);
				
			}
			
			
		}
		
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(null, "Control", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_controlPanel = new GridBagConstraints();
		gbc_controlPanel.fill = GridBagConstraints.BOTH;
		gbc_controlPanel.gridx = 0;
		gbc_controlPanel.gridy = 1;
		getContentPane().add(controlPanel, gbc_controlPanel);
		GridBagLayout gbl_controlPanel = new GridBagLayout();
		gbl_controlPanel.columnWidths = new int[] {0, 0};
		gbl_controlPanel.rowHeights = new int[] {0};
		gbl_controlPanel.columnWeights = new double[]{0.0, 0.0};
		gbl_controlPanel.rowWeights = new double[]{0.0};
		controlPanel.setLayout(gbl_controlPanel);
		
		JButton clearBtn = new JButton("Effacer");
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.gridx = 0;
		gbc_clearBtn.gridy = 0;
		controlPanel.add(clearBtn, gbc_clearBtn);
		
		JButton solveBtn = new JButton("R\u00E9soudre !!!!");
		GridBagConstraints gbc_solveBtn = new GridBagConstraints();
		gbc_solveBtn.gridx = 1;
		gbc_solveBtn.gridy = 0;
		controlPanel.add(solveBtn, gbc_solveBtn);
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBorder(new TitledBorder(null, "R\u00E9sultats", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_resultPanel = new GridBagConstraints();
		gbc_resultPanel.gridheight = 2;
		gbc_resultPanel.fill = GridBagConstraints.BOTH;
		gbc_resultPanel.gridx = 1;
		gbc_resultPanel.gridy = 0;
		getContentPane().add(resultPanel, gbc_resultPanel);
		GridBagLayout gbl_resultPanel = new GridBagLayout();
		gbl_resultPanel.columnWidths = new int[]{0, 0};
		gbl_resultPanel.rowHeights = new int[]{0, 0};
		gbl_resultPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_resultPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		resultPanel.setLayout(gbl_resultPanel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		resultPanel.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		
		pack();
	}

}
