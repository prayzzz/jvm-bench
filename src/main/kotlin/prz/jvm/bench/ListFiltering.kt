package prz.jvm.bench

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import java.util.stream.Collectors

open class ListFiltering {

    @State(Scope.Benchmark)
    open class TestData {
        internal val divisor = 2
        internal val list = ArrayList(listOf(0..99).flatten())
    }

    @Benchmark
    fun kotlinLib(data: TestData): List<Int> {
        return data.list.filter { it % data.divisor == 0 }
    }

    @Benchmark
    fun kotlinSeq(data: TestData): List<Int> {
        return data.list.asSequence().filter { it % data.divisor == 0 }.toList()
    }

    @Benchmark
    fun javaStream(data: TestData): List<Int> {
        return data.list.stream().filter { it % data.divisor == 0 }.collect(Collectors.toList())
    }

    @Benchmark
    fun javaRemoveIf(data: TestData): Boolean {
        return data.list.removeIf { x -> x % data.divisor == 1 }
    }

    @Benchmark
    fun kotlinRemoveAll(data: TestData): Boolean {
        return data.list.removeAll { x -> x % data.divisor == 1 }
    }

    @Benchmark
    fun loop(data: TestData): List<Int> {
        val list = mutableListOf<Int>()
        for (i in data.list) {
            if (i % data.divisor == 0) {
                list.add(i)
            }
        }

        return list
    }
}
