package eu.vanyamihova.starter.data;

import dagger.Module;
import eu.vanyamihova.starter.data.repository.RepositoryModule;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Module(includes = {RepositoryModule.class})
public class DataModule {
}
