#include <string>
#include <iostream>
using namespace std;

int main(){
    string name;
    cout << "What is your name? : ";
    getline(cin, name);
    cout << "Hello, " << name << "!" << endl;
}