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
    private final RevisionRepository revisionRepository;
    private final RevisionMapper revisionMapper;

    public RevisionService(RevisionRepository revisionRepository, RevisionMapper revisionMapper) {
        this.revisionRepository = revisionRepository;
        this.revisionMapper = revisionMapper;
    }

    public List<RevisionDto> getAllRevisions() {
        var revisions = revisionRepository.findAll();
        return revisionMapper.mapToDto(revisions);
    }

    public void deleteAllRevisions() {
        revisionRepository.deleteAll();
    }

    public RevisionDto addRevision(RevisionDto revisionDto) {
        Revision revision = revisionMapper.mapToEntity(revisionDto);
        revision = revisionRepository.save(revision);
        return revisionMapper.mapToDto(revision);
    }

    public RevisionDto getRevision(long revisionId) throws RevisionNotFoundException {
        Revision revision = findRevisionById(revisionId);
        return revisionMapper.mapToDto(revision);
    }

    public void updateRevision(long revisionId, RevisionDto revisionDto) throws RevisionNotFoundException {
        Revision revision = findRevisionById(revisionId);
        revisionMapper.updateEntity(revision, revisionDto);
    }

    public void deleteRevision(long revisionId) {
        revisionRepository.deleteById(revisionId);
    }

    private Revision findRevisionById(long revisionId) throws RevisionNotFoundException {
        return revisionRepository.findById(revisionId)
                .orElseThrow(() -> new RevisionNotFoundException(revisionId));
    }
}
