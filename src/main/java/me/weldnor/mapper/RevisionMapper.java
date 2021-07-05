package me.weldnor.mapper;

import me.weldnor.dto.RevisionDto;
import me.weldnor.entity.Revision;
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
public interface RevisionMapper {
    Revision mapToEntity(RevisionDto dto);

    @SuppressWarnings("UnmappedTargetProperties")
        //FIXME
    RevisionDto mapToDto(Revision entity);

    void updateEntity(@MappingTarget Revision entity, RevisionDto dto);

    List<RevisionDto> mapToDto(List<Revision> entities);
}
