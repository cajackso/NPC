package com.OutboundRest;

import com.Login.SessionObj;
import com.User.User;
import com.badlogic.gdx.utils.Json;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class InsertNewUserRest {
Json json;
        public boolean send(User user){

            String output="";
            this.json=new Json();

            try {
                Client client = Client.create();
                WebResource webResource = client
                        .resource("http://localhost:8080/ServiceThen/rest/Insert/createNewUser");

                ClientResponse response = webResource.type("application/json")
                        .post(ClientResponse.class, json.toJson(user));

                if (response.getStatus() != 201) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatus());
                }


                output= response.getEntity(String.class);
                boolean answer = json.fromJson(boolean.class, output);
                return answer;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }



