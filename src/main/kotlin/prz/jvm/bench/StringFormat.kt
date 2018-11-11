package prz.jvm.bench

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

open class StringFormat {
    @State(Scope.Benchmark)
    open class TestData {
        val value1 = "value1"
        val value2 = "value2"
    }

    @Benchmark
    fun stringFormat(data: TestData): String {
        return String.format("http://localhost:1234/path/%s?query=%s", data.value1, data.value2)
    }

    @Benchmark
    fun stringBuilder(data: TestData): String {
        return StringBuilder().append("http://localhost:1234/path/")
                .append(data.value1)
                .append("?query=")
                .append(data.value2)
                .toString()
    }

    @Benchmark
    fun stringConcat(data: TestData): String {
        return "http://localhost:1234/path/" + data.value1 + "?query=" + data.value2
    }

    @Benchmark
    fun stringInterpolation(data: TestData): String {
        return "http://localhost:1234/path/${data.value1}?query=${data.value2}"
    }
}
