package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilites.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DDTests {

    @Test(priority = 1,dataProvider = "Data" , dataProviderClass = DataProviders.class)
    public void testPostUser(String userId , String userName , String FirstName , String Lastname ,
                             String email , String password , String phone){


        User userPayload=new User();
        userPayload.setId(Integer.parseInt(userId));
        userPayload.setUsername(userName);
        userPayload.setFirstName(FirstName);
        userPayload.setLastName(Lastname);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);

        Response response = UserEndPoints.createUser(userPayload);

        Assert.assertEquals(response.getStatusCode(),200);



    }
    @Test(priority = 2,dataProvider = "UserNames" , dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName){

        Response response = UserEndPoints.deleteUser(userName);
        Assert.assertEquals(response.getStatusCode(),200);

    }
}
