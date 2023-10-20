package org.example.tipisProjectServer.util;

import lombok.Data;

@Data
public class HouseError {
    private String msg;

    public HouseError(String msg) {
        this.msg = msg;
    }
}
