package eu.vanyamihova.starter.domain.base.interactor;

/**
 * Abstract class for a Use Case (Interactor in terms of Clean Architecture).
 * This interface represents a execution unit for different use cases (this means any use case
 * in the application should implement this contract).
 *
 * By convention each UseCase implementation will return the result using a {@link DisposableObserver}
 * that will execute its job in a background thread and will post the result in the UI thread.
 */

public interface UseCase<P, R> {

    interface Callback<R> {
        void onSuccess(R result);
        void onError(Throwable throwable);
    }

    void execute(P parameter, Callback<R> callback);

}
