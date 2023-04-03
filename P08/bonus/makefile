CXXFLAGS = --std=c++17

info:
	@echo
	@printf 'Type e.g., "make auto"  to create program "auto"\n'
	@printf 'Type       "make all"   to create every program\n'
	@printf 'Type       "make clean" to delete every program\n\n'

uniq: uniq.cpp
	-$(CXX) $(CXXFLAGS) -o uniq uniq.cpp
	@printf "Now type ./uniq to execute the result\n\n"

all:  uniq

clean:
	rm -f *.o *.gch a.out  uniq