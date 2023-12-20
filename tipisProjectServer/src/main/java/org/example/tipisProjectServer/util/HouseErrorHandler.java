package org.example.tipisProjectServer.util;

import lombok.Data;

@Data
public class HouseErrorHandler {
    private String msg;

    public HouseErrorHandler(String msg) {
        this.msg = msg;
    }
}
