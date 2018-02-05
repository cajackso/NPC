package com.Login;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

import java.util.UUID;

/**
 * Created by Carl on 15/10/2017.
 */

public class CredentialUtil {

Credentials creds;
SessionObj session;

   public CredentialUtil(){
        session=new SessionObj();
        creds=new Credentials();
    }
    public void processFirstFunctions(){

        if(!doesLocalCredentailFileExist()){
            this.creds=this.generateNewCredentials();
            this.writeCredentialsLocally(this.creds);
        }

        this.creds=this.readCredentials();
        this.session=new com.OutboundRest.CredentialsRest().send(this.getJsonCreds());
        if(session != null){
            System.out.println("Setting session to "+session.getSessionId());
            System.out.println("has account "+session.hasAccount);
        }
    }


    public boolean doesLocalCredentailFileExist() {
        if (Gdx.files.isLocalStorageAvailable()) {
            if (Gdx.files.local("BarrensCreds.txt").exists()) {
                return true;
            }
        }
        return false;
    }

    public Credentials generateNewCredentials(){
        UUID un = UUID.randomUUID();
        UUID pw= UUID.randomUUID();
        Credentials creds = new Credentials();
        creds.setUserName(un.toString());
        creds.setPassword(pw.toString());
        return creds;
    }

    public void writeCredentialsLocally(Credentials creds){
        FileHandle file = Gdx.files.local("BarrensCreds.txt");
        Json json = new Json();
        file.writeString(json.toJson(creds), false);
    }

    public Credentials readCredentials(){
        FileHandle file = Gdx.files.internal("BarrensCreds.txt");
        String credText = file.readString();
        Json json = new Json();

        Credentials creds = json.fromJson(Credentials.class, credText);
        return creds;
    }

    public String getJsonCreds(){
        Json json = new Json();
        return json.toJson(this.creds);
    }


    public Credentials getCreds(){
        return this.creds;
    }

    public SessionObj getSessionObj(){
        return this.session;
    }

}