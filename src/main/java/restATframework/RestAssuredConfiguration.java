package restATframework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfiguration {

    public RequestSpecification getRequestSpecification(){
        return RestAssured.given().contentType(ContentType.JSON);
    }
}

