package com.example.gestion_visite_medicale.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.gestion_visite_medicale.models.Visiter;

@Mapper(componentModel = "spring")
public interface VisiterMapper {

    VisiterMapper INSTANCE = Mappers.getMapper(VisiterMapper.class);

    @Mapping(source = "medecin.codemed", target = "codemed")
    @Mapping(source = "patient.codepat", target = "codepat")
    VisiterDTO toDto(Visiter visiter);

    @Mapping(source = "codemed", target = "medecin.codemed")
    @Mapping(source = "codepat", target = "patient.codepat")

    Visiter toEntity(VisiterDTO visiterDTO);
}
