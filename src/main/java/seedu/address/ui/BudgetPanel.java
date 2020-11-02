package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.Logic;
import seedu.address.model.expense.Budget;

public class BudgetPanel extends UiPart<Region> {
    private static final String FXML = "BudgetPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(BudgetPanel.class);

    private Budget budget;

    private Logic logic;

    @FXML
    private Label budgetAmount;
    @FXML
    private Label budgetRemaining;
    @FXML
    private Label totalSpending;

    /**
     * Constructs a BudgetPanel object.
     *
     * @param logic The logic manager.
     */
    public BudgetPanel(Logic logic) {
        super(FXML);

        this.logic = logic;

        this.budget = logic.getExpenseBook().getBudget();

        budgetAmount.setText(String.format("Current budget: %.2f, %s", budget.getValue(),
                logic.getExpenseBook().getCurrency()));

        budgetRemaining.setText(String.format("Remaining budget: %.2f %s",
                logic.getExpenseBook().getRemainingBudget().getValue(),
                logic.getExpenseBook().getCurrency()));
        totalSpending.setText(String.format("Total spending: %.2f %s",
                logic.getExpenseBook().getBudget().getValue()
                - logic.getExpenseBook().getRemainingBudget().getValue(),
                logic.getExpenseBook().getCurrency()));
    }

    /**
     * Update the budget statistics shown in the GUI.
     */
    public void update() {
        budgetAmount.setText(String.format("Current budget: %.2f %s",
                logic.getExpenseBook().getBudget().getValue(),
                logic.getExpenseBook().getCurrency()));

        budgetRemaining.setText(String.format("Remaining budget: %.2f %s",
                logic.getExpenseBook().getRemainingBudget().getValue(),
                logic.getExpenseBook().getCurrency()));

        totalSpending.setText(String.format("Total spending: %.2f %s",
                logic.getExpenseBook().getBudget().getValue()
                        - logic.getExpenseBook().getRemainingBudget().getValue(),
                logic.getExpenseBook().getCurrency()));
    }

}