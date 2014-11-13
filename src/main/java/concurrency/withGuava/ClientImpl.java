package concurrency.withGuava;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import concurrency.RequestParams;
import concurrency.TransportResult;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by gauravmittal on 11/13/14.
 */
public class ClientImpl implements Client {

    private ITransport _transport;
    private Executor _executor = Executors.newSingleThreadExecutor();

    public ClientImpl(ITransport transport) {
        _transport = transport;
    }

    @Override
    public ListenableFuture<String> processRequest(RequestParams params) {
        
        ListenableFuture<TransportResult> future = _transport.sendRequest(params);
        return Futures.transform(future, new Function<TransportResult, String>() {
            @Override
            public String apply(TransportResult transportResult) {
                //Write your transformation here
                return "success";
            }
        }, _executor);
    }
}
