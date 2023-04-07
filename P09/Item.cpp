#include "item.h"
using namespace std;

Item::Item(string name, int price)
    : _name{name}, _price{price}{
    if (price < 0) throw runtime_error{"Invaild price"};
}
void Item::to_string(){
    cout << ") " << _name << " ($" << _price/100 << ")" << endl;
}

