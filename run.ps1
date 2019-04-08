param ([String]$Class)

# wi - Warmup Iterations: 5
# w  - Warump Time: 5s
# i  - Benchmark Iterations: 5
# f  - Forks 1

java -jar target/benchmarks.jar $Class -wi 5 -w 10 -i 10 -f 1