package cukes;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.cijug.dropspring.TestDatabase;
import org.cijug.dropspring.core.Plant;
import org.cijug.dropspring.db.PlantDao;
import org.skife.jdbi.v2.DBI;

import java.util.List;

public class PlantStepDefs {

    @Given("^the following plants exist$")
    public void the_following_plants_exist(List<Plant> plants) throws Throwable {
        DBI dbi = TestDatabase.getInstance().getDBI();

        PlantDao plantDao = dbi.open(PlantDao.class);
        for (Plant plant : plants) {
            long id = plantDao.create(plant);
            System.out.println("id = " + id);
        }

        plantDao.rollback();
    }

    @Given("^I look for \"([^\"]*)\"$")
    public void I_look_for(String arg1) throws Throwable {
    }

    @Then("^I should get$")
    public void I_should_get(DataTable arg1) throws Throwable {
    }

}
