package restATtest;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Divya
 *          Here is a simple example where
 *          we are trying automate this API TESTING
 *          If HTTP_STATUS_CODE IS 200 , it means API is giving response
 *          with out any error.
 */
public class countries {
    // API URL: http://dummy.restapiexample.com/api/v1/employees
    @Test
    public void validateDummyApiStatusCode() {
        //this is my first comment
        given().get("http://dummy.restapiexample.com/api/v1/employees").then().statusCode(200).log().all();
    }

    // API URL: https://reqres.in/api/users?page=2
    @Test
    public void validateDummyApiStatusCodeWithQueryParameter() {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification();
        requestSpecification.queryParam("page", 2).log().all();
        final ValidatableResponse all = given().spec(requestSpecification).get("https://reqres.in/api/users").then().statusCode(200).log().all();

    }

    //http://dummy.restapiexample.com/api/v1/employee/1
    @Test
    public void validateDummyApiStatusCodeWithPathParameter() {
        given()
                .pathParam("country", "Finland")
                .when()
                .get("http://restcountries.eu/rest/v1/name/{country}").then().statusCode(200).log().all();

    }

    @Test
    public void validateDummyApiResponse() {
        String userId = given()
                .get("https://jsonplaceholder.typicode.com/posts/1/")
                .then()
                .contentType(ContentType.JSON).extract().response().jsonPath().getString("userId");

        assert userId.equals("1");

    }


}