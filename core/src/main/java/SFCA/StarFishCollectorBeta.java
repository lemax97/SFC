package SFCA;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class StarFishCollectorBeta extends GameBeta {

    private Turtle turtle;
    private ActorBeta starfish;
    private ActorBeta shark;
    private ActorBeta ocean;
    private ActorBeta looseMessage;
    private ActorBeta winMessage;

    private boolean win;

    @Override
    public void initialize() {

        ocean = new ActorBeta();
        ocean.setTexture(new Texture(Gdx.files.internal("assets/water.jpg")));
        mainStage.addActor(ocean);

        starfish = new ActorBeta();
        starfish.setTexture(new Texture(Gdx.files.internal("assets/starfish.png")));
        starfish.setPosition(380,380);
        mainStage.addActor(starfish);

        shark = new ActorBeta();
        shark.setTexture(new Texture(Gdx.files.internal("assets/sharky.png")));
        shark.setPosition( 280, 280);
        mainStage.addActor(shark);

        turtle = new Turtle();
        turtle.setTexture(new Texture(Gdx.files.internal("assets/turtle-1.png")));
        turtle.setPosition(20,20);
        mainStage.addActor(turtle);

        winMessage = new ActorBeta();
        winMessage.setTexture(new Texture(Gdx.files.internal("assets/you-win.png")));
        winMessage.setPosition(180,180);
        winMessage.setVisible(false);
        mainStage.addActor(winMessage);

        looseMessage = new ActorBeta();
        looseMessage.setTexture(new Texture(Gdx.files.internal("assets/game-over.png")));
        looseMessage.setPosition(135, 180);
        looseMessage.setVisible(false);
        mainStage.addActor(looseMessage);

        win = false;

    }

    @Override
    public void update(float dt) {

        if (turtle.overlaps(shark) && !win){
            turtle.remove();
            looseMessage.setVisible(true);
        }

        if (turtle.overlaps(starfish)){
            shark.remove();
            starfish.remove();
            winMessage.setVisible(true);
            if(!win)
                win = true;
        }

    }
}
