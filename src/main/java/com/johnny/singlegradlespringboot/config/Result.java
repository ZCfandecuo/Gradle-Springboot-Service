package com.johnny.singlegradlespringboot.config;


public record Result (String errorMessage, Boolean result, Long total, Object data){

    public static Result ok(){return new Result(null, true,null,null);}
    public static Result fail(String errorMessage){return new Result(errorMessage, false, null, null);}
}
