package com.mygamepackage;

import com.Login.CredentialUtil;
import com.Login.Credentials;
import com.Login.SessionObj;
import com.Pages.MainPage;
import com.Pages.NewUser;
import com.User.User;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BarrensClient extends Game implements ApplicationListener {

    public SpriteBatch batch;
    public OrthographicCamera camera;

    public User me;
    public Credentials creds;
    public SessionObj session;

    NewUser userScreen;
    MainPage mainPage;

    public void create () {
        creds=new Credentials();
        session=new SessionObj();
        me=new User();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        batch=new SpriteBatch();

        CredentialUtil cUtil= new CredentialUtil();
        cUtil.processFirstFunctions();

        userScreen=new NewUser(this,cUtil);
        mainPage=new MainPage(this,me);

        if(cUtil.getSessionObj().isHasAccount()==false){
            this.setScreen(userScreen);
        }
    }

    @Override
    public void render () {
        super.render();
    }


    @Override
    public void dispose () {

    }

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public User getMe() {
        return me;
    }

    public void setMe(User me) {
        this.me = me;
    }

    public Credentials getCreds() {
        return creds;
    }

    public void setCreds(Credentials creds) {
        this.creds = creds;
    }

    public SessionObj getSession() {
        return session;
    }

    public void setSession(SessionObj session) {
        this.session = session;
    }

    public void setScreenToMainPage(){
        this.setScreen(this.mainPage);
    }
}


