package com.gsmayya.parseq

import com.linkedin.parseq.Engine
import com.linkedin.parseq.Task
import com.linkedin.parseq.example.common.AbstractExample
import com.linkedin.parseq.example.common.ExampleUtil
import com.linkedin.parseq.httpclient.HttpClient
import com.ning.http.client.Response

class WebProcessingKT: AbstractExample() {

    fun fetchBody(url: String): Task<String> {
        return HttpClient.get(url).task().map{ it -> it.getResponseBody()}
    }

    override fun doRunExample(engine: Engine) {
        val google = fetchBody("http://www.google.com")
        val yahoo = fetchBody("http://www.yahoo.com")
        val bing = fetchBody("http://www.bing.com")

        val sumLengths = Task.par(
                google.map<Int>{it -> it.length},
                yahoo.map<Int>{it -> it.length},
                bing.map<Int>{it -> it.length})
                .map("sum") { g, y, b -> g + y + b }

        engine.run(sumLengths)
        sumLengths.await()

        ExampleUtil.printTracingResults(sumLengths)
    }
}

fun main(args: Array<String>) {
    WebProcessing().runExample()
    HttpClient.close()
}