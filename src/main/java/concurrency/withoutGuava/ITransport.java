package concurrency.withoutGuava;

import concurrency.Callback;
import concurrency.RequestParams;
import concurrency.TransportResult;

/**
 * Created by gauravmittal on 11/13/14.
 */
public interface ITransport {

    public void sendRequest(RequestParams params, Callback<TransportResult, String> callback);
}
