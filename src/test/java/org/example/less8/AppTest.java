package org.example.less8;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class AppTest extends TestBase {

    @Test
    void testGET() {
        given()
                .queryParam("foo", "bar")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200)
                .body("args.foo", equalTo("bar"));
    }

    @Test
    void testGET_Woops() {
        given()
                .queryParam("test", "123")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200)
                .body("args.test", anyOf(
                        equalTo("123"),
                        hasItem("123")
                ));
    }


    @Test
    void testPOST_RawText() {
        String body = "Hello Katya";

        given()
                .contentType("text/plain; charset=UTF-8")
                .body(body)
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }


    @Test
    void testPOST_FormData() {
        given()
                .contentType("multipart/form-data")
                .multiPart("name", "Katya")
                .multiPart("age", "25")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("form.name", equalTo("Katya"))
                .body("form.age", equalTo("25"));
    }


    @Test
    void testPUT() {
        String body = "{ \"update\": true }";

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("json.update", equalTo(true));
    }

    @Test
    void testPATCH() {
        String body = "{ \"patched\": 123 }";

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .body("json.patched", equalTo(123));
    }

    @Test
    void testDELETE() {
        given()
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("url", containsString("/delete"));
    }
}
