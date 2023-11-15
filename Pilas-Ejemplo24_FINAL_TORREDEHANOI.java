package com.horahena.proyecto3;

import java.util.Arrays;

public class Punto6 {
    public static void printInt(String txt, int[] array, int size) {
        System.out.print(txt);
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            if (array[i] == -1) {
                System.out.print("_ ");
            } else {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println("]\n");
    }

    public static void push(int[] array, int size, int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == -1) {
                array[i] = value;
                return;
            }
        }
    }

    public static void pop(int[] array, int size) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] != -1) {
                array[i] = -1;
                return;
            }
        }
    }

    public static int size(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            if (array[i] == -1) {
                return i;
            }
        }
        return size;
    }

    public static boolean empty(int[] array) {
        return (array[0] == -1);
    }

    public static int top(int[] array, int size) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i] != -1) {
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 5;
        int[] PilaA = new int[x];
        int[] PilaB = new int[x];
        int[] PilaC = new int[x];
        int temporal;

        Arrays.fill(PilaA, -1);
        Arrays.fill(PilaB, -1);
        Arrays.fill(PilaC, -1);

        push(PilaA, x, 3);
        push(PilaA, x, 2);
        push(PilaA, x, 1);

        while (size(PilaC, x) != 3) {
            printInt("Pila A", PilaA, x);
            printInt("Pila B", PilaB, x);
            printInt("Pila C", PilaC, x);
            System.out.println();

            if (!empty(PilaA)) {
                temporal = top(PilaA, x);
                pop(PilaA, x);

                if (temporal < top(PilaC, x) || empty(PilaC)) {
                    push(PilaC, x, temporal);
                } else if (temporal < top(PilaB, x) || empty(PilaB)) {
                    push(PilaB, x, temporal);
                } else {
                    push(PilaA, x, temporal);
                    temporal = top(PilaC, x);
                    pop(PilaC, x);

                    if (temporal < top(PilaB, x)) {
                        push(PilaB, x, temporal);
                    }
                }
            } else {
                temporal = top(PilaB, x);
                pop(PilaB, x);

                if (temporal < top(PilaC, x) || empty(PilaC)) {
                    push(PilaC, x, temporal);
                } else if (temporal < top(PilaA, x) || empty(PilaA)) {
                    push(PilaA, x, temporal);
                    temporal = top(PilaC, x);
                    pop(PilaC, x);
                    push(PilaB, x, temporal);
                    temporal = top(PilaA, x);
                    pop(PilaA, x);
                    push(PilaC, x, temporal);
                }
            }
        }

        printInt("Pila A", PilaA, x);
        printInt("Pila B", PilaB, x);
        printInt("Pila C", PilaC, x);
        System.out.println();

        System.out.println("Se han cambiado las pilas correctamente");
    }
}

