package se.distansakademin.songify.service;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    @XRayTimed(segmentName = "DatabaseQuery")
    public void executeQuery() {
// Kör dina databasanrop här
        System.out.println("Executing database query...");
    }
    @XRayTimed
    public void anotherDatabaseOperation() {
// Kör en annan databasoperation här
        System.out.println("Executing another database operation...");
    }
}
