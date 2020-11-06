package ProjectEmployer.Entity;

import java.util.Objects;

public class EmplProj {
    private long employeeId;
    private long projectId;

    public EmplProj() {
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "EmplProj{" +
                "employeeId=" + employeeId +
                ", projectId=" + projectId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmplProj)) return false;
        EmplProj emplProj = (EmplProj) o;
        return getEmployeeId() == emplProj.getEmployeeId() &&
                getProjectId() == emplProj.getProjectId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getProjectId());
    }
}
