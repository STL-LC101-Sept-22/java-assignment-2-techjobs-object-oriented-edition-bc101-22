package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job{

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null)  return false;
        if (this.getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return job.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        // retrieve Job field values
        String name = this.getName() == "" || this.getName() == null ? "Data not available" : this.getName();

        String employer = this.getEmployer() == null || this.getEmployer().getValue() == "" ?
                "Data not available" : this.getEmployer().getValue();

        String location = this.getLocation() == null || this.getLocation().getValue() == "" ?
                "Data not available" : this.getLocation().getValue();

        String positionType = this.getPositionType() == null || this.getPositionType().getValue() == "" ?
                "Data not available" : this.getPositionType().getValue();

        String coreCompetency = this.getCoreCompetency() == null || this.getCoreCompetency().getValue() == "" ?
                "Data not available" : this.getCoreCompetency().getValue();

        // return customized string for an empty Job
        if (name ==  "Data not available" &&
                employer ==  "Data not available" &&
                location ==  "Data not available" &&
                positionType ==  "Data not available" &&
                coreCompetency ==  "Data not available") {
            return "OOPS! This job does not seem to exist.";
        }

        return String.format(
                "\n" +
                        "ID: %s\n" +
                        "Name: %s\n" +
                        "Employer: %s\n" +
                        "Location: %s\n" +
                        "Position Type: %s\n" +
                        "Core Competency: %s\n",
                this.getId(), name, employer, location, positionType, coreCompetency
        );
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
