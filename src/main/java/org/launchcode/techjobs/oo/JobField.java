package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    protected int id;
    protected static int nextId = 1;
    protected String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        JobField other = (JobField) o;
        return this.id == other.id;
    }

    @Override
    public int hashCode() { return Objects.hash(this.getId()); }

    @Override
    public String toString() {
        return this.value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
