package com.weldnor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class Revision {
    private String userId;
    private Date date;
    private boolean isOnline;
}
