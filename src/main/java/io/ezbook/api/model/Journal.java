package io.ezbook.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.ezbook.api.entity.JournalEntity;
import io.ezbook.api.entity.JournalStatus;

import java.math.BigDecimal;
import java.util.Date;

public class Journal {
    private long id;
    private String no;
    private Date date;
    private JournalStatus status;
    private double amount;

    public Journal(JournalEntity journalEntity) {
        this.id = journalEntity.getId();
//        this.no = journalEntity.get
        this.status = journalEntity.getStatus();
        this.date = journalEntity.getDate();
        this.amount = journalEntity.getJournalDetails().stream().map(d -> d.getCredit()).reduce(0.0, (a, b) -> a + b);

    }

    public long getId() {
        return id;
    }

    public String getNo() {
        return no;
    }

    public JournalStatus getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDate() {
        return date;
    }
}
