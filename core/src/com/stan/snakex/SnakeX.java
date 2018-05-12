package com.stan.snakex;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class SnakeX extends ApplicationAdapter {
	OrthographicCamera cam;
	float dt = 0;

	SpriteBatch batch;
	Texture img;

	ShapeRenderer snake_renderer;
	Snake player_1 = new Snake(0);
	
	@Override
	public void create () {
		cam = new OrthographicCamera(1280,720);

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");

		snake_renderer = new ShapeRenderer();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);

		cam.update();
	}

	@Override
	public void render () {
		dt += Gdx.graphics.getDeltaTime();

		if(dt > (1f / 30f /* 30 fps */)) {
			dt = 0;

			update();
		}

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		player_1.draw_self(snake_renderer);
	}

	void update() {
		player_1.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
