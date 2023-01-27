package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job1 instanceof Job);
        assertEquals(job1.getName(), "Product tester");

        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals(job1.getEmployer().getValue(), "ACME");

        assertTrue(job1.getLocation() instanceof Location);
        assertEquals(job1.getLocation().getValue(), "Desert");

        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals(job1.getPositionType().getValue(), "Quality control");

        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // jobs with the exactly identical fields but different id are not considered to be identical
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // test the string returned contains a blank line before the job information
        assertEquals(job1.toString().charAt(0), '\n');
        // contains a blank line after the job information
        assertEquals(job1.toString().charAt(job1.toString().length()-1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        String jobString = job.toString();

        // All fields except for id are hard-coded to the parameter provided in the constructor above
        assertEquals(jobString, String.format("\nID: %d\nName: Web Developer\nEmployer: LaunchCode\nLocation: St. Louis\nPosition Type: Front-end developer\nCore Competency: JavaScript\n", job.getId()));

        assertTrue(jobString.contains("ID: "));

        assertTrue(jobString.contains("Name: "));
        assertTrue(jobString.contains("Web Developer"));

        assertTrue(jobString.contains("Employer: "));
        assertTrue(jobString.contains("LaunchCode"));

        assertTrue(jobString.contains("Location: "));
        assertTrue(jobString.contains("St. Louis"));

        assertTrue(jobString.contains("Position Type: "));
        assertTrue(jobString.contains("Front-end developer"));

        assertTrue(jobString.contains("Core Competency: "));
        assertTrue(jobString.contains("JavaScript"));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job partialEmptyJob1 = new Job("Product tester", new Employer("ACME"),  new Location(""), new PositionType(""), new CoreCompetency(""));
        assertNotEquals(partialEmptyJob1.toString().indexOf("Data not available"), -1);
        // 3 empty fields - should be split into an array of length 4
        assertEquals(partialEmptyJob1.toString().split("Data not available").length, 4);

        // test the empty Job constructor - returns a Job object with all fields but id being null
        Job emptyJob1 = new Job();
        assertEquals(emptyJob1.toString(), "OOPS! This job does not seem to exist.");

        // test 5-parameter constructor with all parameters being empty strings
        Job emptyJob2 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(emptyJob2.toString(), "OOPS! This job does not seem to exist.");
    }
}
