package com.spring.boot.jdbc.SpringBootJDBCProject.ErrorResponse;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(){
        super();
    }

    public PlayerNotFoundException(String msg,Throwable cause,boolean enableSuppresion,boolean writableStackTree){
        super(msg,cause,enableSuppresion,writableStackTree);
    }
    public PlayerNotFoundException(String msg,Throwable cause)
    {
        super(msg,cause);
    }
    public PlayerNotFoundException(String msg)
    {
        super(msg);
    }

    public PlayerNotFoundException(Throwable cause)
    {
        super(cause);
    }

}
