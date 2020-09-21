package com.jackytest.demo.common;

/**
 * 服务器常类
 * @author JackyRoc
 * @date 2020/9/18 14:00
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String message;

    @Override
    public String getMessage(){ return message; }

    public void setMessage(String message){ this.message = message; }

    public ServiceException(final String message,Throwable th){
        super(message,th);
        this.message = message;
    }
    public ServiceException(final String message){ this.message = message; }

    public static void throwEx(String message) { throw new ServiceException(message); }
}
