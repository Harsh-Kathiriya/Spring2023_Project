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
            MemberReport memberReport = new MemberReport();
            memberReport.setMemberName("Jerry");
            assertFalse(memberReport.getMemberName() == "Frank");
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    } 
    @Test
    public void MemberReportSuccess() {
        try {
            MemberReport memberReport = new MemberReport();
            memberReport.setMemberName("Gerald");
            assertTrue(memberReport.getMemberName() == "Gerald");
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    @Test
    public void providerReportFailure() {
        try {
            ProviderReport providerReport = new ProviderReport();
            providerReport.setProviderCity("New York");
            assertFalse(providerReport.getProviderName() == "Chicago");
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    @Test
    public void providerReportSuccess() {
        try {
            ProviderReport providerReport = new ProviderReport();
            providerReport.setProviderName("Jerry");
            assertTrue(providerReport.getProviderName() == "Jerry");
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
    public void recordFailure() {
        try{
            MemberRecord Record = new MemberRecord("Default","Default","Default","Default","Default","Default");
            assertFalse(Record.getName()!="Default");
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
