package eu.vanyamihova.starter.domain.usecase.sync;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
public interface SyncUseCase {
    void sync(SyncCallback callback);
}
