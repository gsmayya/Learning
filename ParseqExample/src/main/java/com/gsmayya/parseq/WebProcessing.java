package com.gsmayya.parseq;

import com.linkedin.parseq.Engine;
import com.linkedin.parseq.Task;
import com.linkedin.parseq.example.common.AbstractExample;
import com.linkedin.parseq.example.common.ExampleUtil;
import com.linkedin.parseq.httpclient.HttpClient;
import com.ning.http.client.Response;

public class WebProcessing extends AbstractExample {

    private Task<String> fetchBody(String url) {
        return HttpClient.get(url).task().map(Response::getResponseBody);
    }


    protected void doRunExample(final Engine engine) throws Exception {
        final Task<String> google = fetchBody("http://www.google.com");
        final Task<String> yahoo = fetchBody("http://www.yahoo.com");
        final Task<String> bing = fetchBody("http://www.bing.com");

        final Task<Integer> sumLengths =
                Task.par(google.map(String::length),
                        yahoo.map(String::length),
                        bing.map(String::length))
                .map("sum", (g, y, b) -> g + y + b);

        engine.run(sumLengths);
        sumLengths.await();

        ExampleUtil.printTracingResults(sumLengths);
    }

    public static void main(String [] args) throws Exception {
        new WebProcessing().runExample();
        HttpClient.close();
    }
}
