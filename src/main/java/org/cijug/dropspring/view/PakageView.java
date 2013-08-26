package org.cijug.dropspring.view;

import com.yammer.dropwizard.views.View;
import org.cijug.dropspring.core.Pakage;

import java.util.List;

public class PakageView extends View {

    private List<Pakage> pakages;

    public PakageView(List<Pakage> pakages) {
        super("pakage.mustache");
        this.pakages = pakages;
    }

    public List<Pakage> getPakages() {
        return pakages;
    }

}
