package com.TextureRegionSlicer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Carl on 29/03/2017.
 */

public class TextureRegionSlicer {
    TextureRegion[][] regions;
    Texture texture;
    TextureRegion region;
    /**************
     *   Accepts a condensed sprite map that contains a equally spaced images
     *   Params - image individual width/height
     *   Returns 2dimensional array of textureRegions.
     ******************/
    public TextureRegion[][] getSlicedTextureRegionArray(String file, int individualWidth, int individualHeight) {
        texture = new Texture(Gdx.files.internal(file));
        region = new TextureRegion(texture);
        regions=region.split(individualWidth,individualHeight);
   return regions;
    }
}

