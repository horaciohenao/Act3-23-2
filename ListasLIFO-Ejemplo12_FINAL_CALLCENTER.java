package com.horahena.proyecto3;

import java.util.Random;
import java.util.Scanner;

public class Punto3_1_Callcenter {
    static int x = 10;
    static char ansx;
    static int[] colaEspera = new int[x];
    static int[] colaVIP = new int[x];
    static int[] colaGeneral = new int[x];

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

    public static void bubbleSort(int[] array, int size) {
        int isize = 0;
        int temp = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == -1) {
                isize = i;
                break;
            }
        }
        for (int i = 0; i < isize - 1; i++) {
            for (int j = 0; j < isize - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void control(int[] array, char ope, int x, int type) {
        if (ope == 'f') {
            for (int i = 0; i < x; i++) {
                if (array[0] == -1) {
                    System.out.println("No hay llamadas en espera");
                    return;
                }
                if (array[i] == -1) {
                    if (array[i - 1] >= 3) {
                        if (colaVIP[0] == -1) {
                            colaVIP[0] = array[i - 1];
                            array[i - 1] = -1;
                        } else {
                            for (int j = 0; j < x; j++) {
                                if (colaVIP[j] == -1) {
                                    colaVIP[j] = array[i - 1];
                                    array[i - 1] = -1;
                                }
                            }
                        }
                    } else {
                        if (colaGeneral[0] == -1) {
                            colaGeneral[0] = array[i - 1];
                            array[i - 1] = -1;
                        } else {
                            for (int j = 0; j < x; j++) {
                                if (colaGeneral[j] == -1) {
                                    colaGeneral[j] = array[i - 1];
                                    array[i - 1] = -1;
                                }
                            }
                        }
                    }
                }
                if (type == 1 || type == 3) {
                    colaVIP[0] = -2;
                }
                if (type == 2 || colaVIP[0] == -1) {
                    colaGeneral[0] = -2;
                }
            }
            System.out.println("Reasignada la ultima llamada a la cola correspondiente\n");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < x; i++) {
            colaEspera[i] = -1;
            colaVIP[i] = -1;
            colaGeneral[i] = -1;
        }

        if (true) {
            colaEspera[0] = 4;
            colaEspera[1] = 1;
        }

        Random rand = new Random();

        while (true) {
            System.out.println("Introduzca la operacion a realizar:");
            System.out.println("\n1 - Normal");
            System.out.println("2 - Urgente");
            System.out.println("3 - VIP");
            System.out.println("4 - VIP urgente\n");

            printInt("Espera", colaEspera, x);
            printInt("VIP", colaVIP, x);
            printInt("General", colaGeneral, x);

            System.out.println("f - Recibir ultima llamada en cola y reasignar");

            ansx = new Scanner(System.in).next().charAt(0);
            int randNum = rand.nextInt(3) + 1;

            control(colaEspera, ansx, x, randNum);
            bubbleSort(colaGeneral, x);
            bubbleSort(colaVIP, x);

            for (int i = 0; i < x; i++) {
                if (colaVIP[i] == -2) {
                    colaVIP[i] = -1;
                }
                if (colaGeneral[i] == -2) {
                    colaGeneral[i] = -1;
                }
            }

            randNum = rand.nextInt(7) + 1;

            if (randNum < 5) {
                System.out.println("\nHay una nueva llamada en la cola de espera: " + randNum);
            }

            for (int i = 0; i < x; i++) {
                if (randNum >= 5) {
                    break;
                }
                if (colaEspera[i] == -1) {
                    colaEspera[i] = randNum;
                    break;
                }
            }
        }
    }
}