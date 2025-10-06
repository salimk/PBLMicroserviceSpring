package com.rdvmedical.serviceguser.mapper;

import com.rdvmedical.serviceguser.domain.dto.patient.PatientCreateUpdateDto;
import com.rdvmedical.serviceguser.domain.dto.patient.PatientReadDto;
import com.rdvmedical.serviceguser.domain.entity.Patient;
import org.mapstruct.*;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleMapper.class})
public interface PatientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "roles",ignore = true)
    Patient toEntity(PatientCreateUpdateDto dto);

    @Mapping(target = "roles", source = "roles")
    PatientReadDto toReadDto(Patient patient);

    Set<PatientReadDto> toReadDtoSet(Set<Patient> patients);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    Patient partialUpdate(PatientCreateUpdateDto dto, @MappingTarget Patient patient);

}