package cukes.hooks;

import cucumber.api.java.After;
import org.cijug.dropspring.DB;
import org.skife.jdbi.v2.Handle;

public class TransactionRollbackHook {

    @After("@txn")
    public void databaseRollback() {
        Handle open = DB.instance().getDbi().open();
        open.execute("delete from packages");
        open.close();
    }
}
