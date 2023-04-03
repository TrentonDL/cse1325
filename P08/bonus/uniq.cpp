#include <iostream>
#include <string>
#include <sstream>

int main(int args, char* argv[]){
    std::string s;
    std::stringstream ss;
    std::string s1;
    std::string s2;
    int count = 0;
    s2 = argv[count];

    while(s2.compare(NULL) == 0){
        if(s2.compare(s1) == 1)
            s2 = argv[++count];
        else if(s2.compare(s1) == 0){
            ss << s2;
            s1 = s2;
            s2 = argv[++count];
        }
    }

    ss >> s;
    std::cout << s;
    
}