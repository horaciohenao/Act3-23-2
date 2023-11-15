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

void insertionSort(int* array, int size) {
    int cache = 0;
    int isize = 0;

    cout << "\n== Estos son tus valores == \n\n";
    
    for (int i = 0; i < size; i++) {
        if (array[i] == -1) {
            break;
        }
        cout << array[i] << "    ";
        isize++;
    }

    cout << "\n\n== Ordenando (InsertionSort)... ==\n\n";

    for (int i = 1; i < isize; i++) {
        cache = array[i];
        int j = i - 1;

        while (j >= 0 && array[j] > cache) {
            array[j + 1] = array[j];
            j = j - 1;
        }

        array[j + 1] = cache;

        for (int k = 0; k < isize; k++) {
            cout << array[k] << "    ";
        }
        cout << endl;
    }
    
    cout << "\n== Estos son tus valores ordenados == \n\n";
    
    for (int i = 0; i < isize; i++) {
        cout << array[i] << "    ";
    }
    cout << endl << endl;
}

void selectionSort(int* array, int size) {
    int cache = 0;
    int isize = 0;
    
    cout << "\n== Estos son tus valores == \n\n";
    
    for (int i = 0; i < size; i++) {
        if (array[i] == -1) {
            break;
        }
        cout << array[i] << "    ";
        isize++;
    }

    cout << "\n\n== Ordenando (SelectionSort)... ==\n\n";

    for ( int i = 0; i < isize - 1; i++ ) {
        int minIndex = i;

        for ( int j = i + 1; j < isize; j++ ) {
            if ( array[j] < array[minIndex] ) {
                minIndex = j;
            }
        }

        if ( minIndex != i ) {
            cache = array[i];
            array[i] = array[minIndex];
            array[minIndex] = cache;
        }

        for (int k = 0; k < isize; k++) {
            cout << array[k] << "    ";
        }
        cout << endl;
    }
    
    cout << "\n== Estos son tus valores ordenados == \n\n";
    
    for (int i = 0; i < isize; i++) {
        cout << array[i] << "    ";
    }
    cout << endl << endl;
}

void control(int* array, char ope, int x, int type) {
    if ( ope == 'i' ){
        int ansx;
        cout << endl << "Ingrese el valor que desea introducir: ";
        if(ansx==-1){cout << endl << "Ese valor no se permite en este programa"<<endl;return;}
        cin >> ansx;
        for (int i = 0; i < x; i++){
            if(array[i]==-1) {
                array[i] = ansx;
                return;
            }
        }
    }
	else if ( ope == 'e' ){
        for (int i = 0; i < x-1; i++){
            array[i]=array[i+1];
        }
    }
	else if ( ope == 'b' ){
        int ansx;
        cout << "Ingrese un valor para buscar: ";
        cin >> ansx;
        for (int i = 0; i < x; i++){
            if(array[i]==ansx) {
                cout << "El valor esta en la posicion (primera coincidencia) " << i <<endl;
            return;
            }
        } 
        cout << "El valor no se encontro en la cola"<<endl;
    }
	else if ( ope == 't' ){
        for (int i = 0; i < x; i++){
            if(array[0]==0) {
                cout << "La cola esta vacia" <<endl;
                return;
            }
            if(array[i]==0) {
                cout << "El tamnño de la cola es " << i-1<<endl;
                return;
            }
        }
    }
	else if ( ope == 'a' ){
        int ansx;
        cout << "Ingrese una posicion para obtener el valor: ";
        cin >> ansx;
        
            if(array[ansx]!=-1) {
                cout << endl << "El valor en la posicion " << ansx <<" es:" <<  array[ansx] << endl;
            } else {
                cout << endl << "El valor en la posicion " << ansx <<" esta vacio" << endl;
            }
    }
	else if ( ope == 'f' ){
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
    else if (ope == 'u') {
        bubbleSort(array, x);
    }
    else if (ope == 'n') {
        insertionSort(array, x);
    }
    else if (ope == 'l') {
        selectionSort(array, x);
    }
    
}

int main() {

    for ( int i = 0; i < x; i++){colaEspera[i] = -1;colaVIP[i] = -1;colaGeneral[i] = -1; }
    
    if(1==1) {
        colaEspera[0]=4;
        colaEspera[1]=3;
        colaEspera[2]=4;
        colaEspera[3]=3;
        colaVIP[0]=3;
        colaVIP[1]=4;
        colaGeneral[0]=2;
        colaGeneral[1]=1;
        colaVIP[2]=4;
    }
    
    // colaEspera[0]!=-1 && colaVIP[0]==-1 && colaGeneral[0]==-1
    
    while (true) {
    
        cout << "Introduzca la operacion a realizar"<<endl;
        cout << "1 normal, 2 urgente, 3 VIP, 4 VIP urgente"<<endl<<endl;
    
        printInt("Espera",colaEspera, x);
        printInt("VIP",colaVIP, x);
        printInt("General",colaGeneral, x);
    
        /*cout << "i | insertar valor" << endl;
        cout << "e | eliminar valor" << endl;
        cout << "b | buscar valor" << endl;
        cout << "t | obtener tamano de la cola" << endl;*/
        cout << "f | recibir ultima llamada en cola y reasignar" << endl;/*
        cout << "a | acceder a un valor en una posicion" << endl<< endl;
        
        
        cout << "u | aplicar bubble sort" << endl;
        cout << "n | aplicar insertion sort" << endl;
        cout << "l | aplicar selection sort" << endl;*/
    
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
