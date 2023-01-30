package com.cubex.survey.v1.dto;

import com.mysql.cj.exceptions.StreamingNotifiable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private Boolean success;
    private String message;
    private Object data;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ApiResponse(boolean success, Object data, String message) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

}
