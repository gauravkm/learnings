package concurrency.withoutGuava;

import concurrency.Callback;
import concurrency.RequestParams;

/**
 * Created by gauravmittal on 11/13/14.
 */
public interface Client {

    public void processRequest(RequestParams params, Callback<String,String> callback);

}
