package JDBC.ProjectEmployer.Entity;

import java.util.Objects;

public class Project extends Entity{

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public long getId() {
        return super.getId();
    }

    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return getId() == project.getId() &&
                Objects.equals(getTitle(), project.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle());
    }

    @Override
    public String
    toString() {
        return "Project{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                '}';
    }
}
