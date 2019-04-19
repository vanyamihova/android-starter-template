package eu.vanyamihova.starter.data;

import dagger.Subcomponent;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Subcomponent(modules = {})
public interface DataComponent {

    @Subcomponent.Builder
    interface Builder {
        DataComponent build();
    }
}
