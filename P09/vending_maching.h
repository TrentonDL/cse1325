#include <iostream>
#include <string>
#include <vector>

class vending_machine {
    public:
        void add(std::string name, int price);
        void buy(int index);
        std::string menu();
    private:
        std::vector<int>* Items;
}