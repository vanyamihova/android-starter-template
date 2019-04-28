package eu.vanyamihova.starter;

import org.junit.Before;
import org.junit.Test;

import eu.vanyamihova.starter.presentation.app.splash.SplashContract;
import eu.vanyamihova.starter.presentation.app.splash.SplashPresenter;

import static org.mockito.Mockito.mock;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 22.04.2019
 */
public class SplashPresenterTest {

    private SplashContract.Model mockModel;
    private SplashContract.View mockView;
    private SplashPresenter presenter;

    @Before
    public void setup() {
        mockView = mock(SplashContract.View.class);
        mockModel = mock(SplashContract.Model.class);

        presenter = new SplashPresenter(mockModel);
        presenter.delegateView(mockView);
    }

    @Test
    public void loadDataFromUseCase() {
        //
    }

}
