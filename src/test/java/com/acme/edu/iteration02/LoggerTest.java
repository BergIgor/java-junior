package com.acme.edu.iteration02;

import com.acme.edu.Exception.DontPrintException;
import com.acme.edu.Exception.PreviousNullStateException;
import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import com.acme.edu.Printer;
import com.acme.edu.ConsolePrinter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;

import java.io.IOException;
@Ignore
public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String SEP =System.lineSeparator();
    private Logger logger ;
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        captureSysout();
        logger = new Logger(new ConsolePrinter());
    }
    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException,PreviousNullStateException,DontPrintException {
        //region when
        logger.log("str 1");
        logger.log(1);
        logger.log(2);
        logger.log("str 2");
        logger.log(0);
        logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + SEP +
            "primitive: 3" + SEP +
            "string: str 2" + SEP +
            "primitive: 0" + SEP
        );

        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() throws IOException,PreviousNullStateException,DontPrintException {
        //region when
        logger.log("str 1");
        logger.log(10);
        logger.log(Integer.MAX_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.close();
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

    }

    @Ignore
    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() throws IOException,PreviousNullStateException,DontPrintException{

        //region when
        logger.log("str 1");
        logger.log((byte) 10);
        logger.log((byte) Byte.MAX_VALUE);
        logger.log("str 2");
        logger.log(0);
        logger.close();
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

    }


    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException,PreviousNullStateException,DontPrintException {
        //region when
        logger.log("str 1");
        logger.log("str 2");
        logger.log("str 2");
        logger.log(0);
        logger.log("str 2");
        logger.log("str 3");
        logger.log("str 3");
        logger.log("str 3");
        logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + SEP +
            "string: str 2 (x2)" + SEP +
            "primitive: 0" + SEP +
            "string: str 2" + SEP +
            "string: str 3 (x3)"+ SEP
        );
        //endregion
    }


}
