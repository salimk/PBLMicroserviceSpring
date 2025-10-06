package com.rdvmedical.serviceguser.mapper;

import com.rdvmedical.serviceguser.domain.dto.patient.PatientReadDto;
import com.rdvmedical.serviceguser.domain.dto.user.UserCreateUpdateDto;
import com.rdvmedical.serviceguser.domain.dto.user.UserReadDto;
import com.rdvmedical.serviceguser.domain.entity.Patient;
import com.rdvmedical.serviceguser.domain.entity.User;
import org.mapstruct.*;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {RoleMapper.class}
        )
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "roles",ignore = true)
    User toEntity(UserCreateUpdateDto Dto);

    @Mapping(target = "roles", source = "roles")
    UserReadDto toUserReadDto(User user);

    Set<UserReadDto> toReadDtoSet(Set<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserReadDto userReadDto, @MappingTarget User user);
}