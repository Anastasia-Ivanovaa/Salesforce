package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class CarTest {

    @Test
    public void checkCar(){

        log.fatal("fatal");
        log.error("error");
        log.warn("warning");
        log.info("info");
        log.debug("debug");
        log.trace("trace");
    }
}
