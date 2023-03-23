package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {


   public static Response createUser(User Payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(Payload)
                .when()
                .post(routes.post_url);

        return response;
    }

    public static Response readUser(String userName){

        Response response = given()
                .pathParam("username" , userName)
                .when()
                .get(routes.get_url);

        return response;
    }

    public static Response UpdateUser(String userName , User Payload){

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username" , userName)
                .body(Payload)
                .when()
                .put(routes.update_url);

        return response;
    }

    public static Response deleteUser(String userName){

        Response response = given()
                .pathParam("username" , userName)
                .when()
                .delete(routes.delete_url);

        return response;
    }


}
