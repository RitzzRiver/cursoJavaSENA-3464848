package unit3.triangleCalc;

public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;
    private double angleA;
    private double angleB;
    private double angleC;
    private int height;

    public enum TriangleType {EQUILATERO, ISOSCELES, ESCALENO}

    public Triangle(int sideA, int sideB, int sideC, int height) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
        validate();
        calcAngles();
    }

    private void validate() {
        if ((sideA + sideB <= sideC) || (sideA + sideC <= sideB) || (sideB + sideC <= sideA)) {
            throw new IllegalArgumentException("Los lados no forman un triangulo valido");
        }
    }

    private TriangleType determineType() {
        if (sideA == sideB && sideB == sideC) return TriangleType.EQUILATERO;
        else if ((sideA == sideB) || (sideA == sideC) || (sideB == sideC))
            return TriangleType.ISOSCELES;
        else return TriangleType.ESCALENO;
    }

    public void calcAngles() {
        switch (determineType()) {
            case EQUILATERO -> angleA = angleB = angleC = 60;
            case ISOSCELES, ESCALENO -> {
                angleA = calcCosTheoremAngle(sideA, sideB, sideC);
                angleB = calcCosTheoremAngle(sideB, sideA, sideC);
                angleC = calcCosTheoremAngle(sideC, sideA, sideB);
            }
        }
    }

    private double calcCosTheoremAngle(double sideA, double sideB, double sideC) {
        double value = (Math.pow(sideB, 2) + Math.pow(sideC, 2) - Math.pow(sideA, 2)) / (2 * sideB * sideC);
        value = Math.max(-1, Math.min(1, value));
        return Math.toDegrees(Math.acos(value));
    }

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    public TriangleType getType() {
        return determineType();
    }

    public double getArea() {
        return (double) (sideA * height) / 2.0;
    }
}
