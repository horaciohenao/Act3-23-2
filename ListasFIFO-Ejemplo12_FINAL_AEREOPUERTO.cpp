#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

const int x = 30;
char ansx;
int fila[x];

void printInt(string name, int* array, int size) {
    cout << name << endl << "[ ";
    for (int i = 0; i < size; i++) {
        if (array[i] == -1) {
            cout << "_" << " ";
        } else {
            cout << array[i] << " ";
        }
    }
    cout << "]" << endl << endl;
}

void control(int* array, char ope, int size) {
    if (ope == 'f') {
        int randNumIn = rand() % 4 + 1;
        int randNumOut = rand() % 2 + 1;

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

int main() {
    srand(time(0));
    for (int i = 0; i < x; i++) {
        fila[i] = -1;
    }
    if (true) {
        fila[0] = 4;
    }

    while (true) {
        printInt("Fila", fila, x);
        cout << "f | atender cliente" << endl;

        cin >> ansx;
        int randNum = rand() % 4 + 1;

        control(fila, ansx, x);
    }

    cout << "No hay más clientes en espera" << endl;
    return 0;
}
