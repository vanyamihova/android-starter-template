package eu.vanyamihova.starter.presentation;

import dagger.Subcomponent;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Subcomponent(modules = {})
public interface PresentationComponent {

    @Subcomponent.Builder
    interface Builder {
        PresentationComponent build();
    }
}
