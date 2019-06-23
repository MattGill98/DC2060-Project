package uk.me.mattgill.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.I18NBundle;
import com.github.czyzby.kiwi.util.gdx.GdxUtilities;
import com.github.czyzby.lml.parser.LmlParser;
import com.github.czyzby.lml.util.Lml;
import com.github.czyzby.lml.util.LmlApplicationListener;
import uk.me.mattgill.gdx.view.GameLmlView;
import uk.me.mattgill.gdx.view.MenuLmlView;
import uk.me.mattgill.gdx.view.ViewActions;
import uk.me.mattgill.gdx.view.attributes.SrcAttribute;
import uk.me.mattgill.gdx.view.tags.AnimationTagProvider;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GdxApplication extends LmlApplicationListener {

    private final ViewActions viewActions;

    private GameLmlView gameView;

    public GdxApplication() {
        this.viewActions = new ViewActions(this);
    }

    @Override
    public void create() {
        // Call super
        super.create();

        // Initialise views
        this.gameView = new GameLmlView();
        initiateView(this.gameView);
        addClassAlias("menu", MenuLmlView.class);
        addClassAlias("game", GameLmlView.class);
        setView(MenuLmlView.class);
    }

    @Override
    public void render() {
        GdxUtilities.clearScreen(1, 1, 1);
        if (getCurrentView() != null) {
            getCurrentView().render(Gdx.graphics.getDeltaTime());
        }
    }

    @Override
    protected LmlParser createParser() {
        // Initialise GUI theme
        Skin skin = new Skin(new TextureAtlas(Gdx.files.internal("theme/Holo-dark-xhdpi.atlas")));
        skin.load(Gdx.files.internal("theme/Holo-dark-xhdpi.json"));

        return Lml
                .parser()
                .skin(skin)
                .i18nBundle(I18NBundle.createBundle(Gdx.files.internal("i18n/bundle")))
                .tag(new AnimationTagProvider(), "animation")
                .attribute(new SrcAttribute(), "src")
                .actions("viewActions", viewActions)
                .action("quitGame", actor -> {
                    setView(MenuLmlView.class, new Action() {
                        @Override
                        public boolean act(float delta) {
                            gameView.clear();
                            return true;
                        }
                    });
                    return null;
                })
                .build();
    }
}