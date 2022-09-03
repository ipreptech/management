package com.ipreptech.management.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ErrorMessage {

    private int status;
    private String message;
    private String detailMessage;
    private long timeStamp;
}
