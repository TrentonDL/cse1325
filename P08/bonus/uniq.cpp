#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main(int args, char* argv[]){
    string s;
    string s1;
    string s2;
    int count = 0;
    s2 = argv[count];

    while(s2.empty()){
        if(s2.compare(s1) == 1)
            s2 = argv[++count];
        else if(s2.compare(s1) == 0){
            s.append(s2 + " ");
            s1 = s2;
            s2 = argv[++count];
        }
    }

    cout << s << endl;
}