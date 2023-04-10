#include "item.h"

Item::Item(std::string name, int price)
    : _name{name}, _price{price}{
    if (price < 0) throw std::runtime_error{"Invaild price"};
}

std::string Item::to_string() {
    float p = ((float)_price)/100;
    std::ostringstream ss;
    ss.precision(4);
    ss << p;
    return _name + " ($" + ss.str() + ")";
}