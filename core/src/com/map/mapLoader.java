package com.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Carl on 15/04/2017.
 * ------------------------------
 * tiledMap - current loaded tilemap
 * tiledMapRenderer - current loaded renderer
 */

public class mapLoader {
    TiledMap tiledMap;
    OrthogonalTiledMapRenderer tiledMapRenderer;
    MapProperties prop;

    public void loadMap(String map) {
        this.replaceCurrentMap(map);
        this.prop=this.tiledMap.getProperties();
    }

    public void replaceCurrentMap(String maps){

        tiledMap = new TmxMapLoader().load(Gdx.files.internal(maps).path());
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public float getMapWidth(){
        int totalTilesWidth= prop.get("width", Integer.class);
        int tilePixelWidth = prop.get("tilewidth", Integer.class);
        return totalTilesWidth*tilePixelWidth;
    }

    public float getMapHeight(){
        int totalTilesHeight= prop.get("height", Integer.class);
        int tilePixelHeight = prop.get("tileheight", Integer.class);
        return totalTilesHeight*tilePixelHeight;
    }


    public OrthogonalTiledMapRenderer getTiledMapRenderer() {
        return tiledMapRenderer;
    }
}
