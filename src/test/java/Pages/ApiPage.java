package Pages;

import Helper.Endpoint;
import Helper.Utility;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static Helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {
    String setURL, global_id;
    Response res;

    public void prepareURLValidFor(String URL){
      switch (URL){
          case "USER_GOREST":
              setURL = Endpoint.USER_GOREST;
              break;
          default:
              System.out.println("Input Right URL");
      }
        System.out.println("Endpoint siap pakai adalah: " + setURL);
    }
    public void hitAPIGetListData(){
        res = getListUser(setURL);
        System.out.println(res.getBody().asString());
    }
    public void hitAPIPostUser(){
        res = postNewUser(setURL);
        //System.out.println(res.getBody().asString());
    }
    public void validationStatusCodeIsEquals(int statusCode){
        assertThat(res.statusCode()).isEqualTo(statusCode);
    }
    public void validationResponseBodyGetListUser(){
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }
    public void validationResponseJsonWhitJSONSchema(String fileJSON){
        File JSONFile = Utility.getJSONSchemaFile(fileJSON);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
    public void validationResponseBodyPostCreateNewUser(){
        JsonPath jsonPath = res.jsonPath();
        Integer id = jsonPath.get("id");
        String name = jsonPath.get("name");
        String email = jsonPath.get("email");
        String gender = jsonPath.get("gender");
        String status = jsonPath.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }
    public void hitAPIDeleteNew(){
        res = deleteUser(setURL, global_id);
    }

    public void hitAPIUpdateData(){
        res = updateUSer(setURL, global_id);
        System.out.println(res.getBody().asString());
    }
    public void validationResponseBodyUpdateUser(){
        JsonPath jsonPath = res.jsonPath();
        Integer id = jsonPath.get("id");
        String name = jsonPath.get("name");
        String email = jsonPath.get("email");
        String gender = jsonPath.get("gender");
        String status = jsonPath.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }
}
