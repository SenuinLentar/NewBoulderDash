package view.viewInterface;

import java.awt.Graphics;
import java.util.List;

public interface ICreateMenu {
	public List<LevelObservator> getObservators();
	
	public void setObservators(List<LevelObservator> observators);
	
	public int getChoice();
	
	public void drawPseudo(Graphics g);

	public String getPseudo();

	public void setPseudo(String pseudo);
}
