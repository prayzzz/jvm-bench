package prz.jvm.bench

import org.apache.commons.lang3.StringUtils
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import java.util.*
import java.util.stream.Collectors

open class StringSplit {

    @State(Scope.Benchmark)
    open class TestData {
        val names = listOf(
            "Ruth", "Lorri", "Milford", "Malorie", "Bridgette", "Freeman", "Ronna", "Nguyet", "Zaida",
            "Tanja", "Mohammad", "Lee", "Wei", "Deborah", "Lynelle", "Margarita", "Anissa", "Nadine"
        )
        val namesStr = names.joinToString(",")
    }

    @Benchmark
    fun stream(data: TestData): List<String> {
        return splitAndTrimStream(data.namesStr, ",")
    }

    @Benchmark
    fun foreach(data: TestData): List<String> {
        return splitAndTrimFor(data.namesStr, ",")
    }

    fun splitAndTrimFor(str: String, regex: String): List<String> {
        if (StringUtils.isBlank(str)) {
            return emptyList()
        }

        val values = ArrayList<String>()
        for (s in str.split(regex.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            if (StringUtils.isNotBlank(s.trim { it <= ' ' })) {
                values.add(s)
            }
        }

        return values
    }

    fun splitAndTrimStream(str: String, regex: String): List<String> {
        if (StringUtils.isBlank(str)) {
            return emptyList()
        }

        return str.split(regex.toRegex()).stream()
            .map { it.trim() }
            .filter { StringUtils.isNotBlank(it) }
            .collect(Collectors.toList())
    }
}