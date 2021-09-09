package com.maks.classroster.dao;

public interface ClassRosterAuditDao {

    void writeAuditEntry(String entry) throws ClassRosterPersistenceException;

}
