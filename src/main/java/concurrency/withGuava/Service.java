package concurrency.withGuava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import concurrency.Callback;
import concurrency.RequestParams;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gauravmittal on 11/13/14.
 */
public class Service {

    private Executor _executor = Executors.newSingleThreadExecutor();
    private final Client _client;

    public Service(Client client) {
        _client = client;
    }

    public void makeCall() {
        RequestParams requestParams = new RequestParams();
        ListenableFuture<String> listenableFuture = _client.processRequest(requestParams);
        Futures.addCallback(listenableFuture, new FutureCallback<String>() {
            @Override
            public void onSuccess(String s) {
                //logic here
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        }, _executor);
    }
}
