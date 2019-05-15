package uk.ac.aston.dc2060.view.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import static uk.ac.aston.dc2060.TowerDefenceGame.GUI_SKIN;

public class WelcomeScreen extends CustomScreen {

    private Button playButton;
    private Button exitButton;

    public WelcomeScreen() {
        // Create play button
        playButton = new TextButton("Play", GUI_SKIN);
        playButton.setX((Gdx.graphics.getWidth() - playButton.getWidth()) / 2f);
        playButton.setY((Gdx.graphics.getHeight() - playButton.getHeight()) / 2f + playButton.getHeight());
        getStage().addActor(playButton);

        // Create exit button
        exitButton = new TextButton("Exit", GUI_SKIN);
        exitButton.setX((Gdx.graphics.getWidth() - exitButton.getWidth()) / 2f);
        exitButton.setY((Gdx.graphics.getHeight() - exitButton.getHeight()) / 2f - exitButton.getHeight());
        getStage().addActor(exitButton);
    }

    public void onPlayButtonPressed(Runnable task) {
        playButton.addListener(createListener(task));
    }

    public void onExitButtonPressed(Runnable task) {
        exitButton.addListener(createListener(task));
    }
}
