#ifndef __ITEM_H
#define __ITEM_H

#include <iostream>
#include <string>
#include <exception>

class Item{
    public:
        Item(std::string name, int price);
        std::string to_string();
    private:
        std::string _name;
        int _price;
};

#endif