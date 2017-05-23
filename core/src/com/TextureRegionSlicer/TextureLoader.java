package com.TextureRegionSlicer;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.util.HashMap;

/**
 * Created by Carl on 30/03/2017.
 */

//Use for sprite maps,
public class TextureLoader {
    TextureRegionSlicer slicer = new TextureRegionSlicer();
    public HashMap <String, TextureRegion> stringTextures = new HashMap<String, TextureRegion>();


    //*********Place in array for each texture map***************
    TextureRegion[][] tilesetRegions = new TextureRegion[20][];


    public TextureLoader() {

     //*******Slice each array here and assign to 2d map**************
     tilesetRegions = slicer.getSlicedTextureRegionArray("graphicsTest.png", 16, 16);
     this.assignTiles();
    }

    public TextureRegion getTextureRegion(String name){
        name=name.toLowerCase();
        return this.stringTextures.get(name);
    }

    //***********Create hashmap entries here**************************
    private void assignTiles(){
        stringTextures.put("door", tilesetRegions[0][1]);
    }

}
