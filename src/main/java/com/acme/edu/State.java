package com.acme.edu;

import com.acme.edu.Exception.DontPrintException;

public abstract class State {

    public abstract void log(String str)throws DontPrintException;

    public abstract  void flush()throws DontPrintException;
}



