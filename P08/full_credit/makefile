CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto"\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

hello: hello.cpp
	-$(CXX) $(CXXFLAGS) -o hello hello.cpp
	@printf "Now type ./hello to execute the result\n\n"

hello_all: hello_all.cpp
	-$(CXX) $(CXXFLAGS) -o hello_all hello_all.cpp
	@printf "Now type ./hello_all to execute the result\n\n"

all:  hello hello_all

clean:
	rm -f *.o *.gch a.out  hello hello_all