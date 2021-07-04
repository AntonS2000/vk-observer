package me.weldnor.service;

import lombok.extern.slf4j.Slf4j;
import me.weldnor.dto.RevisionDto;
import me.weldnor.entity.Revision;
import me.weldnor.exception.RevisionNotFoundException;
import me.weldnor.mapper.RevisionMapper;
import me.weldnor.repository.RevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RevisionService {
    private final RevisionRepository RevisionRepository;
    private final me.weldnor.mapper.RevisionMapper RevisionMapper;

    public RevisionService(RevisionRepository RevisionRepository, RevisionMapper RevisionMapper) {
        this.RevisionRepository = RevisionRepository;
        this.RevisionMapper = RevisionMapper;
    }

    public List<RevisionDto> getAllRevisions() {
        var revisions = RevisionRepository.findAll();
        return RevisionMapper.mapToDto(revisions);
    }

    public void deleteAllRevisions() {
        RevisionRepository.deleteAll();
    }

    public RevisionDto addRevision(RevisionDto revisionDto) {
        Revision revision = RevisionMapper.mapToEntity(revisionDto);
        revision = RevisionRepository.save(revision);
        return RevisionMapper.mapToDto(revision);
    }

    public RevisionDto getRevision(long revisionId) throws RevisionNotFoundException {
        Revision revision = findRevisionById(revisionId);
        return RevisionMapper.mapToDto(revision);
    }

    public void updateRevision(long revisionId, RevisionDto revisionDto) throws RevisionNotFoundException {
        Revision revision = findRevisionById(revisionId);
        RevisionMapper.updateEntity(revision, revisionDto);
    }

    public void deleteRevision(long revisionId) {
        RevisionRepository.deleteById(revisionId);
    }

    private Revision findRevisionById(long revisionId) throws RevisionNotFoundException {
        return RevisionRepository.findById(revisionId)
                .orElseThrow(() -> new RevisionNotFoundException(revisionId));
    }
}
