package eu.vanyamihova.starter.domain.usecase.sync;

import javax.inject.Inject;

import eu.vanyamihova.starter.domain.sync.SyncRepository;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
public class SyncUseCaseImpl implements SyncUseCase {

    private SyncRepository syncRepository;

    @Inject
    public SyncUseCaseImpl(SyncRepository syncRepository) {
        this.syncRepository = syncRepository;
    }

    @Override
    public void sync(SyncCallback callback) {
        syncRepository.getTasks(callback::onComplete);
    }
}
