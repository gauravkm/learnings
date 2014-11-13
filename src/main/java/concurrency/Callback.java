package concurrency;

/**
 * Created by gauravmittal on 11/13/14.
 */
public interface Callback<U,V> {

    public void success(U value);

    public void failure(V value);

}
