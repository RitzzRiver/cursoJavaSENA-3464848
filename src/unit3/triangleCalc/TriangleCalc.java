package unit3.triangleCalc;

import java.util.Scanner;

public class TriangleCalc {
    public TriangleCalc() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese lado A:");
        int sideA = scanner.nextInt();
        System.out.println("Ingrese lado B:");
        int sideB = scanner.nextInt();
        System.out.println("Ingrese lado C:");
        int sideC = scanner.nextInt();

        System.out.println("Ingrese altura: ");
        int height = scanner.nextInt();

        try {
            Triangle triangle = new Triangle(sideA, sideB, sideC, height);

            System.out.println("------------------------------------------------------");
            System.out.println("El tipo de triangulo es: " + triangle.getType());
            System.out.println("los angulos del triangulo son:");
            System.out.println("A: " + triangle.getAngleA() + "°");
            System.out.println("B: " + triangle.getAngleB() + "°");
            System.out.println("C: " + triangle.getAngleC() + "°");
            System.out.println("el area del triangulo es: " + triangle.getArea());
            System.out.println("------------------------------------------------------");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new TriangleCalc();
    }
}