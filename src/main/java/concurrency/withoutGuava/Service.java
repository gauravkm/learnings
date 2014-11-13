package concurrency.withoutGuava;

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
        Callback callback = new Callback() {
            @Override
            public void success(String value) {
                //Suppose you want this to be invoked on a particular thread.
                _executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //Logic here
                    }
                });
            }

            @Override
            public void failure(String value) {

            }
        };
        _client.processRequest(requestParams, callback);
    }
}
