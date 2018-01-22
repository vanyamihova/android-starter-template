package eu.vanyamihova.starter.domain.base.interactor;

/**
 * Created by Vanya Mihova on 18.01.2018
 */

public interface CompletableUseCase<P> {

    interface Callback {
        void onSuccess();
        void onError(Throwable throwable);
    }

    void execute(P parameter, Callback callback);

}
