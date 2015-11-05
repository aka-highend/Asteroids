package com.mygdx.asteroids.gamestate;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.asteroids.entities.Asteroid;
import com.mygdx.asteroids.entities.Bullet;
import com.mygdx.asteroids.entities.Player;
import com.mygdx.asteroids.managers.GameKeys;
import com.mygdx.asteroids.managers.GameStateManager;

import java.util.ArrayList;

/**
 * Created by fachrur_122 on 07/08/2015.
 */
public class PlayState extends GameState {

    private ShapeRenderer sr;

    private Player player;
    private ArrayList<Bullet> bullets;
    private ArrayList<Asteroid> asteroids;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        init();
    }

    @Override
    public void init() {
        sr = new ShapeRenderer();

        bullets = new ArrayList<Bullet>();

        player = new Player(bullets);

        asteroids = new ArrayList<Asteroid>();
        asteroids.add(new Asteroid(100, 100, Asteroid.LARGE));
        asteroids.add(new Asteroid(200, 100, Asteroid.MEDIUM));
        asteroids.add(new Asteroid(300, 100, Asteroid.SMALL));
    }

    @Override
    public void update(float dt) {

        //get user input
        handleInput();

        //update player
        player.update(dt);

        //update player bullets
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).update(dt);
            if (bullets.get(i).shouldRemove()) {
                bullets.remove(i);
                i--;
            }
        }

        //update asteroids
        for (int i = 0; i < asteroids.size(); i++) {
            asteroids.get(i).update(dt);
            if (asteroids.get(i).shouldRemove()) {
                asteroids.remove(i);
                i--;
            }
        }
    }

    @Override
    public void draw() {
        //draw player
        player.draw(sr);

        //draw bullets
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).draw(sr);
        }

        //draw asteroids
        for (int i = 0; i < asteroids.size(); i++) {
            asteroids.get(i).draw(sr);
        }
    }

    @Override
    public void handleInput() {
        player.setLeft(GameKeys.isDown(GameKeys.LEFT));
        player.setRight(GameKeys.isDown(GameKeys.RIGHT));
        player.setUp(GameKeys.isDown(GameKeys.UP));
//        player.setDown(GameKeys.isDown(GameKeys.DOWN));
        if (GameKeys.isPressed(GameKeys.SPACE)) {
            player.shoot();
        }
    }

    @Override
    public void dispose() {

    }

}
