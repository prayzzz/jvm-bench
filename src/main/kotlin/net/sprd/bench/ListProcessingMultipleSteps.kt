package net.sprd.bench

import org.openjdk.jmh.annotations.*
import java.util.stream.Collectors

@Warmup(iterations = 2, time = 2)
@Measurement(iterations = 2, time = 2)
@Fork(value = 2)
open class ListProcessingMultipleSteps {

    @State(Scope.Benchmark)
    open class TestData {
        internal val list = listOf(0..99).flatten()
    }

    @Benchmark
    fun kotlinLib(l: TestData) {
        l.list.filter { it % 2 == 0 }.map { it + 1 }
    }

    @Benchmark
    fun kotlinSeq(l: TestData) {
        l.list.asSequence().filter { it % 2 == 0 }.map { it + 1 }.toList()
    }

    @Benchmark
    fun javaStream(l: TestData) {
        l.list.stream().filter { it % 2 == 0 }.map { it + 1 }.collect(Collectors.toList())
    }

    @Benchmark
    fun loop(l: TestData) {
        val r = mutableListOf<Int>()
        for (i in l.list) {
            if (i % 2 == 0) {
                r.add(i + 1)
            }
        }
    }
}