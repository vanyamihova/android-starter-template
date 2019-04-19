package eu.vanyamihova.starter.domain;

import dagger.Subcomponent;
import eu.vanyamihova.starter.domain.usecase.UseCaseModule;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Subcomponent(modules = {RepositoryModule.class, UseCaseModule.class})
public interface DomainComponent {

    @Subcomponent.Builder
    interface Builder {
        DomainComponent build();
    }
}
