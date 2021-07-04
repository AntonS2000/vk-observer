package me.weldnor.mapper;

import me.weldnor.dto.TrackedUserDto;
import me.weldnor.entity.TrackedUser;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface TrackedUserMapper {
    TrackedUser mapToEntity(TrackedUserDto dto);

    void updateEntity(@MappingTarget TrackedUser entity, TrackedUserDto dto);

    List<TrackedUserDto> mapToDto(List<TrackedUser> entities);

    TrackedUserDto mapToDto(TrackedUser entity);
}
