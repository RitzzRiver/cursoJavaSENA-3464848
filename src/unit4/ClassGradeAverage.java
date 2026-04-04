package unit4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClassGradeAverage {
    private int quantity = 0;
    private double sum = 0;
    Scanner scanner;

    public ClassGradeAverage(Scanner scanner) {
        this.scanner = scanner;
    }

    private void maths() {
        System.out.println("Cuántos estudiantes va a registrar?");
        quantity = scanner.nextInt();

        for (int i = 1; i <= quantity; i++) {
            System.out.println("Ingrese nota del estudiante " + i + ":");
            sum += scanner.nextDouble();
        }

        System.out.println("Promedio de los estudiantes en matematicas: " + getGrade(sum));
        sum = 0;
    }

    private void spanish() {

        System.out.println("Cuántos estudiantes va a registrar?");
        quantity = scanner.nextInt();

        int i = 1;
        while (i <= quantity) {
            System.out.println("Ingrese nota del estudiante " + i + ":");
            sum += scanner.nextDouble();
            i++;
        }

        System.out.println("Promedio de los estudiantes en español: " + getGrade(sum));
        sum = 0;
    }

    private void english() {
        System.out.println("Cuántos estudiantes va a registrar?");
        quantity = scanner.nextInt();

        int i = 1;
        do {
            System.out.print("Ingrese nota del estudiante " + i + ":");
            sum += scanner.nextDouble();
            i++;
        } while (i <= quantity);

        System.out.println("Promedio de los estudiantes en inglés: " + getGrade(sum));
        sum = 0;
    }

    private double getGrade(double sum) {
        if (quantity != 0) return (sum / quantity);
        else throw new InputMismatchException();
    }

    private void showMenu() {
        System.out.println("Seleccione la materia a registrar:");
        System.out.println("1. Matemáticas");
        System.out.println("2. Español");
        System.out.println("3. Inglés");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassGradeAverage cga = new ClassGradeAverage(scanner);
        cga.showMenu();
        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> cga.maths();
                case 2 -> cga.spanish();
                case 3 -> cga.english();
                default -> throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada no valida");
        }

        scanner.close();
    }
}
