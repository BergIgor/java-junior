package com.acme.edu.iteration03;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.After;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {

    private static final String SEP = System.lineSeparator();
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
    @Ignore
    @Test
    public void shouldLogIntegersArray() throws IOException {
        /*
        //region when
        log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutContains("0");;
        //endregion
        */
    }
    @Ignore
    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        /*
        log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" + SEP +
            "{-1, 0, 1}" + SEP +
            "{1, 2, 3}" + SEP +
            "{-1, -2, -3}" + SEP +
            "}" + SEP
        );
        */
        //endregion
    }
    @Ignore
    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        /*
        log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {" + SEP +
            "{" + SEP + "{" + SEP + "{" + SEP +
            "0" + SEP +
            "}" + SEP + "}" + SEP + "}" + SEP +
            "}" + SEP
        );
        */
        //endregion
    }
    @Ignore
    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        /*
        log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1" + SEP + "string 2" + SEP + "str 3");
        */
        //endregion
    }
    @Ignore
    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        /*
        log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
        */
    }
    @Ignore
    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        /*
        log(1);
        log("str");
        log(Integer.MAX_VALUE - 10);
        log(11);
        //endregion

        //region then
        assertSysoutContains("primitive: 1");
        assertSysoutContains("string: str");
        assertSysoutContains("primitive: " + (Integer.MAX_VALUE - 10));
        assertSysoutContains("primitive: 11");
        //endregion
        */
    }


}
