#include <iostream>
#include <string>
#include <fstream>

using namespace std;

int max(int num1, int num2){
    if(num1 > num2){
        return num1;
    }else{
        return num2;
    }
}

void checkTop(int * top, int calories){
    if(top[0] < calories){
        top[2] = top[1];
        top[1] = top[0];
        top[0] = calories;
    }else if(top[1] < calories){
        top[2] = top[1];
        top[1] = calories;
    }else if(top[2] < calories){
        top[2] = calories;
    }
}

void day1(int &maxCalories, string fileName, int * top){
    fstream file;
    //file.open("Prueba.txt", ios::in); 
    file.open(fileName, ios::in);
    string line;
    int contCalories;
    
    do{
        getline(file, line);
        if(line == ""){
            maxCalories = max(maxCalories, contCalories);
            checkTop(top, contCalories);
            contCalories = 0;
        }else{
            contCalories += stoi(line);
        }
    }while(file.peek() != EOF);
}

int main(){
    int maxCalories = 0;
    int topCalories[3] = {0,0,0};
    day1(maxCalories, "Day1.txt", topCalories);

    cout << "MAX: " << maxCalories<<endl;
    cout << "TOP in total: " << topCalories[0] + topCalories[1] + topCalories[2];

    return 0;
}