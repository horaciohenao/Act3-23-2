package com.horahena.proyecto3;

import java.util.Scanner;

public class Punto2 {

    public static void printInt(int[] array, int size) {
        System.out.print("\n[ ");
        for (int i = 0; i < size; i++) {
            if (array[i] == -345889306) {
                System.out.print("_ ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.print("]\n");
    }

    public static void bubbleSort(int[] array, int size) {
        int isize = 0;

        System.out.println("\n== Estos son tus valores == \n");
        for (int i = 0; i < size; i++) {
            if (array[i] == -345889306) {
                break;
            }
            System.out.print(array[i] + "    ");
            isize++;
        }

        System.out.println("\n\n== Ordenando (BubbleSort)... ==\n");

        for (int i = 0; i < isize - 1; i++) {
            for (int j = 0; j < isize - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            for (int k = 0; k < isize; k++) {
                System.out.print(array[k] + "    ");
            }
            System.out.println();
        }

        System.out.println("\n== Estos son tus valores ordenados == \n");
        for (int i = 0; i < isize; i++) {
            System.out.print(array[i] + "    ");
        }
        System.out.println("\n");
    }

    public static void insertionSort(int[] array, int size) {
        int cache = 0;
        int isize = 0;

        System.out.println("\n== Estos son tus valores == \n");
        for (int i = 0; i < size; i++) {
            if (array[i] == -345889306) {
                break;
            }
            System.out.print(array[i] + "    ");
            isize++;
        }

        System.out.println("\n\n== Ordenando (InsertionSort)... ==\n");

        for (int i = 1; i < isize; i++) {
            cache = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > cache) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = cache;

            for (int k = 0; k < isize; k++) {
                System.out.print(array[k] + "    ");
            }
            System.out.println();
        }

        System.out.println("\n== Estos son tus valores ordenados == \n");
        for (int i = 0; i < isize; i++) {
            System.out.print(array[i] + "    ");
        }
        System.out.println("\n");
    }

    public static void selectionSort(int[] array, int size) {
        int cache = 0;
        int isize = 0;

        System.out.println("\n== Estos son tus valores == \n");
        for (int i = 0; i < size; i++) {
            if (array[i] == -345889306) {
                break;
            }
            System.out.print(array[i] + "    ");
            isize++;
        }

        System.out.println("\n\n== Ordenando (SelectionSort)... ==\n");

        for (int i = 0; i < isize - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < isize; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                cache = array[i];
                array[i] = array[minIndex];
                array[minIndex] = cache;
            }

            for (int k = 0; k < isize; k++) {
                System.out.print(array[k] + "    ");
            }
            System.out.println();
        }

        System.out.println("\n== Estos son tus valores ordenados == \n");
        for (int i = 0; i < isize; i++) {
            System.out.print(array[i] + "    ");
        }
        System.out.println("\n");
    }

    public static void control(int[] array, char ope, int x) {
        if (ope == 'i') {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nIngrese el valor que desea introducir: ");
            int ansx = scanner.nextInt();
            if (ansx == -345889306) {
                System.out.println("\nEse valor no se permite en este programa\n");
                return;
            }
            for (int i = 0; i < x; i++) {
                if (array[i] == -345889306) {
                    array[i] = ansx;
                    return;
                }
            }
        // eliminar 
        } else if (ope == 'e') {
            for (int i = 0; i < x; i++) {
                if (array[i] == -345889306) {
                    array[i-1] = -345889306;
                    return;
                }
            }
        } else if (ope == 'b') {
            int ansx;
            System.out.print("Ingrese un valor para buscar: ");
            Scanner scanner = new Scanner(System.in);
            ansx = scanner.nextInt();
            for (int i = 0; i < x; i++) {
                if (array[i] == ansx) {
                    System.out.println("El valor esta en la posicion (primera coincidencia) " + i);
                    return;
                }
            }
            System.out.println("El valor no se encontro en la lista");
        } else if (ope == 't') {
            for (int i = 0; i < x; i++) {
                if (array[0] == 0) {
                    System.out.println("La lista esta vacia");
                    return;
                }
                if (array[i] == 0) {
                    System.out.println("El tamano de la lista es " + (i - 1));
                    return;
                }
            }
        } else if (ope == 'a') {
            int ansx;
            System.out.print("Ingrese una posicion para obtener el valor: ");
            Scanner scanner = new Scanner(System.in);
            ansx = scanner.nextInt();
            if (array[ansx] != -345889306) {
                System.out.println("\nEl valor en la posicion " + ansx + " es: " + array[ansx]);
            } else {
                System.out.println("\nEl valor en la posicion " + ansx + " esta vacio");
            }
        } else if (ope == 'u') {
            bubbleSort(array, x);
        } else if (ope == 'n') {
            insertionSort(array, x);
        } else if (ope == 'l') {
            selectionSort(array, x);
        }
    }

    public static void main(String[] args) {
        int x = 10;
        char ansx;

        int[] lista = new int[x];

        for (int i = 0; i < x; i++) {
            lista[i] = -345889306;
        }

        if (true) {
            lista[0] = 50;
            lista[1] = 23;
            lista[2] = -23;
            lista[3] = 0;
            lista[4] = 10;
            lista[5] = -5;
        }

        while (true) {
            System.out.println("Introduzca la operacion a realizar\n");

            printInt(lista, x);

            System.out.println("i | insertar valor");
            System.out.println("e | eliminar valor");
            System.out.println("b | buscar valor");
            System.out.println("t | obtener tamano de la lista");
            System.out.println("a | acceder a un valor en una posicion\n");
            System.out.println("u | aplicar bubble sort");
            System.out.println("n | aplicar insertion sort");
            System.out.println("l | aplicar selection sort");

            Scanner scanner = new Scanner(System.in);
            ansx = scanner.next().charAt(0);

            control(lista, ansx, x);
        }
    }
}