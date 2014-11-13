package concurrency.withGuava;

import com.google.common.util.concurrent.ListenableFuture;
import concurrency.Callback;
import concurrency.RequestParams;
import concurrency.TransportResult;

/**
 * Created by gauravmittal on 11/13/14.
 */
public interface ITransport {

    public ListenableFuture<TransportResult> sendRequest(RequestParams params);
}
