package arz.bogglesolver.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoggleCaseUI extends JPanel implements KeyListener, FocusListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8229202394162736557L;

	private int line;
	private int col;

	private JLabel _label;

	private Font fontNormal = new Font("TimesRoman ", Font.BOLD, 30);;

	public BoggleCaseUI(int line, int col) {

		this.line = line;
		this.col = col;

		_label = new JLabel("");
		_label.setFont(fontNormal);
		setBackground(Color.WHITE);
		add(_label);

		addKeyListener(this);
		addFocusListener(this);
		addMouseListener(this);

		setFocusable(true);
		setSize(50, 50);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() < 91 && e.getKeyCode() > 64) {

			Character c = e.getKeyChar();
			if (MainFrameController.getInstance().setCharAt(line, col, c)) {
				_label.setText(c.toString().toUpperCase());
			}
		}

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		setBackground(Color.LIGHT_GRAY);

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		setBackground(Color.WHITE);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		requestFocus();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
