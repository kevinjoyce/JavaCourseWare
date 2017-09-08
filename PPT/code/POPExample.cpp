#include <stdio.h>

void add(int x, int y);
void minus(int x, int y);
void multiply(int x, int y);
void divide(int x, int y);

int main(void){
	add(10, 5);
	minus(10, 5);
	multiply(10, 5);
	divide(10, 5);
	return 0;
} 
void add(int x, int y){
	printf("x + y = %d\n", x + y);
}
void minus(int x, int y){
	printf("x - y = %d\n", x - y);
}
void multiply(int x, int y){
	printf("x * y = %d\n", x * y);
}
void divide(int x, int y){
	printf("x / y = %d\n", x / y);
}
