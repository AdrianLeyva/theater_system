package model.persistence;

import java.util.Date;

public class Transactions {
    private Integer transaction_ID;
    private Integer ticketsQty;
    private Integer funcion_ID;
    private Integer total;
    private Integer typeTransaction;
    private Integer user_ID;
    private Date date;
    private String clientName;


    public Integer getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(Integer transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    public Integer getTicketsQty() {
        return ticketsQty;
    }

    public void setTicketsQty(Integer ticketsQty) {
        this.ticketsQty = ticketsQty;
    }

    public Integer getFuncion_ID() {
        return funcion_ID;
    }

    public void setFuncion_ID(Integer funcion_ID) {
        this.funcion_ID = funcion_ID;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(Integer typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public Integer getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(Integer user_ID) {
        this.user_ID = user_ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
