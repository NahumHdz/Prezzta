/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenoreste.rest.ResponseDTO;

/**
 *
 * @author wilmer
 */
public class InfoClienteDTO {
    private String message;
    private Integer code;
    private dataDTO data;

    public InfoClienteDTO() {
    }

    public InfoClienteDTO(String message, Integer code, dataDTO data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public dataDTO getData() {
        return data;
    }

    public void setData(dataDTO data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "InfoClienteDTO{" + "message=" + message + ", code=" + code + ", data=" + data + '}';
    }
    
    
    
}
