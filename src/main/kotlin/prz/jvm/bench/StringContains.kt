package prz.jvm.bench

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

open class StringContains {

    @State(Scope.Benchmark)
    open class TestData {
        val names = listOf(
            "Ruth", "Lorri", "Milford", "Malorie", "Bridgette", "Freeman", "Ronna", "Nguyet", "Zaida",
            "Tanja", "Mohammad", "Lee", "Wei", "Deborah", "Lynelle", "Margarita", "Anissa", "Nadine"
        )
        val namesStr = names.joinToString(",")
        val searchNames = listOf("something", "notAvailable", "Zaida", "somethingElse")
    }

    @Benchmark
    fun indexOfAny(data: TestData): Int {
        return data.namesStr.indexOfAny(data.searchNames);
    }

    @Benchmark
    fun indexOf(data: TestData): Boolean {
        for (searchName in data.searchNames) {
            if (data.namesStr.indexOf(searchName) >= 0) {
                return true
            }
        }

        return false
    }

    @Benchmark
    fun contains(data: TestData): Boolean {
        for (searchName in data.searchNames) {
            if (data.namesStr.contains(searchName)) {
                return true
            }
        }

        return false
    }
}
