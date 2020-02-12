#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

int isInteger(char* str) {
	if (*str == '-') {
		str++;
	}
	while (*str != '\0') {
		if (*str < '0' || *str > '9') {
			return 0;
		}
		str++;
	}
	return 1;
}

long fib(int n) {
	if (n <= 1) {
		return n;
	}
	
	long fib = 1;
	long prevFib = 1;
	
	long tmp;
	int i;
	for (i = 2; i < n; i++) {
		tmp = fib;
		fib += prevFib;
		prevFib = tmp;
	}
	
	return fib;
}

int main(int argc, char** argv) {
	int n = 10;
	
	int opt;
	while ((opt = getopt(argc, argv, "hn:")) != -1) {
		switch (opt) {
		case 'h':
			printf("Usage: %s [-n nonnegative_integer]\n", argv[0]);
			return EXIT_SUCCESS;
		case 'n':
			if (isInteger(optarg)) {
				int tmp = atoi(optarg);
				if (tmp >= 0) {
					n = tmp;
					break;
				} else {
					fprintf(stderr, "%d isn't a nonnegative integer!\n", tmp);
					return EXIT_FAILURE;
				}
			} else {
				fprintf(stderr, "%s isn't an integer!\n", optarg);
				return EXIT_FAILURE;
			}
		default:
			fprintf(stderr, "%s isn't a usable argument!", optarg);
			return EXIT_FAILURE;
		}
	}
	
	if (optind != argc) {
		fprintf(stderr, "Unusable argument found!\n");
		return EXIT_FAILURE;
	}
	
	time_t begin = time(NULL);
	long sum = fib(n);
	time_t end = time(NULL);
	
	printf("n: %d, sum: %u, seconds: %f\n", n, sum, difftime(end, begin));
}
