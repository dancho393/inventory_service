package com.learning.microservices.inventory;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;


@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.3.0");

    @LocalServerPort
    private Integer port;


    @BeforeEach
    void prepareTest(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port=port;
    }
    static {
        mySQLContainer.start();
    }
    @Test
    void checkIfInventoryExists() {
         RestAssured.given()
                .when()
                .get("api/inventory?skuCode=iphone_15&quantity=100")
                .then()
                .log().all()
                .statusCode(200)
                 .body("result", Matchers.equalTo(true));


    }

}
