package org.sid.bank_account.entities;

//@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public String getType();
}
