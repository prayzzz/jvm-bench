param ([String]$Class = "")

# wi - Warmup Iterations: 5
# w  - Warump Time: 5s
# i  - Benchmark Iterations: 5
# f  - Forks 1

java -jar target/benchmarks.jar $Class -wi 5 -w 5 -i 5 -f 1