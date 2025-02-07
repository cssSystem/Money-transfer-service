package sys.tem;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.containers.GenericContainer;
import sys.tem.model.Amount;
import sys.tem.model.ConfirmOperation;
import sys.tem.model.RequestResponse;
import sys.tem.model.Transfer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestContainers {
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> app = new GenericContainer<>("moneytransferservice-app:latest").withExposedPorts(5500);
    private static Transfer transfer;

    @BeforeAll
    public static void init() {
        app.start();
        transfer = Transfer.builder()
                .amount(Amount.builder()
                        .value(100)
                        .currency("RUB")
                        .build())
                .cardFromCVV("123")
                .cardFromNumber("1234123412341234")
                .cardToNumber("4321432143214321")
                .cardFromValidTill("12/25")
                .build();
    }

    @Test
    void transferTest() {


        RequestResponse res = restTemplate
                .postForObject("http://localhost:" + app.getMappedPort(5500) + "/transfer"
                        , transfer
                        , RequestResponse.class);
        Assertions.assertEquals("1", res.getOperationId());
    }

    @Test
    void transferErrTest() {
        Transfer transfer = Transfer.builder()
                .build();
        RequestResponse res = restTemplate
                .postForObject("http://localhost:" + app.getMappedPort(5500) + "/transfer"
                        , transfer
                        , RequestResponse.class);
        Assertions.assertEquals(null, res.getOperationId());
    }

    @Test
    void confirmOperationTest() {
        restTemplate
                .postForObject("http://localhost:" + app.getMappedPort(5500) + "/transfer"
                        , transfer
                        , RequestResponse.class);
        ConfirmOperation confirmInfo = new ConfirmOperation("0000", "2");
        RequestResponse response = restTemplate.postForObject("http://localhost:" + app.getMappedPort(5500) + "/confirmOperation"
                , confirmInfo
                , RequestResponse.class);
        Assertions.assertEquals("2", response.getOperationId());
    }


}
