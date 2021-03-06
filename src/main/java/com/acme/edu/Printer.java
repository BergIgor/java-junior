package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

/**
 * Interface Printer with one method print()
 */
public interface Printer {

   void print(String message) throws DontPrintException;
}
