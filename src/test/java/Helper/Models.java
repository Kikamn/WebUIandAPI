package Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static Helper.Utility.generateRandomEmail;


public class Models {
    private static RequestSpecification request;

    public static void setupHeader() {
        request = RestAssured.given()
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer d361ff35b18930da63c2461abe6b56e66d4bbfb616d840e2c4d99cd7bbe75c73");
    }
    public static Response getListUser (String endpoint) {
        setupHeader();
        return request.when().get(endpoint);
    }
    public static Response postNewUser (String endpoint){
        String name = "Muhamad Farel Syareza";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "inactive";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("gender", gender);
        jsonObject.put("email", email);
        jsonObject.put("status", status);

        setupHeader();
        return request.body(jsonObject.toString()).when().post(endpoint);
    }

    public static Response deleteUser(String endPoint, String user_id){
        setupHeader();
        String finalEndPoint = endPoint + "/" + user_id;
        return request.when().delete(finalEndPoint);
    }

    public static Response updateUSer(String endPoint, String user_id){
        setupHeader();
        String name = "Rizkika Wahyuni";
        String gender = "female";
        String email = generateRandomEmail();
        String status = "active";

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("gender", gender);
        jsonObject.put("email", email);
        jsonObject.put("status", status);

        String finalEndPoint = endPoint + "/" + user_id;
        return request.body(jsonObject.toString()).when().patch(finalEndPoint);
    }
}
