#include <iostream>

using namespace std;

void printInt(int* array, int size ) {
    cout << endl << "[ ";
    for (int i = 0; i < size; i++){
        if(array[i]==-345889306) {
            cout << "_" << " ";
        } else {
            cout << array[i] << " ";
        }
    }
    cout << "]" << endl << endl;
}

void bubbleSort(int* array, int size) {
    int isize = 0;
    
    cout << "\n== Estos son tus valores == \n\n";
    
    for (int i = 0; i < size; i++) {
        if (array[i] == -345889306) {
            break;
        }
        cout << array[i] << "    ";
        isize++;
    }

    cout << "\n\n== Ordenando (BubbleSort)... ==\n\n";

    for (int i = 0; i < isize - 1; i++) {

        for (int j = 0; j < isize - i - 1; j++) {

            if (array[j + 1] < array[j]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
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

void insertionSort(int* array, int size) {
    int cache = 0;
    int isize = 0;

    cout << "\n== Estos son tus valores == \n\n";
    
    for (int i = 0; i < size; i++) {
        if (array[i] == -345889306) {
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
        if (array[i] == -345889306) {
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

void control(int* array, char ope, int x) {
    if ( ope == 'i' ){
        int ansx;
        cout << endl << "Ingrese el valor que desea introducir: ";
        if(ansx==-345889306){cout << endl << "Ese valor no se permite en este programa"<<endl;return;}
        cin >> ansx;
        for (int i = 0; i < x; i++){
            if(array[i]==-345889306) {
                array[i] = ansx;
                return;
            }
        }
    }
	else if ( ope == 'e' ){
        for (int i = 0; i < x; i++){
            if(array[i]!=-345889306) {
                array[i] = -345889306;
                return;
            }
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
        cout << "El valor no se encontro en la lista"<<endl;
    }
	else if ( ope == 't' ){
        for (int i = 0; i < x; i++){
            if(array[0]==0) {
                cout << "La lista esta vacia" <<endl;
                return;
            }
            if(array[i]==0) {
                cout << "El tamnño de la lista es " << i-1<<endl;
                return;
            }
        }
    }
	else if ( ope == 'a' ){
        int ansx;
        cout << "Ingrese una posicion para obtener el valor: ";
        cin >> ansx;
        
            if(array[ansx]!=-345889306) {
                cout << endl << "El valor en la posicion " << ansx <<" es:" <<  array[ansx] << endl;
            } else {
                cout << endl << "El valor en la posicion " << ansx <<" esta vacio" << endl;
            }
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

    int x = 10000;
    char ansx;
    
    // cout << "Introduzca el tamano para la lista"<<endl;
    // cin >> x;

    int lista[x];

    for ( int i = 0; i < x; i++){lista[i] = -345889306; }
    
    if(1==1) {
        lista[0]=50;
        lista[1]=23;
        lista[2]=-23;
        lista[3]=0;
        lista[4] = 10;
        lista[5] = -5;
        lista[6] = 7;
        lista[7] = 42;
        lista[8] = -10;
        lista[9] = 15;
        lista[10] = 33;
        lista[11] = -8;
        lista[12] = 27;
    }

    while (true) {
    
    cout << "Introduzca la operacion a realizar"<<endl;

    // printarray(lista, x);

    cout << "i | insertar valor" << endl;
    cout << "e | eliminar valor" << endl;
    cout << "b | buscar valor" << endl;
    cout << "t | obtener tamano de la lista" << endl;
    cout << "a | acceder a un valor en una posicion" << endl<< endl;
    cout << "u | aplicar bubble sort" << endl;
    cout << "n | aplicar insertion sort" << endl;
    cout << "l | aplicar selection sort" << endl;

    cin >> ansx;

    control(lista, ansx, x);
        
    }
    
    return 0;
}
