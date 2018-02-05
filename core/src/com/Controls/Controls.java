package com.Controls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Carl on 17/04/2017.
 */

public class Controls implements InputProcessor {

    private Boolean isLeftPressed;
    private Boolean isRightPressed;
    private Boolean isUpPressed;
    private Boolean isDownPressed;
    private Boolean hasClickedMap;
    private int clickedLocationX;
    private int clickedLocationY;

    public Controls(){
        Gdx.input.setInputProcessor(this);

        this.isDownPressed=false;
        this.isUpPressed=false;
        this.isLeftPressed=false;
        this.isRightPressed=false;
        this.hasClickedMap=false;
        this.clickedLocationX=0;
        this.clickedLocationY=0;
    }

    public Boolean getDownPressed() {
        return isDownPressed;
    }
    public Boolean getLeftPressed() {
        return isLeftPressed;
    }
    public Boolean getRightPressed() {
        return isRightPressed;
    }
    public Boolean getUpPressed() {
        return isUpPressed;
    }
    public Boolean getHasClickedMap() {
        return hasClickedMap;
    }

    public int getClickedLocationX() {
        return clickedLocationX;
    }
    public int getClickedLocationY() {
        return clickedLocationY;
    }

    @Override
    public boolean keyDown(int keycode) {

        //up
        if (keycode == 51) {
            this.isUpPressed=true;
        }

        //right
        if (keycode == 32) {
            this.isRightPressed=true;
        }

        //down
        if (keycode == 47) {
            this.isDownPressed=true;
        }

        //left
        if (keycode == 29) {
            this.isLeftPressed=true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        //up
        if (keycode == 51) {
            this.isUpPressed=false;
        }

        //right
        if (keycode == 32) {
            this.isRightPressed=false;
        }

        //down
        if (keycode == 47) {
            this.isDownPressed=false;
        }

        //left
        if (keycode == 29) {
            this.isLeftPressed=false;
        }

        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.hasClickedMap=true;

        this.clickedLocationX=screenX;
        this.clickedLocationY=screenY;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.hasClickedMap=false;
        return false;
    }


    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
