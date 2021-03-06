import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class TableClickManager implements ListChangeListener<Rezept> {

    private TableView tableView;

    public TableClickManager(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public void onChanged(Change<? extends Rezept> c) {
        System.out.println("Selection changed: " + c.getList());
    }
}
