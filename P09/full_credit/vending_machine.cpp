#include "vending_machine.h"
#include "item.h"
using namespace std;

void vending_machine::add(string name, int price){
    Item * i = new Item{name, price};
    Items.push_back(i);
};
void vending_machine::buy(int index){
    cout << "##### Buying " << Items.at(index)->to_string();
};
string vending_machine::menu(){
    string s = "\n= = = = = = = = = = = = = =\nWelcome to UTA Vending\n= = = = = = = = = = = = = = =\n";
    int count = 0;
    for(Item * i: Items ){
        s += to_string(count) + ") " + i->to_string() + "\n";
        count++;
    }
    return s;
};