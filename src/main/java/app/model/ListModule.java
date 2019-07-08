package app.model;


import app.entities.BmiData;
import app.entities.BmiDataImpl;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class ListModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(BmiList.class).to(BmiListImpl.class)
                .in(Scopes.SINGLETON);
        bind(BmiData.class).to(BmiDataImpl.class);
    }
}
