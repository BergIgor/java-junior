package com.acme.edu.unit;

import com.acme.edu.*;
import com.acme.edu.Exception.DontPrintException;
import com.acme.edu.Exception.LogException;
import com.acme.edu.Exception.StateNullException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;
@Ignore
public class LoggerTest {

    private Printer printer;
    private static final String SEP = System.lineSeparator();
    //region given
    @Before
    public void setUp() throws IOException {
        printer = mock(ConsolePrinter.class);
    }
    //endregion

    @Test
    public void shouldLogSumOfInt() throws  DontPrintException,LogException{

        printer = mock(ConsolePrinter.class);
        State state = new IntState(printer);
        state.log("4");
        state.log("0");
        state.log("3");
        state.flush();

        verify(printer, times(1)).print("primitive: 7");
    }
    @Ignore
    @Test
    public void shouldntThrowsNullMessageExceptionForStringState() throws  LogException,DontPrintException{
        State state = new StringState(printer);

        state.log(null);
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
        state.log("space");
        state.log("str 2");
        state.log("str 2");
        state.flush();

        verify(printer, times(1)).print("string: str 1 (x3)");
        verify(printer, times(1)).print("string: space");
        verify(printer, times(1)).print("string: str 2 (x2)");
    }

    @Test
    public void shoudLogIfUseDefaultState() throws DontPrintException, LogException {
        State state  = new DefaultState(printer);
        state.log("char: a");
        state.log("primitive: boolean");
        state.log("char: b");
        state.flush();

        verify(printer).print("char: a");
        verify(printer).print("primitive: boolean");
        verify(printer).print("char: b");
    }

    ///
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
        state.log(new String());
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
    @Ignore
    @Test
    public void shouldVerifyThatThereWasCallOfGetInstanceIntStateMethodOfStateManagerClassIfUseLogger() throws  LogException {
        StateFactory factoryMock = mock(StateFactory.class);
        State state = mock(IntState.class);
        Logger logger = new Logger(printer);

        when(factoryMock.getInstanceIntState(anyObject())).thenReturn(state);

        logger.log(0);

        verify(factoryMock).getInstanceIntState(anyObject());
    }
    @Ignore
    @Test
    public void shouldVerifyThatThereWasCallOfGetStringStateMethodOfStateManagerClassIfUseLogger() throws  LogException {
        StateFactory factoryMock = mock(StateFactory.class);
        State state = mock(StringState.class);
        Logger logger = new Logger(printer);

        when(factoryMock.getInstanceStringState(anyObject())).thenReturn(state);

        logger.log("str 2");

        verify(factoryMock).getInstanceStringState(anyObject());
    }

    @Test(expected = LogException.class)
    public void shouldThrowExceptionIfTryLogArrayIntNull() throws  LogException {
        Logger logger = new Logger(printer);

        logger.log((int[])null);
    }

    @Test(expected = LogException.class)
    public void shouldThrowExceptionIfTryLogArrayStringNull() throws  LogException {
        Logger logger = new Logger(printer);

        logger.log((String[])null);
    }

    @Test
    public void shouldLogAsSumItemsOfArrayInteger() throws  LogException {
        Logger logger = new Logger(printer);
        logger.log(new int[]{3, 0, -2, 5});
        logger.close();

        verify(printer, times(1)).print("6");
    }

    @Test
    public void shouldLogIntegersMatrix() throws LogException {
        Logger logger = new Logger(printer);
        logger.log(new int[][]{{0}, {2, 2, 2}, {}});
        logger.close();

        verify(printer, times(1)).print("primitives matrix: {" + SEP +
                "{0}" + SEP +
                "{2, 2, 2}" + SEP +
                "{}" + SEP +
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
    public void shouldReturnIntStateIfTryToGetIntStateWithStateManagerGetMethodWithInputParametrIntState() throws LogException {
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);
        State intStub = mock(IntState.class);

        assertEquals(IntState.class, factory.getInstanceIntState(intStub).getClass());
    }

    @Test
    public void shouldReturnIntStateIfTryToGetIntStateWithStateManagerGetMethodWithInputParameterIsNull() throws LogException{
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);

        assertEquals(IntState.class, factory.getInstanceIntState(null).getClass());
    }

    @Test
    public void shouldReturnStringStateIfTryToGetStringStateWithStateManagerGetMethodWithInputParameterStringState() throws LogException {
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);
        State stringStub = mock(StringState.class);

        assertEquals(StringState.class, factory.getInstanceStringState(stringStub).getClass());
    }

    @Test
    public void shouldReturnStringStateIfTryToGetStringStateWithStateManagerGetMethodWithInputParameterIsNull() throws LogException{
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);

        assertEquals(StringState.class, factory.getInstanceStringState(null).getClass());
    }

    @Test
    public void shouldReturnIntStateIfTryToGetIntStateWithStateManagerGetMethodWithInputParameterStringState() throws LogException {
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);
        State stringStub = mock(StringState.class);

        assertEquals(IntState.class, factory.getInstanceIntState(stringStub).getClass());
    }

    @Test
    public void shouldReturnStringStateIfTryToGetStringStateWithStateManagerGetMethodWithInputParameterIntState() throws LogException {
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);
        State intStub = mock(IntState.class);

        assertEquals(StringState.class, factory.getInstanceStringState(intStub).getClass());
    }

    @Test
    public void shouldFlushIfStringStateNotEqualPreviousDefaultState() throws LogException {
        Printer mockprinter = mock(Printer.class);
        StateFactory factory = new StateFactory(mockprinter);
        State stringStub = mock(StringState.class);

        factory.getInstanceIntState(stringStub);

        verify(stringStub).flush();
    }


}



