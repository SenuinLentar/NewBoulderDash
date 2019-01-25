package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import view.viewInterface.ICreateMenu;
import view.viewInterface.LevelObservator;


public class CreateMenu extends JFrame implements ICreateMenu, ActionListener {

	private static final long serialVersionUID = 1L;
	private Font menuFont = new Font("Courier", Font.BOLD, 15);
	private int choice = 0;
	private String pseudo = "";
	private MenuPanel menuPanel;

	private Image image;
	private List<LevelObservator> observators = new ArrayList<>();
	
	private JTextField textField;

	/**
	 * Method which create the Menu
	 * @throws IOException 
	 */
	public CreateMenu() throws IOException {
		
		setSize(new Dimension(700, 400));
		setResizable(false);
		setLayout(new BorderLayout());
		setFocusable(true);

		
		image = ImageIO.read(new File("image/menu.png"));

		menuPanel = new MenuPanel(this);
		
		textField = new JTextField("Your pseudo here!", 20);
		textField.addActionListener(this);
		
		JButton bouton2 = new JButton("Choose Level");
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String[] level = {"Score", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
				JOptionPane jop = new JOptionPane();
				String name = (String) jop.showInputDialog(null, "Choose your level!", "The choice",
						JOptionPane.QUESTION_MESSAGE, null, level, level[1]);
				switch (name) {
				case "Level 1":
					choice = 1;
					break;
				case "Level 2":
					choice = 2;
					break;
				case "Level 3":
					choice = 3;
					break;
				case "Level 4":
					choice = 4;
					break;
				case "Level 5":
					choice = 5;
					break;
				case "Score":
					choice = 42;
					break;
				default:
					System.out.print("Level choice error");
					break;
				}
				for (LevelObservator observator : observators) {
					observator.onLevelSelected(choice, pseudo);
				}
			}
		});
		menuPanel.add(bouton2);
		menuPanel.add(textField);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(menuPanel, BorderLayout.SOUTH);
		this.setContentPane(menuPanel);
		this.setVisible(true);
	}

	/**
	 * Getter of choice
	 * @return choice
	 */
	public int getChoice() {
		return choice;
	}
	
	public void drawPseudo(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 500);
		g.drawImage(image, 175, 50, null);
		g.setFont(menuFont);
		g.setColor(Color.black);
		g.drawString("Please enter a pseudonyme before playing ;)", 10, 320);
		g.drawString(this.pseudo, 10, 360);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	/**
	 * Getter of observators
	 * @return observators
	 */
	public List<LevelObservator> getObservators() {
		return observators;
	}

	/**
	 * Setter of observators
	 * @param observators
	 */
	public void setObservators(List<LevelObservator> observators) {
		this.observators = observators;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		pseudo = textField.getText();

		this.menuPanel.update();
	}
}