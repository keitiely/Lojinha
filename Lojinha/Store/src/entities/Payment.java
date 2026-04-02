package entities;

import types.PaymentStatus;
import types.PaymentType;

import java.util.UUID;

public class Payment {
    private String id;
    private String orderId;
    private Float totalPaid;
    private PaymentType type;
    private PaymentStatus status;

    public Payment(String orderId, Float totalPaid, PaymentType type) {
        this.orderId = orderId;
        this.totalPaid = totalPaid;
        this.id = UUID.randomUUID().toString();
        this.status = PaymentStatus.PENDING;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public Float getTotalPaid() {
        return totalPaid;
    }


    public PaymentStatus getStatus() {
        return status;
    }

    public PaymentType getType() {
        return type;
    }


    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
