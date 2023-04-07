#include "vending_machine.h"
#include "item.h"
using namespace std;

void vending_machine::add(string name, int price){
    Item i{name, price};
    Items->push_back(i);
};
void vending_machine::buy(int idex){
    cout << "##### Buying " << Items[idex]::to_string();
};
string vending_machine::menu(){
    cout << "\n= = = = = = = = = = = = = =\nWelcome to UTA Vending\n= = = = = = = = = = = = = = =" << endl;
    int count = 0;
    for(Item i: *Items){
        cout << count << ") " << i.to_string() << endl;
        count++;
    }
};