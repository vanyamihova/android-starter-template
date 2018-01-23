package eu.vanyamihova.starter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by Vanya Mihova on 23.01.2018
 */

final class DaggerConfiguration {

    private static ObjectGraph sGraph;

    DaggerConfiguration(Context context) {
        sGraph = ObjectGraph.create(getModules(context).toArray());
    }

    private List<Object> getModules(Context context) {
        final List<Object> objects = new ArrayList<>();
        objects.add(new AppModule(context));
        return objects;
    }

    public void inject(Object object) {
        sGraph.inject(object);
    }

}
