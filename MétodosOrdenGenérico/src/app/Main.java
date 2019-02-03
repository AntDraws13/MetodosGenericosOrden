package app;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author ant
 */

public class Main {

    public static Integer[] aInt;
    public static Double[] aDouble;
    public static String[] aString;
    public static Scanner in = new Scanner(System.in);
    public static Arreglo arreglo;

    public static void main(String[] args) {
        Menu();
    }

    public static long startTime, duration;

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
                fillDouble(0, 1000);
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
        System.out.println("" +
                "\nSeleccione un método de Ordenamiento: \n1.- CocktailSort (Ant & Mónica) " +
                "\n2.- HeapSort (Moreno & Gonzáles) \n3.- InsertionSort (Garfio & Leura) \n4.- ShellSort (Vega & Vidal)" +
                "\n5.- QuickSort (Iván & Simón) \n6.- CombSort (Cristian & Leo) \n7.- GnomeSort (Meza & Arriaga) " +
                "\n8.- MergeSort (Juárez & López) \n9.- CycleSort (Richie & Picasso)\n10.- PancakeSort (Frías & Victor) " +
                "\n11.- Ejecutar todos");
        switch (in.nextInt()) {
            case 1:
                startTime = System.currentTimeMillis();
                arreglo.CocktailSort();
                Print(arreglo);
                duration = System.currentTimeMillis() - startTime;
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 2:
                startTime = System.currentTimeMillis();
                arreglo.HeapSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 3:
                startTime = System.currentTimeMillis();
                arreglo.InsertionSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 4:
                startTime = System.currentTimeMillis();
                arreglo.ShellSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 5:
                startTime = System.currentTimeMillis();
                arreglo.QuickSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 6:
                startTime = System.currentTimeMillis();
                arreglo.CombSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 7:
                startTime = System.currentTimeMillis();
                arreglo.GnomeSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 8:
                startTime = System.currentTimeMillis();
                arreglo.MergeSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 9:
                startTime = System.currentTimeMillis();
                arreglo.CycleSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 10:
                startTime = System.currentTimeMillis();
                arreglo.PancakeSort();
                duration = System.currentTimeMillis() - startTime;
                Print(arreglo);
                System.out.println("\nEste método tomó: " + duration + " milisegundos.");
                break;
            case 11:
                DoAll();
                break;
            default:
                Menu();
                break;
        }
    }

    public static void DoAll() {
        System.out.println("Cocktail Sort (Ant & Mónica)");
        startTime = System.currentTimeMillis();
        arreglo.CocktailSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nHeapSort (Moreno & Gonzáles)");
        startTime = System.currentTimeMillis();
        arreglo.HeapSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nInsertionSort (Garfio & Leura)");
        startTime = System.currentTimeMillis();
        arreglo.InsertionSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nShellSort (Vega & Vidal)");
        startTime = System.currentTimeMillis();
        arreglo.ShellSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nQuickSort (Iván & Simón)");
        startTime = System.currentTimeMillis();
        arreglo.QuickSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nCombSort (Cristian & Leo)");
        startTime = System.currentTimeMillis();
        arreglo.CombSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nGnomeSort (Meza & Arriaga)");
        startTime = System.currentTimeMillis();
        arreglo.GnomeSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nMergeSort (Juárez & López)");
        startTime = System.currentTimeMillis();
        arreglo.MergeSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nCycleSort (Richie & Picasso)");
        startTime = System.currentTimeMillis();
        arreglo.CycleSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        System.out.println("\nPanCakeSort (Frías & Víctor)");
        startTime = System.currentTimeMillis();
        arreglo.PancakeSort();
        duration = System.currentTimeMillis() - startTime;
        System.out.println("Este método tomó: " + duration + " milisegundos.");

        Print(arreglo);

    }

    public static void Print(Arreglo arreglo) {


        System.out.println("\nArreglo Desordenado: ");
        for (Object o : arreglo.getUnOrderedArr()) {
            System.out.print(o + ", ");
        }
        System.out.println();


        System.out.println("Arreglo Ordenado");
        for (Object e : arreglo.getArr()) {
            System.out.print(e + ", ");
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
