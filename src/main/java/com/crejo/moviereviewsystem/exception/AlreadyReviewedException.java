package com.crejo.moviereviewsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.FORBIDDEN)
public class AlreadyReviewedException extends Throwable {

    public AlreadyReviewedException(String msg){
        super(msg);
    }
}
