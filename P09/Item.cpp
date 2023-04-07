#include "item.h"
using namespace std;

Item::Item(string name, int price)
    : _name{name}, _price{price}{
    if (price < 0) throw runtime_error{"Invaild price"};
}
string Item::to_string() {
    float p = ((float)_price)/100;
    return _name + " ($" + p + ")";
}

