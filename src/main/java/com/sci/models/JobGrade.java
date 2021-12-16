package com.sci.models;

public class JobGrade {
    private String GradeLevel;
    private int lowestSalary;
    private int highstSalary;
    public String getGradeLevel() {
        return GradeLevel;
    }
    public void setGradeLevel(String gradeLevel) {
        GradeLevel = gradeLevel;
    }
    public int getLowestSalary() {
        return lowestSalary;
    }
    public void setLowestSalary(int lowestSalary) {
        this.lowestSalary = lowestSalary;
    }
    public int getHighstSalary() {
        return highstSalary;
    }
    public void setHighstSalary(int highstSalary) {
        this.highstSalary = highstSalary;
    }
    @Override
    public String toString() {
        return "Jobgrades [GradeLevel=" + GradeLevel + ", highstSalary=" + highstSalary + ", lowestSalary="
                + lowestSalary + "]";
    }
    
}
