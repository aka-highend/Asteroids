package com.mygdx.asteroids.entities;

import com.mygdx.asteroids.main.AsteroidMain;

/**
 * Created by fachrur_122 on 07/08/2015.
 */
public class SpaceObject {

    //position
    protected float x;
    protected float y;

    //vector
    protected float dx;
    protected float dy;

    protected float radians;
    protected float speed;
    protected float rotationSpeed;

    //size
    protected int width;
    protected int height;

    //shape
    protected float[] shapex;
    protected float[] shapey;

    protected void wrap() {
        if (x < 0) x = AsteroidMain.WIDTH;
        if (x > AsteroidMain.WIDTH) x = 0;
        if (y < 0) y = AsteroidMain.HEIGHT;
        if (y > AsteroidMain.HEIGHT) y = 0;
    }

}
