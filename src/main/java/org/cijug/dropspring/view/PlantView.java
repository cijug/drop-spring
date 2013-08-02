package org.cijug.dropspring.view;

import com.yammer.dropwizard.views.View;
import org.cijug.dropspring.core.Plant;

public class PlantView extends View {

    private final Plant plant;

    public PlantView(Plant plant) {
        super("plant.mustache");
        this.plant = plant;
    }

    public Plant getPlant() {
        return plant;
    }

}
