package com.akita.moa.desk.entity;

import lombok.Data;

import java.util.List;

@Data
public class WebappSet {
    private String category;

    private List<Webapp> webapps;
}
