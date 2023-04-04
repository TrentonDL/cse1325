#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main(int argc, char* argv[]){
    string previous{argv[1]};
    cout << previous << " ";

    for(int i = 2; i < argc; ++i){
        string current{argv[i]};
        if(current != previous){
            cout << current << " ";
        }
        previous = current;
    }

    cout << endl;
}