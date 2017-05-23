package com.Camera;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Carl on 15/04/2017.
 */

public class gamecamera {

    OrthographicCamera cam;
    private float cameraSpeed;

   public gamecamera(){
       //Set default cam speed
        this.cameraSpeed=10;

       //Camera set to resolution
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        cam = new OrthographicCamera();
        cam.setToOrtho(false,w,h);
        cam.update();
    }


    public void checkCameraBounds(float mapHeight, float mapWidth){
    //left
        if(this.cam.position.x<0+this.cam.viewportWidth/2)
          this.cam.position.x=this.cam.position.x+cameraSpeed;
    //down
        if(this.cam.position.y<0+this.cam.viewportHeight/2)
            this.cam.position.y=this.cam.position.y+cameraSpeed;

      //up
        if(this.cam.position.y>mapHeight-this.cam.viewportHeight/2)
            this.cam.position.y=this.cam.position.y-cameraSpeed;


        //right
        if(this.cam.position.x>mapWidth-this.cam.viewportWidth/2)
            this.cam.position.x=this.cam.position.x-cameraSpeed;
    }


    public void MoveCameraLeft(){


       this.cam.position.x=this.cam.position.x-cameraSpeed;
    }

    public void MoveCameraRight(){
        this.cam.position.x=this.cam.position.x+cameraSpeed;
    }

    public void MoveCameraUp(){
        this.cam.position.y=this.cam.position.y+cameraSpeed;
    }

    public void MoveCameraDown(){
        this.cam.position.y=this.cam.position.y-cameraSpeed;
    }


    public OrthographicCamera getCam() {
        return cam;
    }
}
