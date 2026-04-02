package repositories;
import entities.Payment;
import types.PaymentType;

public class PaymentsRepository {
    public static Payment createPayment(String orderId, Float totalPaid, PaymentType type){
        return new Payment(orderId, totalPaid, type);
    }
}
