package com.Units;

import com.Camera.gamecamera;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

/**
 * Created by Carl on 23/05/2017.
 */

public class UnitControlHandler {

    ArrayList<Unit> unitList = new ArrayList<Unit>();

    public void addStaticUnitToController (Unit newUnit){
      this.unitList.add(newUnit);
        this.unitList.get(this.unitList.size()-1).setCanMove(false);
        this.unitList.get(this.unitList.size()-1).setAlwaysActive(false);
    }

    public void addSelectableUnitToController (Unit newUnit){
        this.unitList.add(newUnit);
        this.unitList.get(this.unitList.size()-1).setCanMove(true);
        this.unitList.get(this.unitList.size()-1).setAlwaysActive(false);
    }

    public void addPlayerToController (Unit newUnit){
        this.unitList.add(newUnit);
        this.unitList.get(this.unitList.size()-1).setCanMove(true);
        this.unitList.get(this.unitList.size()-1).setAlwaysActive(true);
    }

    public void processUnits(float delta, SpriteBatch batch, gamecamera cam){

       //update
        for (int count=0; count<unitList.size(); count++){
            if(this.unitList.get(count).canMove){
                this.unitList.get(count).processQueuedMovement(delta);
            }
         //draw
            this.unitList.get(count).draw(delta,batch,cam.getCam());
        }
    }

    public void addPathwayToActiveAndPlayerUnits(float x, float y, Camera cam){
        for (int count=0; count<unitList.size(); count++){
            this.unitList.get(count).addToPath(new Vector2(x,y), cam);
        }
    }
}
