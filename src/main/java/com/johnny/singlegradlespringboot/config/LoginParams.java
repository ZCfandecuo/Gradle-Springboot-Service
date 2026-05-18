package com.johnny.singlegradlespringboot.config;


public record LoginParams(String account, String code) {
private static String gender;

    public static void setGender(String gender) {
        LoginParams.gender = gender;
    }

    public static String getGender() {
        return gender;
    }

}
