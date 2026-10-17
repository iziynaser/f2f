package ir.verjik.entity;

import ir.verjik.dbc.entity.BaseEntity;

import java.io.Serializable;

public class BudgetItem extends BaseEntity implements Serializable {

    private Budget budget;

    private Short sequenceId;

    private String description;

    private String amount;

    private String purpose;

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Short getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Short sequenceId) {
        this.sequenceId = sequenceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public BudgetItem() {
    }

    public BudgetItem(Budget budget, Short sequenceId, String description, String amount, String purpose) {
        this.budget = budget;
        this.sequenceId = sequenceId;
        this.description = description;
        this.amount = amount;
        this.purpose = purpose;
    }
}
