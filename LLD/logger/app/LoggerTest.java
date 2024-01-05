package LLD.logger.app;

import LLD.logger.domain.Logger;

public class LoggerTest {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger();

        logger.info("This is info");
        logger.debug("This is debug");
        logger.error("This is error");
    }
}
