package com.acme.edu.iteration01;

import com.acme.edu.*;
import com.acme.edu.Exception.DontPrintException;
import com.acme.edu.Exception.LogException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;

import java.io.IOException;
@Ignore
public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String SEP = System.lineSeparator();
    private Logger logger ;
    private StateFactory stateFactory;
    //region given
    @Before
    public void setUpSystemOut() throws IOException,DontPrintException {
        captureSysout();
        logger = new Logger(new FilePrinter("UTF-8"), new ConsolePrinter());
    }
    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws IOException, LogException {

        //region when
        logger.log(1);
        logger.log(0);
        logger.log(-1);
        logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 0" +SEP );
        //endregion

    }


    @Test
    public void shouldLogByte() throws IOException, LogException {

        //region when
        logger.log((byte) 1);
        logger.log((byte) 0);
        logger.log((byte) -1);
        logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("0");
        //endregion

    }


    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException, LogException {

        //region when
        logger.log('a');
        logger.log('b');
        logger.close();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion

    }

    @Test
    public void shouldLogString() throws IOException, LogException {
        //region when
        logger.log("test string 1");
        logger.log("other str");
        logger.close();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion

    }


    @Test
    public void shouldLogBoolean() throws IOException, LogException {

        //region when
        logger.log(true);
        logger.log(false);
        logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion

    }

    @Test
    public void shouldLogReference() throws IOException, LogException {

        //region when
        logger.log(new Object());
        logger.close();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion

    }


}