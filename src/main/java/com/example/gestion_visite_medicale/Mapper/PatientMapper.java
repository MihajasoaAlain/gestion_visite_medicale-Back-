package com.example.gestion_visite_medicale.Mapper;


import com.example.gestion_visite_medicale.models.Patient;
import com.example.gestion_visite_medicale.models.Visiter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

    @Mapping(source = "codepat", target = "codepat")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "sexe", target = "sexe")
    @Mapping(source = "adresse", target = "adresse")
    PatientDTO toDto(Patient patient);

    @Mapping(source = "codepat", target = "codepat")
    @Mapping(source = "nom", target = "nom")
    @Mapping(source = "prenom", target = "prenom")
    @Mapping(source = "sexe", target = "sexe")
    @Mapping(source = "adresse", target = "adresse")
    Patient toEntity(PatientDTO patientDTO);
}
