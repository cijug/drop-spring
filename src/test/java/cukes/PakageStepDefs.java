package cukes;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.cijug.dropspring.DB;
import org.cijug.dropspring.core.Pakage;
import org.cijug.dropspring.db.PakageDAO;
import org.cijug.dropspring.view.PakageView;
import org.cijug.dropspring.web.PakageResource;

import java.util.List;

public class PakageStepDefs {

    PakageResource resource;
    private PakageView pakages;
    private PakageDAO dao;

    @Given("^the following pakages exist$")
    public void the_following_pakages_exist(List<Pakage> libraries) throws Throwable {
        dao = DB.instance().dao(PakageDAO.class);
        resource = new PakageResource(dao);

        for (Pakage pakage : libraries) {
            resource.addPakage(pakage);
        }
    }

    @When("^I get all$")
    public void I_get_all() throws Throwable {
        pakages = resource.showView();
    }

    @When("^I look for \"([^\"]*)\"$")
    public void I_look_for(String name) throws Throwable {
        pakages = resource.getPakagesByName(name);
    }

    @Then("^I should get$")
    public void I_should_get(DataTable expected) throws Throwable {
        expected.diff(pakages.getPakages());
    }

}
