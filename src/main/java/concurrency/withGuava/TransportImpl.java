package concurrency.withGuava;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import concurrency.RequestParams;
import concurrency.TransportResult;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gauravmittal on 11/13/14.
 */
public class TransportImpl implements ITransport {

    private Executor _executor = Executors.newSingleThreadExecutor();

    @Override
    public ListenableFuture<TransportResult> sendRequest(RequestParams params) {
        final SettableFuture<TransportResult> settableFuture = SettableFuture.create();
        _executor.execute(new Runnable() {
            @Override
            public void run() {
                //In case of success
                settableFuture.set(new TransportResult());
                //In case of failure
                settableFuture.setException(new Throwable("custom error"));
            }
        });
        return settableFuture;
    }
}
