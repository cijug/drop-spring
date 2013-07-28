package org.cijug.dropspring.view;

import com.yammer.dropwizard.views.View;
import org.cijug.dropspring.core.Foo;

public class FooView extends View {

    private final Foo foo;

    public FooView(Foo foo) {
        super("foo.mustache");
        this.foo = foo;
    }

    public Foo getFoo() {
        return foo;
    }

}
