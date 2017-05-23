package com.Units;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

/**
 * Created by Carl on 25/03/2017.
 */

public class Unit extends Actor{
    TextureRegion img;
    Sprite sprite = new Sprite();
    Vector3 unProjectedPosition = new Vector3();

    Vector2 velocity = new Vector2();
    Vector2 movement = new Vector2();
    Vector2 dir = new Vector2();
    ArrayList<Vector2> path = new ArrayList<Vector2>();
    float speed = 20f;

    Rectangle rect = new Rectangle();
    boolean hasOffset;
    float rectXoffset;
    float rectYoffset;

    /****************************
     * Default contstructor containing sprite and
     * TODO remove placehonder badlogic.jpg with a seperate default image
     ****************************/
    public Unit(){
        img=new TextureRegion(new Texture("badlogic.jpg"));
    }

    /*************************
    * Basic construct for static image, collision box is the size of image.
     * Creating a unit with a specific textureRegion at a specific location with a specific size
     * Creating a collision rectanlge around the UNIT
     * x and y are locations within world space.
    * Default spawn with hit box size of sprite
    **************************/
    public void spawn(TextureRegion txt, float x, float y, float width, float height ){
        this.img=txt;
        this.sprite.setRegion(txt);
        this.sprite.setBounds(x,y,width,height);
        this.unProjectedPosition.x=x;
        this.unProjectedPosition.y=y;

        this.rect.setWidth(sprite.getWidth());
        this.rect.setHeight(sprite.getHeight());
        this.hasOffset=false;
        this.rectXoffset=0;
        this.rectYoffset=0;
    }

    public void adjustCollisionRectangle(float width, float height, float offX, float offY){
        this.rect.width=width;
        this.rect.height=height;
        this.rectXoffset=offX;
        this.rectYoffset=offY;
    }

    //Flips for if the collision rectangle has an offset.
    private void updateRectangle(){
        if(!this.hasOffset) {
            this.rect.x = this.unProjectedPosition.x/2;
            this.rect.y = this.unProjectedPosition.y/2;
        }

        if (this.hasOffset){
            this.rect.x= this.unProjectedPosition.x+this.rectXoffset;
            this.rect.y= this.unProjectedPosition.y+this.rectYoffset;
        }
    }

    public  void draw(float delta, SpriteBatch batch, Camera cam){
        Vector3 temp = new Vector3();
        temp.x=this.unProjectedPosition.x;
        temp.y=this.unProjectedPosition.y;
        cam.project(temp);

        this.sprite.setX(temp.x);
        this.sprite.setY(temp.y);
        this.updateRectangle();
        sprite.draw(batch);
    }



    //add vector to path real world coordinate
    public void addToPath(Vector2 vector, Camera cam){
        Vector3 temp = new Vector3();
        temp.x=this.unProjectedPosition.x;
        temp.y=this.unProjectedPosition.y;
        cam.project(temp);
        Vector2 result= new Vector2(temp.x, temp.y);
        path.add(result);
    }




    /*

     public void MoveVectorThisCycle(float deltaTime, SpriteBatch batch, Camera cam){
        this.draw(deltaTime, batch, cam);
    }



    //True if object position is equal to the position of the first listed path vector
   private boolean  hasReachedPathVector(){
        if (this.position.x == this.path.get(0).x && this.position.y == this.path.get(0).y){
            return true;
        }
        return false;
    }


    private void legacyFunction(){
        if (this.path.isEmpty()) {
            return;
        }

        // position.set(sprite.getX(), sprite.getY());

        dir.set(path.get(0)).sub(position).nor();
        velocity.set(dir).scl(speed);
        movement.set(velocity).scl(deltaTime);

        if (position.dst2(path.get(0)) > movement.len2()) {
            position.add(movement);
        } else {
            position.set(path.get(0));
        }

        sprite.setX(position.x);
        sprite.setY(position.y);

        if (this.hasReachedPathVector()) {
            removePathVector();
        }

    }

    private void removePathVector(){
        this.path.remove(0);
    }
    */


}
