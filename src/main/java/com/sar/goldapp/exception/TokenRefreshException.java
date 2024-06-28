package com.sar.goldapp.exception;

public class TokenRefreshException extends Exception {

    public TokenRefreshException() {
        super("زمان حضور شما در سیستم به پایان رسیده است دوباره وارد شوید");
    }

}
