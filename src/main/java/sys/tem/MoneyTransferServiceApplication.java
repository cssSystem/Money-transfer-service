package sys.tem;

import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@Log4j2
public class MoneyTransferServiceApplication {
    public static final Marker MI = MarkerManager.getMarker("MI");

    public static void main(String[] args) {
        SpringApplication.run(MoneyTransferServiceApplication.class, args);
        log.info(MI, "---Start service---");
    }

}
