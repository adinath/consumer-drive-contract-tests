package beta.cdc.sample;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.model.RequestResponsePact;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(PactConsumerTestExt.class)
public class PassportConsumerTest {

    @Pact(provider = "test_provider", consumer = "test_consumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        DslPart template = new PactDslJsonBody()
                .stringType("number")
                .object("name")
                .stringType("givenName")
                .stringType("surName")
                .closeObject();

        return builder
                .given("test state")
                .uponReceiving("ExampleJavaConsumerPactTest test interaction")
                .path("/passport")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(new PactDslJsonArray()
                        .template(template)
                )
                .toPact();
    }

   /* "[" +
            "{" +
            "\"number\": \"H323455\"," +
            "\"name\": {" +
            "    \"givenName\": \"John Jr\"," +
            "    \"surName\": \"Smith\"" +
            "}," +
            "\"dateOfIssue\": \"2000-03-03\"," +
            "\"dateOfExpiry\": \"2020-03-03\"," +
            "\"fileNumber\": \"PNP3743434\"," +
            "\"nationality\": \"Indian\"," +
            "\"countryCode\": \"Indian\"," +
            "\"placeOfBirth\": null," +
            "\"placeOfIssue\": null," +
            "\"sex\": \"Male\"," +
            "\"birthDate\": \"1980-03-03\"" +
            "}" +
            "]"*/

    @Test
    void testArticles(MockServer mockServer) throws IOException {
        HttpResponse httpResponse = Request.Get(mockServer.getUrl() + "/passport").execute().returnResponse();
        assertThat(httpResponse.getStatusLine().getStatusCode()).isEqualTo(200);
    }
}
