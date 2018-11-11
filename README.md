# jvm-bench

Various benchmarks of doing things with the JVM.
Also comparing Java and Kotlin.

**Disclaimer**:

I'm just doing this, because im curious. 
Im no expert in Benchmarking.
If you see anything which distorts the results, tell me.

## Results

### Environment
* Intel i5-6500 @ 3.20 GHz
* Windows 10 1803
* JDK 11.0.1, Java HotSpot(TM) 64-Bit Server VM, 11.0.1+13-LTS

### List Filter

| Benchmark              | Ops/sec   |
|------------------------|----------:|
| Java removeIf          | 6 325 069 |
| Kotlin removeAll       | 4 478 253 |
| Kotlin Sequence        | 1 355 027 |
| Plain loop             | 1 334 449 |
| Kotlin List Extensions | 1 168 966 |
| Java Stream            | 1 145 021 |

### List processing with multiple steps

| Benchmark              | Ops/sec   |
|------------------------|----------:|
| Plain loop             | 1 217 348 |
| Java stream            | 1 076 868 |
| Kotlin Sequence        | 894 577   |
| Kotlin List Extensions | 786 765   |

### String Format

| Benchmark       | Ops/sec    |
|-----------------|-----------:|
| Concatenation   | 35 023 062 |
| Interpolation   | 34 998 727 |
| String Builder  | 34 913 428 |
| String.format() | 1 116 742  |

