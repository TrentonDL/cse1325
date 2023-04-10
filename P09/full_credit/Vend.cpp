#include "vending_machine.h"
#include "item.h"
using namespace std;

int main(){
    vending_machine* my_vm = new vending_machine;
    my_vm->add("Peanut Butter crackers", 186);
    my_vm->add("Oreos", 189);
    cout.precision(4);
    string menu = my_vm->menu();
    cout << menu << "\n";

    int input;
    cin >> input;

    my_vm->buy(input);
    cout << endl;
}