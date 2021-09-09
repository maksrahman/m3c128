package com.maks.classroster.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao {

    public static final String AUDIT_FILE = "src/main/java/com/maks/classroster/audit.txt";

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not persist audit information.", e);
        }

        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp + " : " + entry);
        out.flush();
    }

}
