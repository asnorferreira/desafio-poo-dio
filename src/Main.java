import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Course;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoring;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Course();
        course1.setTitle("Java Course");
        course1.setDescription("Java course description");
        course1.setWorkload(8);

        Course course2 = new Course();
        course2.setTitle("JavaScript Course");
        course2.setDescription("JavaScript course description");
        course2.setWorkload(4);

        Mentoring mentoring = new Mentoring();
        mentoring.setTitle("Java Mentoring");
        mentoring.setDescription("Java mentoring description");
        mentoring.setDate(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Java Developer Bootcamp");
        bootcamp.setDescription("Java Developer Bootcamp Description");
        bootcamp.getContents().add(course1);
        bootcamp.getContents().add(course2);
        bootcamp.getContents().add(mentoring);

        Dev devCamila = new Dev();
        devCamila.setName("Camila");
        devCamila.enrollInBootcamp(bootcamp);
        System.out.println("Enrolled Contents Camila: " + devCamila.getEnrolledContents());
        devCamila.progress();
        devCamila.progress();
        System.out.println("-");
        System.out.println("Enrolled Contents Camila: " + devCamila.getEnrolledContents());
        System.out.println("Completed Contents Camila: " + devCamila.getCompletedContents());
        System.out.println("XP: " + devCamila.calculateTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setName("Joao");
        devJoao.enrollInBootcamp(bootcamp);
        System.out.println("Enrolled Contents Joao: " + devJoao.getEnrolledContents());
        devJoao.progress();
        devJoao.progress();
        devJoao.progress();
        System.out.println("-");
        System.out.println("Enrolled Contents Joao: " + devJoao.getEnrolledContents());
        System.out.println("Completed Contents Joao: " + devJoao.getCompletedContents());
        System.out.println("XP: " + devJoao.calculateTotalXp());
    }
}
