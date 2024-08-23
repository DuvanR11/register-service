package org.example.infrastructure.web.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private String status;
    private int code;
    private T data;
    private String message;

    public ApiResponse(String status, int code, T data, String message) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.message = message;
    }
}
