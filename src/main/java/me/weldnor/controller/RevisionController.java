package me.weldnor.controller;

import me.weldnor.dto.RevisionDto;
import me.weldnor.exception.RevisionNotFoundException;
import me.weldnor.service.RevisionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trackedRevision")
public class RevisionController {

    private final RevisionService revisionService;

    public RevisionController(RevisionService revisionService) {
        this.revisionService = revisionService;
    }

    @GetMapping
    public List<RevisionDto> getAllRevisions() {
        return revisionService.getAllRevisions();
    }

    @PostMapping
    public RevisionDto addRevision(@RequestBody RevisionDto revisionDto) {
        return revisionService.addRevision(revisionDto);
    }

    @DeleteMapping
    public void deleteAllRevisions() {
        revisionService.deleteAllRevisions();
    }

    @GetMapping("/{revisionId}")
    public RevisionDto getRevision(@PathVariable long revisionId) throws RevisionNotFoundException {
        return revisionService.getRevision(revisionId);
    }

    @PutMapping("/{revisionId}")
    public void updateRevision(@PathVariable long revisionId, @RequestBody RevisionDto revisionDto) throws RevisionNotFoundException {
        revisionService.updateRevision(revisionId, revisionDto);
    }

    @DeleteMapping("/{revisionId}")
    public void deleteRevision(@PathVariable long revisionId) {
        revisionService.deleteRevision(revisionId);
    }
}
