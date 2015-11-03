package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String SEP =System.lineSeparator();
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        captureSysout();
    }
    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        /*
        log("str 1");
        log(1);
        log(2);
        log("str 2");
        log(0);
        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + SEP +
            "primitive: 3" + SEP +
            "string: str 2" + SEP +
            "primitive: 0" + SEP
        );
        */
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        /*
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + SEP +
            "primitive: 10" + SEP +
            "primitive: " + Integer.MAX_VALUE + SEP +
            "string: str 2" + SEP +
            "primitive: 0" + SEP
        );
        //endregion
        */
    }


    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        /*
        //region when
        log("str 1");
        log((byte)10);
        log((byte)Byte.MAX_VALUE);
        log("str 2");
        log(0);
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1"  + SEP +
            "primitive: 10" + SEP +
            "primitive: " +Byte.MAX_VALUE + SEP +
            "string: str 2" + SEP +
            "primitive: 0" + SEP
        );
        //endregion
        */
    }


    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        /*
        Logger logger = new Logger();
        logger("str 1");
        logger("str 2");
        logger("str 2");
        logger(0);
        logger("str 2");
        logger("str 3");
        logger("str 3");
        logger("str 3");
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + SEP +
            "string: str 2 (x2)" + SEP +
            "primitive: 0" + SEP +
            "string: str 2" + SEP +
            "string: str 3 (x3)"+ SEP
        );
        */
        //endregion
    }


}
