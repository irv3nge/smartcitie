package com.pedro.smartcities.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class SensorSteps {

    private String payload;
    private Response response;

    @Given("a payload válido de sensor")
    public void a_payload_válido_de_sensor() {
        payload = """
        {
            "tipo": "temperatura",
            "valor": 25.5,
            "localizacao": "Sala 1",
            "horario": "2025-05-06T18:00:00Z"
        }
        """;
    }

    @Given("um payload inválido de sensor")
    public void um_payload_inválido_de_sensor() {
        payload = "{ \\\"tipo\\\": \\\"\\\", \\\"valor\\\": null, \\\"localizacao\\\": \\\"\\\" }";
    }

    @When("enviar uma requisição POST para {string}")
    public void enviar_uma_requisição_post_para(String endpoint) {
        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post("http://localhost:8080" + endpoint);
    }

    @When("enviar uma requisição GET para {string}")
    public void enviar_uma_requisição_get_para(String endpoint) {
        response = RestAssured.given()
                .get("http://localhost:8080" + endpoint);
    }

    @Then("a resposta deve ter status {int}")
    public void a_resposta_deve_ter_status(Integer status) {
        response.then().statusCode(status);
    }

    @Then("o corpo deve conter o tipo {string}")
    public void o_corpo_deve_conter_o_tipo(String tipo) {
        response.then().body("tipo", equalTo(tipo));
    }

    @Then("o corpo deve estar em conformidade com o JSON Schema")
    public void o_corpo_deve_estar_em_conformidade_com_o_json_schema() {
        response.then().body(matchesJsonSchemaInClasspath("schemas/sensor-schema.json"));
    }
}
