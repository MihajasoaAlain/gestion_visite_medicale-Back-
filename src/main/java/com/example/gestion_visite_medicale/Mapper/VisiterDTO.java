package com.example.gestion_visite_medicale.Mapper;

import java.time.LocalDate;

import lombok.Data;
@Data
public class VisiterDTO {
    private Integer id;
    private Integer codemed;
    private Integer codepat;
    private LocalDate date;
}
