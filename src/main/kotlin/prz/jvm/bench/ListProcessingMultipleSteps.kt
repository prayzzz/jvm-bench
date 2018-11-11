package prz.jvm.bench

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import java.util.stream.Collectors

open class ListProcessingMultipleSteps {

    @State(Scope.Benchmark)
    open class TestData {
        internal val divisor = 2
        internal val summand = 1
        internal val list = listOf(0..99).flatten()
    }

    @Benchmark
    fun kotlinLib(data: TestData): List<Int> {
        return data.list.filter { it % data.divisor == 0 }.map { it + data.summand }
    }

    @Benchmark
    fun kotlinSeq(data: TestData): List<Int> {
        return data.list.asSequence().filter { it % data.divisor == 0 }.map { it + data.summand }.toList()
    }

    @Benchmark
    fun javaStream(data: TestData): List<Int>? {
        return data.list.stream().filter { it % data.divisor == 0 }.map { it + data.summand }.collect(Collectors.toList())
    }

    @Benchmark
    fun loop(data: TestData): List<Int> {
        val list = mutableListOf<Int>()
        for (i in data.list) {
            if (i % data.divisor == 0) {
                list.add(i + data.summand)
            }
        }

        return list
    }
}
