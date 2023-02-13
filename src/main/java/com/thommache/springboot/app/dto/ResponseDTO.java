package com.thommache.springboot.app.dto;




public class ResponseDTO {

    public String success;
   // public String message;

    public String msg;

  //  public JSONPObject details;

    public ResponseDTO(String code, String msg) {
        this.success = code;
       // this.message = message;
        this.msg = msg;
     //   details = new JSONPObject("OK","EXITOoooooooooooooo");
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }





    /*public JSONPObject getDetails() {
        return details;
    }

    public void setDetails(JSONPObject details) {
        this.details = details;
    }*/
}
