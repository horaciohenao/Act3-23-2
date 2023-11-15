#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;
const int x = 50;
char ansx;
int colaEspera[x];
int colaVIP[x];
int colaGeneral[x];
void printInt(string name, int* array, int size ) {
    cout << name<< endl << "[ ";
    for (int i = 0; i < size; i++){
        if(array[i]==-1) {
            cout << "_" << " ";
        } else {
            cout << array[i] << " ";
        }
    }
    cout << "]" << endl << endl;
}
void bubbleSort(int* array, int size) {
    int isize = 0;
    int temp = 0;
    for (int i = 0; i < size; i++) {
        if (array[i] == -1) {
            isize=i;
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
void control(int* array, char ope, int x, int type) {if ( ope == 'f' ){
        for (int i = 0; i < x; i++){
            if (array[0]==-1) {
                cout << "No hay llamdas en espera" << endl;
                return;
            }
            if (array[i]==-1) {
                if (array[i-1]>=3){
                    if (colaVIP[0]==-1) {
                        colaVIP[0]=array[i-1];
                        array[i-1]=-1;
                    } else {
                        for (int j = 0; j < x; j++){
                            if (colaVIP[j]==-1) {
                                colaVIP[j]=array[i-1];
                                array[i-1]=-1;
                            }
                        }
                    }
                } else {
                    if (colaGeneral[0]==-1) {
                        colaGeneral[0]=array[i-1];
                        array[i-1]=-1;
                    } else {
                        for (int j = 0; j < x; j++){
                            if (colaGeneral[j]==-1) {
                                colaGeneral[j]=array[i-1];
                                array[i-1]=-1;
                            }
                        }
                    }
                }
            }
            if (type==1||type==3){
                colaVIP[0]=-2;
            } 
            if (type==2||colaVIP[0]==-1){
                colaGeneral[0]=-2;
            }
        }
        cout << "Reasignada la ultima llamada a la cola correspondiente"<< endl;
    }
}
int main() {
    for ( int i = 0; i < x; i++){colaEspera[i] = -1;colaVIP[i] = -1;colaGeneral[i] = -1; }
    if(1==1) {
        colaEspera[0]=4;
    }
    // colaEspera[0]!=-1 && colaVIP[0]==-1 && colaGeneral[0]==-1
    while (true) {
        cout << "Introduzca la operacion a realizar"<<endl << "1 normal, 2 urgente, 3 VIP, 4 VIP urgente"<<endl<<endl;
        printInt("Espera",colaEspera, x);
        printInt("VIP",colaVIP, x);
        printInt("General",colaGeneral, x);
        cout << "f | recibir ultima llamada en cola y reasignar" << endl;
        cin >> ansx;
        int randNum = rand() % 3 + 1;
        control(colaEspera, ansx, x, randNum);
        bubbleSort(colaGeneral, x);
        bubbleSort(colaVIP, x);
        for ( int i = 0; i < x; i++){
            if(colaVIP[i]==-2){
                colaVIP[i] = -1;
                }
            if(colaGeneral[i]==-2){
                colaGeneral[i] = -1;
            }
        }
        randNum = rand() % 9 + 1;
        if(randNum<=5){cout << endl << "Hay una nueva llamada en la cola de espera: "<<randNum<<endl;}
        for (int i = 0; i < x; i++){
            if(randNum>=5) {
                break;
            }
            if(colaEspera[i]==-1) {
                colaEspera[i] = randNum;
                break;
            }
        }
    }
    cout << "No hay más llamadas en espera" << endl;
    return 0;
}
