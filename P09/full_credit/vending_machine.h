#ifndef __VENDING_MACHINE_H
#define __VENDING_MACHINE_H

#include <iostream>
#include <iomanip>
#include <string>
#include <vector>
#include "item.h"

class vending_machine {
    public:
        void add(std::string name, int price);
        void buy(int index);
        std::string menu();
    private:
        std::vector<Item*> Items;
};

#endif