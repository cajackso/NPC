package com.Envioronment;

import com.Camera.gamecamera;
import com.Controls.Controls;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Carl on 17/04/2017.
 * Match Inputs with commands
 */



public class InputHandler {
Vector3 clickedCoords;
    public InputHandler(){
        clickedCoords = new  Vector3();
    }

    public void cameraController(gamecamera cam, Controls con, float mapHeight, float mapWidth) {
        if (con.getDownPressed())
            cam.MoveCameraDown();

        if (con.getLeftPressed())
            cam.MoveCameraLeft();

        if (con.getUpPressed())
            cam.MoveCameraUp();

        if (con.getRightPressed())
            cam.MoveCameraRight();

        cam.checkCameraBounds(mapHeight, mapWidth);

    }


    //vec when clicked contains real world coords
    public void getClickedRealWorldPosition(gamecamera cam, Controls ctrl){
        if(ctrl.getHasClickedMap()==true){
            Vector3 vec=new Vector3(ctrl.getClickedLocationX(),ctrl.getClickedLocationY(),0);
            cam.getCam().unproject(vec);
        }
    }




}



