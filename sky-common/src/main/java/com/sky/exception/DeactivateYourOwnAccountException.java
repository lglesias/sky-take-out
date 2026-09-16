package com.sky.exception;

/**
 * 禁止禁用自己的账号
 * ClassName: DeactivateYourOwnAccountException
 * Package: com.sky.exception
 * Description:
 *
 * @Author lglesias_
 * @Create 2026/9/15 18:18
 * @Version 1.0
 */
public class DeactivateYourOwnAccountException extends RuntimeException{
    public DeactivateYourOwnAccountException( ) {

    }
    public DeactivateYourOwnAccountException(String message) {
        super(message);
    }
}
