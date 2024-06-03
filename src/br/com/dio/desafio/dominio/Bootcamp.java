package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Bootcamp {
    private String name;
    private String description;
    private final LocalDate beginDate = LocalDate.now();
    private final LocalDate finalDate = beginDate.plusDays(45);
    private Set<Dev> devsEnrolled = new HashSet<>();
    private Set<Subject> contents = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public Set<Dev> getDevsEnrolled() {
        return devsEnrolled;
    }

    public void setDevsEnrolled(Set<Dev> devsEnrolled) {
        this.devsEnrolled = devsEnrolled;
    }

    public Set<Subject> getContents() {
        return contents;
    }

    public void setContents(Set<Subject> contents) {
        this.contents = contents;
    }

    public void addContent(Subject content) {
        contents.add(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(name, bootcamp.name) &&
                Objects.equals(description, bootcamp.description) &&
                Objects.equals(beginDate, bootcamp.beginDate) &&
                Objects.equals(finalDate, bootcamp.finalDate) &&
                Objects.equals(devsEnrolled, bootcamp.devsEnrolled) &&
                Objects.equals(contents, bootcamp.contents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, beginDate, finalDate, devsEnrolled, contents);
    }
}
