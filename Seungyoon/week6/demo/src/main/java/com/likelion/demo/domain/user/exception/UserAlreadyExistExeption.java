package com.likelion.demo.domain.user.exception;

import com.likelion.demo.global.exception.BaseException;

public class UserAlreadyExistExeption extends BaseException {
    public UserAlreadyExistExeption() {
        super(UserErrorCode.USER_ALREADY_EXIST_409);
    }
}
