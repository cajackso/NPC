package com.OutboundRest;

import com.Login.SessionObj;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.badlogic.gdx.utils.Json;

public class CredentialsRest {
    Json json;

    public SessionObj send(String credsJson ){
        String output="";
        this.json=new Json();

        try {
            Client client = Client.create();
            WebResource webResource = client
                    .resource("http://localhost:8080/ServiceThen/rest/login/passCredentials");

            ClientResponse response = webResource.type("application/json")
                    .post(ClientResponse.class, credsJson);

            if (response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println("Output from Server .... \n");

            output= response.getEntity(String.class);
            SessionObj mySession = json.fromJson(SessionObj.class, output);

            System.out.println("myOutput "+output);
            return mySession;

        } catch (Exception e) {

            e.printStackTrace();

        }
        return null;
    }


}

