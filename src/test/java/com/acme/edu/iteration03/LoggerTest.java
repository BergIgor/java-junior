package com.acme.edu.iteration03;

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
    private Logger logger ;
    private StateFactory stateFactory;
    private static final String SEP = System.lineSeparator();
    //region given

    @Before
    public void setUpSystemOut() throws IOException,DontPrintException {
        captureSysout();
        logger = new Logger(new ConsolePrinter(),new FilePrinter("UTF-8"));
    }
    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogIntegersArray() throws IOException, LogException {

        //region when
        logger.log(new int[]{-1, 0, 1});
        //endregion

        //region then
        assertSysoutContains("0");;
        //endregion

    }

    @Test
    public void shouldLogIntegersMatrix() throws IOException, LogException {
        //region when
        logger.log(new int[][]{{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" + SEP +
            "{-1, 0, 1}" + SEP +
            "{1, 2, 3}" + SEP +
            "{-1, -2, -3}" + SEP +
            "}" + SEP
        );

        //endregion
    }

    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException, LogException {
        //region when
        logger.log(new int[][][][]{{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {" + SEP +
            "{" + SEP + "{" + SEP + "{"  +
            "0"  +
            "}" + SEP + "}" + SEP + "}" + SEP +
            "}" + SEP
        );

        //endregion
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException,LogException {
        //region when
        logger.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1" + SEP + "string 2" + SEP + "str 3");

        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException,LogException {
        //region when
        logger.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion

    }
    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException, LogException {
        //region when
        logger.log(1);
        logger.log("str");
        logger.log(Integer.MAX_VALUE - 10);
        logger.log(11);
        logger.close();
        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("string: str");
        assertSysoutContains("primitive: " + (Integer.MAX_VALUE - 10));
        assertSysoutContains("primitive: 11");
        //endregion
    }
}
