package junk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by lolik on 20.06.2019
 */
public class TryLogger {

    private Logger logger = LoggerFactory.getLogger(TryLogger.class);

    @Test
    public void asdasd(){
        logger.info("ASDASDASD");
    }

}
