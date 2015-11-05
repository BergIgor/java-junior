package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

public interface Printer {
    void print(String message) throws DontPrintException;
}
