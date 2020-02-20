package prz.jvm.bench.deserialization

import com.dslplatform.json.DslJson
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.google.gson.Gson
import kotlinx.serialization.json.Json
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import java.io.ByteArrayInputStream

//fun main() {
//    println(Deserialization().test_dsljson_kotlin(Deserialization.TestData()))
//}

open class Deserialization {
    @State(Scope.Benchmark)
    open class TestData {
        internal val jackson = ObjectMapper().registerKotlinModule()
        internal val gson = Gson()
        internal val dsljsonJava = DslJson<KPersonWrapper>()
        internal val dsljsonKotlin = DslJson<JPersonWrapper>()
        internal val data = Deserialization::class.java.getResource("/deserialization.json").readText()
    }

    @Benchmark
    fun kotlinxSerialization(data: TestData): KPersonWrapper {
        return Json.parse(KPersonWrapper.serializer(), data.data)
    }

    @Benchmark
    fun jacksonKotlin(data: TestData): KPersonWrapper {
        return data.jackson.readValue(data.data, KPersonWrapper::class.java)
    }

    @Benchmark
    fun jacksonJava(data: TestData): JPersonWrapper {
        return data.jackson.readValue(data.data, JPersonWrapper::class.java)
    }

    @Benchmark
    fun gsonJava(data: TestData): JPersonWrapper {
        return data.gson.fromJson(data.data, JPersonWrapper::class.java)
    }

    @Benchmark
    fun gsonKotlin(data: TestData): KPersonWrapper {
        return data.gson.fromJson(data.data, KPersonWrapper::class.java)
    }

    @Benchmark
    fun dslJsonJava(data: TestData): JPersonWrapper {
        val bytes = ByteArrayInputStream(data.data.toByteArray())
        return data.dsljsonJava.deserialize(JPersonWrapper::class.java, bytes)!!
    }

    @Benchmark
    fun dslJsonKotlin(data: TestData): KPersonWrapper {
        val bytes = ByteArrayInputStream(data.data.toByteArray())
        return data.dsljsonKotlin.deserialize(KPersonWrapper::class.java, bytes)!!
    }
}
