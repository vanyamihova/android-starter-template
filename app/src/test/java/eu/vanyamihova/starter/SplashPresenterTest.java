package eu.vanyamihova.starter;

import org.junit.Before;

import eu.vanyamihova.starter.domain.usecase.sync.SyncUseCase;
import eu.vanyamihova.starter.presentation.app.splash.SplashContract;
import eu.vanyamihova.starter.presentation.app.splash.SplashPresenter;

import static org.mockito.Mockito.mock;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 22.04.2019
 */
public class SplashPresenterTest {

    private SplashContract.View mockView;
    private SplashPresenter presenter;
    private SyncUseCase syncUseCase;

    @Before
    public void setup() {
        mockView = mock(SplashContract.View.class);
        syncUseCase = mock(SyncUseCase.class);

        presenter = new SplashPresenter(syncUseCase);
    }

}
