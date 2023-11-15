package com.horahena.proyecto3;

import java.util.Random;
import java.util.Scanner;

public class Punto3_2_Aereopuerto {
    static final int x = 30;
    static char ansx;
    static int[] fila = new int[x];

    public static void printInt(String name, int[] array, int size) {
        System.out.print(name + "\n[ ");
        for (int i = 0; i < size; i++) {
            if (array[i] == -1) {
                System.out.print("_ ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("]\n");
    }

    public static void control(int[] array, char ope, int size) {
        if (ope == 'f') {
            Random rand = new Random();
            int randNumIn = rand.nextInt(4) + 1;
            int randNumOut = rand.nextInt(2) + 1;

            if (randNumOut == 1) {
                for (int i = 0; i < size; i++) {
                    if (array[i] == -1) {
                        array[i] = randNumIn;
                        break;
                    }
                }
            } else if (randNumOut == 2) {
                if (array[0] != -1) {
                    for (int i = 0; i < size - 1; i++) {
                        array[i] = array[i + 1];
                    }
                    array[size - 1] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            fila[i] = -1;
        }
        if (true) {
            fila[0] = 4;
        }

        while (true) {
            printInt("Fila", fila, x);
            System.out.println("f | atender cliente");

            ansx = new Scanner(System.in).next().charAt(0);

            control(fila, ansx, x);
        }
    }
}

