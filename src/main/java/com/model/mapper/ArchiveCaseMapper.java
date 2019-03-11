package com.model.mapper;

import com.model.ArchiveCase;

public interface ArchiveCaseMapper {
    int deleteByPrimaryKey(String id);

    int deleteByArchiveKey(String archiveId);

    int insert(ArchiveCase record);

    int insertSelective(ArchiveCase record);

    ArchiveCase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArchiveCase record);

    int updateByPrimaryKey(ArchiveCase record);

    int updateByArchiveIdByCaseId(ArchiveCase record);
}