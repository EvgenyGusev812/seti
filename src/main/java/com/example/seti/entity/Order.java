package com.example.seti.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Order {

    private Long id;

    private String label;

    private Long amount;

    private String description;

    private Date date;

}
