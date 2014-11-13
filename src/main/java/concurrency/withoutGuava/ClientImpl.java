package concurrency.withoutGuava;

import concurrency.Callback;
import concurrency.RequestParams;
import concurrency.TransportResult;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gauravmittal on 11/13/14.
 */
public class ClientImpl implements Client {

    private Executor _executor = Executors.newSingleThreadExecutor();
    private ITransport _transport;

    public ClientImpl(ITransport transport) {
        _transport = transport;
    }

    @Override
    public void processRequest(final RequestParams params, final Callback<String, String> callback) {
        //This layer does not add much value but wants to either
        //1. Transform the result in some way
        //2. Process it like persist it may be
        _transport.sendRequest(params, new Callback<TransportResult, String>() {
            @Override
            public void success(TransportResult value) {
                //Process TransportResult and extract string
                _executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.success("hello");

                    }
                });
            }

            @Override
            public void failure(String value) {
                _executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.failure("some custom enum");
                    }
                });
            }
        });
    }
}
