package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ScorePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	protected Image[][] buffer = new Image[22][40];
	Font panelFont = new Font("Courier", Font.BOLD, 15);
	private String str = "";


	public ScorePanel(String str) {
		this.str = str;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setFont(panelFont);
		g.setColor(Color.black);
		g.drawString(str, 10, 30);
	}

	/**
	 * Update the map when a mouvement is done
	 */
	public void update() {
		this.repaint();
	}
}