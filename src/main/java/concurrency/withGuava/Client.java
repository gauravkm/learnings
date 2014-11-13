package concurrency.withGuava;

import com.google.common.util.concurrent.ListenableFuture;
import concurrency.Callback;
import concurrency.RequestParams;

/**
 * Created by gauravmittal on 11/13/14.
 */
public interface Client {

    public ListenableFuture<String> processRequest(RequestParams params);

}
