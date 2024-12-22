package pack1;

public class CompanySelectionBackend {
    private String selectedCompany;

    public void selectCompany(String company) {
        this.selectedCompany = company;
    }

    public String cancelOperation() {
        this.selectedCompany = null;
        return "System Close";
    }

    public String getSelectedCompany() {
        return selectedCompany;
    }
}
