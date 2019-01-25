package view;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import controller.controllerInterface.IBDKeyListener;
import view.viewInterface.IPanel;
import view.viewInterface.IWindow;

public class Window extends JFrame implements IWindow {
	private static final long serialVersionUID = 8164118974463460991L;
	private Panel panel;
	private ScorePanel scorePanel;
	int finalDiamonds;


	/**
	 * The constructor of Window
	 * @param maker
	 * @param listener
	 * @param finalDiamonds
	 * @param title
	 */
	public Window(MapMaker maker, IBDKeyListener listener, int finalDiamonds, int title) {

		/*
		 * Create a new window
		 */
		this.finalDiamonds = finalDiamonds;
		this.setTitle("BoulderDash level " + title);
		this.setSize(660, 420);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.addKeyListener((KeyListener) listener);
		/*
		 * Create a new Panel
		 */
		panel = new Panel(maker, finalDiamonds);

		/*
		 * Fill the panel
		 */
		this.setContentPane(panel);
		this.setVisible(true);
		
		
	}
	
	public Window(String playerName){

		/*
		 * Create a new window
		 */
		this.setTitle("Score");
		this.setSize(660, 420);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		/*
		 * Create a new Panel
		 */
		scorePanel = new ScorePanel(playerName);

		/*
		 * Fill the panel
		 */
		this.setContentPane(scorePanel);
		this.setVisible(true);
	}
	
	public IPanel getPanel() {
		return panel;
	}
}