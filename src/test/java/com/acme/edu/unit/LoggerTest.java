package com.acme.edu.unit;

import com.acme.edu.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;

public class LoggerTest {

    private Printer printer;
    //region given
    @Before
    public void setUp() throws IOException {
        printer = mock(Printer.class);
    }
    //endregion

    @Test
    public void shouldLogSumOfInt(){
        State state = new IntState(printer);
        state.log(String.valueOf(4));
        state.log(String.valueOf(0));
        state.log(String.valueOf(3));
        state.flush();

        verify(printer, times(1)).print("primitive: 7");
    }
    @Test
    public void shouldLogEmptyString() {
        State state = new StringState(printer);
        state.flush();

        verify(printer, times(0)).print("");
    }

    @Test
    public void shouldLogIfIntValueIsMax() {
        State state = new IntState(printer);
        state.log(String.valueOf(10));
        state.log(String.valueOf(Integer.MAX_VALUE));
        state.flush();

        verify(printer, times(1)).print("primitive: 10");
        verify(printer, times(1)).print("primitive: " + Integer.MAX_VALUE);
    }

    @Test
    public void shouldLogIfExistDuplication() {
        State state = new StringState(printer);
        state.log("str 1");
        state.log("str 1");
        state.log("str 1");
        state.flush();

        verify(printer, times(1)).print("string: str 1 (x3)");
    }

    @Test
    public void shouldLogIfIntegerOverFlow() {
        State state = new IntState(printer);
        state.log(String.valueOf(Integer.MAX_VALUE - 15));
        state.log(String.valueOf(17));
        state.flush();

        verify(printer, times(1)).print("primitive: " + (Integer.MAX_VALUE - 15));
    }

    @Test
    public void shouldLogNumberIfEmptyBuffer() {
        State state = new IntState(printer);
        state.log(String.valueOf(0));
        state.flush();

        verify(printer, times(1)).print("primitive: 0");
    }
}
