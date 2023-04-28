package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import classes.MemberRecord;
import classes.MemberReport;
import classes.ProviderReport;
import classes.WeeklyAccountingProcedure;

import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChaseUnitTesting {
    @Test
    public void memberReportFailure() {
        try {
            Path currentDir = Paths.get(".");
            System.out.println(currentDir.toAbsolutePath());
            WeeklyAccountingProcedure weeklyAccountingProcedure = new WeeklyAccountingProcedure();
            ArrayList<ProviderReport> providerReports = weeklyAccountingProcedure.requestProviderReport();
            assertTrue(providerReports != null);
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    } 
    @Test
    public void MemberReportSuccess() {
        try {
            MemberReport memberReport = new MemberReport();
            
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    @Test
    public void recordSuccess() {
        try {
            MemberRecord Record = new MemberRecord("Default","Default","Default","Default","Default","Default");
            assertEquals("Default", Record.getName());
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}