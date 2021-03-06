package final_project.solution.creditcard.commands;

import final_project.solution.creditcard.CreditAccountService;
import final_project.solution.framework.ui.UIControl;
import final_project.solution.framework.ui.Command;

public class AddCompanyAccountCommand implements Command {
    public void execute(UIControl control) {
        CreditAccountService.getInstance().createAccount(control.getAccountNumber(), control.getCustomer(), control.getAccountType());
    }
}
