package view;

import view.element.Diamond;
import view.viewInterface.ISprite;
import view.viewInterface.IVictoryDiamonds;

/**
 * @author maxim
 *
 */
public class VictoryDiamonds implements IVictoryDiamonds {
	
	/* (non-Javadoc)
	 * @see view.IVictoryDiamonds#setDirtAndBackgroundToDiamond(view.ISprite[][], int)
	 */
	public ISprite[][] setDirtAndBackgroundToDiamond(ISprite[][] sprites, final int SET_SIZE) {		
		int ligne = 0, colonne = 0, x = 0, y = 0;
		for (ISprite[] sousSpit : sprites) {
			x = 0;
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if (spit.getType() != SpriteType.UNBREAKABLE && spit.getType() != SpriteType.CHARACTER) {
					sprites[ligne][colonne] = new Diamond(x, y);
				}
				x = x + SET_SIZE;
				colonne ++;
			}
			y = y + SET_SIZE;
			ligne++;
		}
		return sprites;
	}
}
