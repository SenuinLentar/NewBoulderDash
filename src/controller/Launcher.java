package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.LaunchDBQuery;
import view.Audio;
import view.CreateMenu;
import view.MapMaker;
import view.TranslateMap;
import view.Window;
import view.viewInterface.LevelObservator;

public class Launcher implements LevelObservator {
	private CreateMenu menu;
	private MapMaker maker = null;
	static File music = null;
	private static final int SET_SIZE = 16;

	/**
	 * Constructor of Launcher
	 * 
	 * @throws IOException
	 */
	public Launcher() throws IOException {
		menu = new CreateMenu();
		menu.getObservators().add(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.LevelObservator#onLevelSelected(int, String)
	 */
	@Override
	public void onLevelSelected(int level, String name) {
		(new Thread(new Runnable() {
			@Override
			public void run() {
				if (level == 42) {
					new Window(menu.getPseudo());
				} else {
					LaunchDBQuery launchDBQueries = new LaunchDBQuery(level, menu.getPseudo());
					try {
						launchDBQueries.launchQueries();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					TranslateMap translate;

					try {

						translate = new TranslateMap(launchDBQueries.getTab());
						maker = new MapMaker(translate);
						maker.spritesCreation(SET_SIZE);

						BDKeyListener bdkeyListener = new BDKeyListener();
						Window window = new Window(maker, bdkeyListener, launchDBQueries.getFinalDiamonds(), level);

						EndTheGame end = new EndTheGame(window.getPanel(), window, launchDBQueries);
						Audio backSound = new Audio();
						Controller controller = new Controller(
								maker.getCharacter(translate.getCharacterX(), translate.getCharacterY()),
								window.getPanel(), SET_SIZE, maker, launchDBQueries.getFinalDiamonds(), end, backSound);

						bdkeyListener.addObserver(controller);
						bdkeyListener.setController(controller);

						GameLoop gameLoop = new GameLoop(maker, window.getPanel(), end, backSound);
						gameLoop.loop();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		})).start();
	}
}