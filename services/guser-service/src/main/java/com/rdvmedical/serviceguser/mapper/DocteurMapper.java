package com.rdvmedical.serviceguser.mapper;

import com.rdvmedical.serviceguser.domain.dto.docteur.DocteurCreateUpdateDto;
import com.rdvmedical.serviceguser.domain.dto.docteur.DocteurReadDto;
import com.rdvmedical.serviceguser.domain.dto.patient.PatientReadDto;
import com.rdvmedical.serviceguser.domain.entity.Docteur;
import com.rdvmedical.serviceguser.domain.entity.Patient;
import org.mapstruct.*;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleMapper.class})
public interface DocteurMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "roles",ignore = true)
    Docteur toEntity(DocteurCreateUpdateDto dto);

    @Mapping(target = "roles", source = "roles")
    DocteurReadDto toReadDto(Docteur docteur);

    Set<DocteurReadDto> toReadDtoSet(Set<Docteur> docteurs);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "roles", ignore = true)
    Docteur partialUpdate(DocteurCreateUpdateDto dto, @MappingTarget Docteur docteur);
}