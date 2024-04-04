import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final double PI = 3.1416;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tipoFigura, operacion = 0;
        boolean continuar = true;
        ArrayList<String> operacionesRealizadas = new ArrayList<>();
        ArrayList<Double> resultadosOperaciones = new ArrayList<>();

        while (continuar) {
            System.out.println("\n\n\t\t\tCalculadora Geométrica");
            System.out.println("\n\t\tOpciones de figuras geométricas: ");
            System.out.println("\n\t1. Círculo");
            System.out.println("\t2. Cuadrado");
            System.out.println("\t3. Triángulo");
            System.out.println("\t4. Rectángulo");
            System.out.println("\t5. Pentágono");
            System.out.println("\t6. Potencia");

            try {
                System.out.print("\n\n\tSeleccione el tipo de figura que desea calcular: ");
                tipoFigura = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                scanner.next(); // Limpia el búfer del scanner
                continue;
            }


            double[] resultados;
            String operacionRealizada;

            switch (tipoFigura) {

                case 1:
                    try {
                        System.out.print("\n\t\t¿Qué operación desea realizar? \n\n1. para medir Area \n2. para medir el perímetro\n ");
                        operacion = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                        scanner.next();
                        continue;
                    }
                    resultados = calcularCirculo(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Círculo" : "Perímetro de Círculo";
                    break;

                case 2:
                    try {
                        System.out.print("\n\t\t¿Qué operación desea realizar? \n\n1. para medir Area \n2. para medir el perímetro\n ");
                        operacion = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                        scanner.next(); // Limpia el búfer del scanner
                        continue;
                    }
                    resultados = calcularCuadrado(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Cuadrado" : "Perímetro de Cuadrado";
                    break;

                case 3:
                    try {
                        System.out.print("1\n\t\t¿Qué operación desea realizar? \n\n1. para medir Area \n2. para medir el perímetro\n ");
                        operacion = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                        scanner.next(); // Limpia el búfer del scanner
                        continue;
                    }
                    resultados = calcularTriangulo(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Triángulo" : "Perímetro de Triángulo";
                    break;

                case 4:
                    try {
                        System.out.print("\n\t\t¿Qué operación desea realizar? \n\n1. para medir Area \n2. para medir el perímetro\n ");
                        operacion = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                        scanner.next(); // Limpia el búfer del scanner
                        continue;
                    }
                    resultados = calcularRectangulo(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Rectángulo" : "Perímetro de Rectángulo";
                    break;

                case 5:
                    try {
                        System.out.print("\n\t\t¿Qué operación desea realizar? \n\n1. para medir Area \n2. para medir el perímetro\n ");
                        operacion = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                        scanner.next(); // Limpia el búfer del scanner
                        continue;
                    }
                    resultados = calcularPentagono(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Área de Pentágono" : "Perímetro de Pentágono";
                    break;

                case 6:
                    try {
                        System.out.print("\n\t\t¿Qué operación desea realizar? \n\n1. Incrementar a potencia\n" );
                        operacion = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                        scanner.next();
                        continue;
                    }
                    resultados = calcularPotencia(scanner, operacion);
                    operacionRealizada = operacion == 1 ? "Base" : "Potencia";
                    break;

                default:
                    System.out.println("\n\t\tOPCIÓN INVÁLIDA.");
                    continue;
            }

            if (resultados != null) {
                System.out.println("Resultado de " + operacionRealizada + ":");
                for (double resultado : resultados) {
                    System.out.printf("%.2f%n", resultado);
                    resultadosOperaciones.add(resultado);
                }
                operacionesRealizadas.add(operacionRealizada);
            }

            System.out.print("\n¿Desea realizar otra operación? (Si/No): ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("No")) {
                continuar = false;
            }
        }

        // Imprimir operaciones realizadas al final
        System.out.println("\n\nOperaciones realizadas:");
        for (int i = 0; i < operacionesRealizadas.size(); i++) {
            System.out.println(operacionesRealizadas.get(i) + ": " + String.format("%.2f", resultadosOperaciones.get(i)));
        }
    }

    public static double[] calcularCirculo(Scanner scanner, int operacion) {
        System.out.print("\n\t\tIngresa el radio del círculo: ");
        double radio = scanner.nextDouble();
        double resultado = 0;
        if (operacion == 1) {
            resultado = PI * radio * radio;
        } else {
            resultado = 2 * PI * radio;
        }
        return new double[]{resultado};
    }

    public static double[] calcularCuadrado(Scanner scanner, int operacion) {
        System.out.print("\n\t\tIngresa la longitud del lado del cuadrado: ");
        double lado = scanner.nextDouble();
        double resultado = 0;
        if (operacion == 1) {
            resultado = lado * lado;
        } else {
            resultado = 4 * lado;
        }
        return new double[]{resultado};
    }

    public static double[] calcularTriangulo(Scanner scanner, int operacion) {
        double resultado = 0;
        if (operacion == 1) {
            System.out.print("\n\t\tIngresa la base y la altura del triángulo (separados por un espacio): ");
            double base = scanner.nextDouble();
            double altura = scanner.nextDouble();
            resultado = 0.5 * base * altura;
        } else {
            System.out.print("\tIngresa la longitud de los tres lados del triángulo (separados por un espacio): ");
            double lado1 = scanner.nextDouble();
            double lado2 = scanner.nextDouble();
            double lado3 = scanner.nextDouble();
            resultado = lado1 + lado2 + lado3;
        }
        return new double[]{resultado};
    }

    public static double[] calcularRectangulo(Scanner scanner, int operacion) {
        double resultado = 0;
        if (operacion == 1) {
            System.out.print("\n\t\tIngresa la longitud y el ancho del rectángulo (separados por un espacio): ");
            double longitud = scanner.nextDouble();
            double ancho = scanner.nextDouble();
            resultado = longitud * ancho;
        } else {
            System.out.print("\tIngresa la longitud y el ancho del rectángulo (separados por un espacio): ");
            double longitud = scanner.nextDouble();
            double ancho = scanner.nextDouble();
            resultado = 2 * (longitud + ancho);
        }
        return new double[]{resultado};
    }

    public static double[] calcularPentagono(Scanner scanner, int operacion) {
        double resultado = 0;
        if (operacion == 1) {
            System.out.print("\n\t\tIngresa la longitud de un lado del pentágono: ");
            double lado = scanner.nextDouble();
            System.out.print("\n\t\tIngresa la longitud de la apotema del pentágono: ");
            double apotema = scanner.nextDouble();
            resultado = (5 * lado * apotema) / 2;
        } else {
            System.out.print("\tIngresa la longitud de un lado del pentágono: ");
            double lado = scanner.nextDouble();
            resultado = 5 * lado;
        }
        return new double[]{resultado};
    }

    public static double[] calcularPotencia(Scanner scanner, int operacion) {
        if (operacion == 1) {
            System.out.print("\n\t\tIngresa la base: ");
            double base = scanner.nextDouble();
            System.out.print("\n\t\tIngresa la potencia: ");
            double exponente = scanner.nextDouble();
            double resultado = Math.pow(base, exponente);
            return new double[]{resultado};
        }
        return null;
    }
}
