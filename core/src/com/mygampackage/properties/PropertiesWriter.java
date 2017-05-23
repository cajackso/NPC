package com.mygampackage.properties;

/**
 * Created by Carl on 26/03/2017.
 */

import com.badlogic.gdx.Gdx;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

    public class PropertiesWriter {
        public static void main(String[] args) {
            Properties prop = new Properties();
            OutputStream output = null;

            try {
                output = new FileOutputStream(Gdx.files.getLocalStoragePath());
                prop.setProperty("showCollisionBox", "true");

                // save properties to project root folder
                prop.store(output, null);

            } catch (IOException io) {
                io.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
