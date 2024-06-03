package br.com.dio.desafio.dominio;

import java.util.*;
import java.util.stream.Collectors;

public class Dev {
    private String name;
    private Set<Subject> enrolledContents = new LinkedHashSet<>();
    private Set<Subject> completedContents = new LinkedHashSet<>();

    public void enrollInBootcamp(Bootcamp bootcamp) {
        this.enrolledContents.addAll(bootcamp.getContents());
        bootcamp.getDevsEnrolled().add(this);
    }

    public void progress() {
        this.enrolledContents.stream().findFirst().ifPresentOrElse(content -> {
            this.completedContents.add(content);
            this.enrolledContents.remove(content);
        }, () -> {
            System.err.println("You are not enrolled in any content!");
        });
    }

    public double calculateTotalXp() {
        return this.completedContents.stream()
                .mapToDouble(Subject::calculateXp)
                .sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getEnrolledContents() {
        return enrolledContents;
    }

    public void setEnrolledContents(Set<Subject> enrolledContents) {
        this.enrolledContents = enrolledContents;
    }

    public Set<Subject> getCompletedContents() {
        return completedContents;
    }

    public void setCompletedContents(Set<Subject> completedContents) {
        this.completedContents = completedContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Dev dev = (Dev) o;
        return Objects.equals(name, dev.name) &&
                Objects.equals(enrolledContents, dev.enrolledContents) &&
                Objects.equals(completedContents, dev.completedContents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, enrolledContents, completedContents);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "name='" + name + '\'' +
                ", enrolledContents=" + enrolledContents.stream().map(Subject::getTitle).collect(Collectors.toList()) +
                ", completedContents=" + completedContents.stream().map(Subject::getTitle).collect(Collectors.toList())
                +
                '}';
    }
}
