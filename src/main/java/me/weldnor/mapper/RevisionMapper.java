package me.weldnor.mapper;

import me.weldnor.dto.RevisionDto;
import me.weldnor.entity.Revision;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface RevisionMapper {
    Revision mapToEntity(RevisionDto dto);

    @Mapping(target = "isOnline", source = "online")
    RevisionDto mapToDto(Revision entity);

    void updateEntity(@MappingTarget Revision entity, RevisionDto dto);

    List<RevisionDto> mapToDto(List<Revision> entities);
}
