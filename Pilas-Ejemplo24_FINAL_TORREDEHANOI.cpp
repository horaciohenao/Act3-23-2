#include <iostream>

using namespace std;

void printInt(string txt, int* array, int size) {
    cout << txt ;
    cout  << "[ ";
    for (int i = 0; i < size; i++) {
        if (array[i] == -1) {
            cout << "_" << " ";
        } else {
            cout << array[i] << " ";
        }
    }
    cout << "]" << endl << endl;
}

void push(int* array, int size, int value) {
    for (int i = 0; i < size; i++) {
        if (array[i] == -1) {
            array[i] = value;
            return;
        }
    }
}

void pop(int* array, int size) {
    for (int i = size - 1; i >= 0; i--) {
        if (array[i] != -1) {
            array[i] = -1;
            return;
        }
    }
}

int size(int* array, int size) {
    for (int i = 0; i < size; i++) {
        if (array[i] == -1) {
            return i;
        }
    }
    return size;
}

bool empty(int* array) {
    return (array[0] == -1);
}

int top(int* array, int size) {
    for (int i = size - 1; i >= 0; i--) {
        if (array[i] != -1) {
            return array[i];
        }
    }
}

int main() {
    int x = 5;
    int PilaA[x];
    int PilaB[x];
    int PilaC[x];
    int temporal;

    for (int i = 0; i < x; i++) {
        PilaA[i] = -1;
        PilaB[i] = -1;
        PilaC[i] = -1;
    }

    push(PilaA, x, 3);
    push(PilaA, x, 2);
    push(PilaA, x, 1);

    while (size(PilaC, x) != 3) {
        printInt("Pila A", PilaA, x);
        printInt("Pila B", PilaB, x);
        printInt("Pila C", PilaC, x);
        cout << endl;

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
    cout << endl;

    cout << "Se han cambiado las pilas correctamente" << endl;

    return 0;
}
