package com.mygamepackage;

import com.Camera.gamecamera;
import com.Controls.Controls;
import com.Envioronment.InputHandler;
import com.TextureRegionSlicer.TextureLoader;
import com.Units.UnitControlHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.map.mapLoader;


public class MyGdxGameClass extends ApplicationAdapter{
	private SpriteBatch batch;
	private TextureLoader assetLoader;
	private com.Camera.gamecamera cam;
	private com.Units.Unit unit;
	private com.map.mapLoader ml;
	private Controls ctrls;
	private InputHandler ih;
	private UnitControlHandler unitController;
	@Override
	public void create () {
		ih=new InputHandler();
		batch = new SpriteBatch();
		assetLoader = new TextureLoader();
		ctrls = new Controls();
  		cam = new com.Camera.gamecamera();
		unitController=new com.Units.UnitControlHandler();
		Gdx.input.setInputProcessor(ctrls);
		ml = new mapLoader();
		ml.loadMap("Test.tmx");




        unit = new com.Units.Unit();
		unit.spawn(assetLoader.getTextureRegion("door"), 100f, 100f, 16f, 16f);
		unitController.addPlayerToController(unit);

		//unit.addToPath(new Vector2(300, 300));
		//unit.addToPath(new Vector2(300, 0));
		//unit.addToPath(new Vector2(0, 300));
	}

	@Override
	public void render () {
		ih.getClickedRealWorldPosition(cam,ctrls,unitController);
		ih.cameraController(cam,ctrls, ml.getMapHeight(), ml.getMapWidth());

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.getCam().update();
		ml.getTiledMapRenderer().setView(cam.getCam());
		ml.getTiledMapRenderer().render();

		batch.begin();
		updateGame(Gdx.graphics.getDeltaTime(), batch, cam);
		batch.end();
	}

	public void updateGame (float deltaTime, SpriteBatch batch, gamecamera cam) {
		this.unitController.processUnits(deltaTime,batch, cam);
		//unit.draw(deltaTime, batch, this.cam.getCam());
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
