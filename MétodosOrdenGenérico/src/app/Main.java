package app;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static Integer[] aInt;
    public static Double[] aDouble;
    public static String[] aString;
    public static Scanner in = new Scanner(System.in);
    public static Arreglo arreglo;
    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        System.out.println("Ingrese la longitud del arreglo: ");
        int lenght = in.nextInt();
        System.out.println("Seleccione un tipo de random \n1.- Integer\n2.- Double\n3.- String");
        switch (in.nextInt()) {
            case 1:
                aInt = new Integer[lenght];
                fillInt(0, 1000);
                arreglo = new Arreglo(aInt);
                break;
            case 2:
                aDouble = new Double[lenght];
                fillDouble(0, 100);
                arreglo = new Arreglo(aDouble);
                break;
            case 3:
                aString = new String[lenght];
                fillString();
                arreglo = new Arreglo(aString);
                break;
            default:
                Menu();
                break;
        }
        System.out.println("\nSeleccione un método de Ordenamiento: \n1.- CocktailSort (Ant & Mónica) ");
        System.out.println("\n2.- Insertion (Carlos Garfio & Diana Leura) ");

        switch (in.nextInt()){
            case 1:
                long startTime = System.currentTimeMillis();
                arreglo.CocktailSort();
                long duration = System.currentTimeMillis() - startTime;
                //Print(arreglo);
                System.out.println("\nEste método tomó: "+duration+ " milisegundos.");
                break;
            case 2:
                duration=arreglo.Insercion();
                System.out.println("\nEste método tomó: "+(duration)+ " milisegundos.");
                break;
        }
    }

    public static void Print(Arreglo arreglo){
        System.out.println("\nArreglo desordenado: ");
        for (Object o : arreglo.getArr()){
            System.out.println(o);
        }
        System.out.println("\nArreglo ordenado");
        for (Object o : arreglo){
            System.out.println(o);
        }
    }

    public static void fillInt(int min, int max) {
        for (int i = 0; i < aInt.length; i++) {
            aInt[i] = ThreadLocalRandom.current().nextInt(min, max + 1);
        }
    }

    public static void fillDouble(int min, int max) {
        for (int i = 0; i < aDouble.length; i++) {
            aDouble[i] = ThreadLocalRandom.current().nextDouble(min, max + 1);
        }
    }

    public static void fillString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random;
        StringBuilder buffer;
        for (int h = 0; h < aString.length; h++) {
            random = new Random();
            buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            aString[h] = buffer.toString();
        }

    }
}
