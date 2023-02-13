package com.thommache.springboot.app.dto;


import org.json.JSONObject;

public class CalificacionesAlumnosDTO {


    public String code;
    public String message;
    public String description;
    public JSONObject details = new JSONObject();


    public CalificacionesAlumnosDTO(String code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    //    details = new JSONObject();

    }

    public CalificacionesAlumnosDTO(String code, String message, String description, JSONObject details) {
        this.code = code;
        this.message = message;
        this.description = description;
        this.details = details;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONObject getDetails() {
        return details;
    }

    public void setDetails(JSONObject details) {
        this.details = details;
    }
}
