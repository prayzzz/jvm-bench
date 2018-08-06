package net.sprd.bench

import org.openjdk.jmh.annotations.*
import java.util.stream.Collectors

@Warmup(iterations = 3, time = 5)
@Measurement(iterations = 3, time = 5)
@Fork(value = 2)
open class ListProcessingOneStep {

    @State(Scope.Benchmark)
    open class TestData {
        internal val list = listOf(0..99).flatten()
    }

    @Benchmark
    fun kotlinLib(l: TestData) {
        l.list.filter { it % 2 == 0 }
    }

    @Benchmark
    fun kotlinSeq(l: TestData) {
        l.list.asSequence().filter { it % 2 == 0 }.toList()
    }

    @Benchmark
    fun javaStream(l: TestData) {
        l.list.stream().filter { it % 2 == 0 }.collect(Collectors.toList())
    }

    @Benchmark
    fun loop(l: TestData) {
        val r = mutableListOf<Int>()
        for (i in l.list) {
            if (i % 2 == 0) {
                r.add(i)
            }
        }
    }
}
