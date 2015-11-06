package com.acme.edu.unit;

import com.acme.edu.*;
import com.acme.edu.Exception.LogException;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;

public class LoggerTest {

    private Printer printer;
    private static final String SEP = System.lineSeparator();
    //region given
    @Before
    public void setUp() throws IOException {
        printer = mock(Printer.class);
    }
    //endregion

    @Test
    public void shouldLogSumOfInt() throws  LogException{
        State state = new IntState(printer);
        state.log(String.valueOf(4));
        state.log(String.valueOf(0));
        state.log(String.valueOf(3));
        state.flush();

        verify(printer, times(1)).print("primitive: 7");
    }

    @Test
    public void shouldntCallPrintForStringState() throws  LogException{
        State state = new StringState(printer);
        state.flush();

        verify(printer, times(0)).print("");
    }

    @Test
    public void shouldLogIfIntValueIsMax() throws  LogException{
        State state = new IntState(printer);
        state.log(String.valueOf(10));
        state.log(String.valueOf(Integer.MAX_VALUE));
        state.flush();

        verify(printer, times(1)).print("primitive: 10");
        verify(printer, times(1)).print("primitive: " + Integer.MAX_VALUE);
    }

    @Test
    public void shouldLogIfExistDuplication() throws LogException{
        State state = new StringState(printer);
        state.log("str 1");
        state.log("str 1");
        state.log("str 1");
        state.flush();

        verify(printer, times(1)).print("string: str 1 (x3)");
    }

    @Test
    public void shouldntCallPrintForIntState() throws LogException{
        State state = new IntState(printer);
        state.flush();

        verify(printer, times(0)).print("");
    }

    @Test
    public void shouldLogIfIntegerOverFlow() throws  LogException{
        State state = new IntState(printer);
        state.log(String.valueOf(Integer.MAX_VALUE - 15));
        state.log(String.valueOf(17));
        state.flush();

        verify(printer, times(1)).print("primitive: " + (Integer.MAX_VALUE - 15));
    }

    @Test
    public void shouldLogIfParamIsObject() throws  LogException{
        State state = new DefaultState(printer);
        state.log(new String().toString());
        state.flush();

        verify(printer, times(1)).print("");
}

    @Test
    public void shouldLogNumberIfZeroBuffer() throws  LogException{
        State state = new IntState(printer);
        state.log(String.valueOf(0));
        state.flush();

        verify(printer, times(1)).print("primitive: 0");
    }

    @Test
    public void shouldntCallPrintForDefaultState() throws  LogException{
        State state = new DefaultState(printer);
        state.flush();

        verify(printer, times(0)).print("");
    }

    @Test
    public void shouldLogIfBothValueString() throws  LogException{
        State state = new StringState(printer);
        state.log(String.valueOf(5));
        state.log(String.valueOf(Integer.MAX_VALUE));
        state.flush();

        verify(printer, times(1)).print("string: 5");
        verify(printer, times(1)).print("string: " + Integer.MAX_VALUE);
    }

    @Test
    public void shouldLogAsSumItemsOfArrayInteger() throws  LogException {
        Logger logger = new Logger(printer);
        logger.log(new int[]{3, 0, -2});
        logger.close();

        verify(printer, times(1)).print("1");
    }

    @Test
    public void shouldLogIntegersMatrix() throws LogException {
        Logger logger = new Logger(printer);
        logger.log(new int[][]{{0, 0, 1}, {2, 2, 2}, {-1, -1, -1}});
        logger.close();

        verify(printer, times(1)).print("primitives matrix: {" + SEP +
                "{0, 0, 1}" + SEP +
                "{2, 2, 2}" + SEP +
                "{-1, -1, -1}" + SEP +
                "}"
        );
    }

    @Test
    public void shouldLogStringsWithOneMethodCall() throws LogException {
        Logger logger = new Logger(printer);
        logger.log("str1", "string 2", "str 3");
        logger.close();

        verify(printer, times(1)).print("str1" + SEP + "string 2" + SEP + "str 3" + SEP);
    }

    @Test
    public void shouldAssertIntStateWithFactoryStateisNull() throws LogException{
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);

        assertEquals(IntState.class, factory.getInstanceIntState(null).getClass());
    }

    @Test
    public void shouldAssertEqualStringMockStringStateWithAFactoryInstanceStringState() throws LogException{
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);

        assertEquals(IntState.class, factory.getInstanceIntState(null).getClass());
    }

    @Test
    public void shouldAssertEqualStringMockIntStateWithAFactoryInstanceIntState() throws LogException{
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);

        assertEquals(StringState.class, factory.getInstanceStringState(null).getClass());
    }

}



