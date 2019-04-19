package eu.vanyamihova.starter.domain;

import dagger.Module;
import eu.vanyamihova.starter.domain.usecase.UseCaseModule;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Module(includes = {UseCaseModule.class})
public class DomainModule {
}
