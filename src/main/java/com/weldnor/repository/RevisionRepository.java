package com.weldnor.repository;

import com.weldnor.model.Revision;

public interface RevisionRepository {
    void save(Revision revision);
}
