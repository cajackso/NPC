package com.Pages;
import com.Login.CredentialUtil;
import com.OutboundRest.InsertNewUserRest;
import com.User.User;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygamepackage.BarrensClient;

public class NewUser implements Screen{
    OrthographicCamera camera;
    final BarrensClient game;
    Button button;
    Stage newUserStage;
    CredentialUtil credUtil;

    TextField userName;
    TextField password;
    TextField firstName;
    TextField lastName;
    TextField Email;
    Label userNameLabel;
    Label passwordNameLabel;
    Label firstNameLabel;
    Label lastNameLabel;
    Label emailLabel;

    User me;
    boolean hasSubmitted;

   public NewUser(BarrensClient game, final CredentialUtil credUtil){
        this.hasSubmitted=false;
        this.game=game;
        this.credUtil=credUtil;
        me=new User();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        newUserStage=new Stage();
        Gdx.input.setInputProcessor(newUserStage);
        Skin skin = new Skin(Gdx.files.internal("Skin/clean-crispy-ui.json"));

       button = new Button(skin);
       userName = new TextField("UserName",skin);
       password = new TextField("Password",skin);
       firstName = new TextField("",skin);
       lastName = new TextField("",skin);
       Email = new TextField("",skin);
       userNameLabel = new Label("UserName:", skin);
       passwordNameLabel= new Label("Password:", skin);
       firstNameLabel= new Label("FirstName:", skin);
       lastNameLabel= new Label("LastName:", skin);
       emailLabel= new Label("Email:", skin);

       button.setPosition(150,Gdx.graphics.getHeight()-350);
       button.setWidth(Gdx.graphics.getWidth()/5);

       userNameLabel.setPosition(10,Gdx.graphics.getHeight()-100);
       userName.setPosition(150,Gdx.graphics.getHeight()-100);

       passwordNameLabel.setPosition(10,Gdx.graphics.getHeight()-150);
       password.setPosition(150,Gdx.graphics.getHeight()-150);

       firstNameLabel.setPosition(10,Gdx.graphics.getHeight()-200);
       firstName.setPosition(150,Gdx.graphics.getHeight()-200);

       lastNameLabel.setPosition(10,Gdx.graphics.getHeight()-250);
       lastName.setPosition(150,Gdx.graphics.getHeight()-250);

       emailLabel.setPosition(10,Gdx.graphics.getHeight()-300);
       Email.setPosition(150,Gdx.graphics.getHeight()-300);

       button.addListener(new ClickListener(){

           @Override
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

               me.setUserName(userName.getText());
               me.setFirstName(firstName.getText());
               me.setLastName(lastName.getText());
               me.setPassword(password.getText());
               me.setEmail(Email.getText());
               me.setCreds(credUtil.getCreds());
               me.setSessionString(credUtil.getSessionObj().getSessionId());
               hasSubmitted=true;
               return true;
           }

   });

       newUserStage.addActor(button);
       newUserStage.addActor(userName);
       newUserStage.addActor(password);
       newUserStage.addActor(firstName);
       newUserStage.addActor(lastName);
       newUserStage.addActor(Email);
       newUserStage.addActor(userNameLabel);
       newUserStage.addActor(passwordNameLabel);
       newUserStage.addActor(firstNameLabel);
       newUserStage.addActor(lastNameLabel);
       newUserStage.addActor(emailLabel);

       userName.setText(credUtil.getCreds().getUsername());
       password.setText(credUtil.getCreds().getPassword());



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        if(this.hasSubmitted){
            InsertNewUserRest restInsert=new InsertNewUserRest();
            if(restInsert.send(this.me)==true) {
                this.game.setCreds(this.credUtil.getCreds());
                this.game.setSession(this.credUtil.getSessionObj());
                this.game.setMe(this.me);
            }
            this.game.setScreenToMainPage();
        }


        float t = Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.end();
        newUserStage.act(t);
        newUserStage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }
}
