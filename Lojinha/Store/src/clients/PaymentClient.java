package clients;

import entities.Payment;
import types.PaymentStatus;

public class PaymentClient {
    private static PaymentClient instance;

    private PaymentClient() {
    }

    public static PaymentClient getInstance() {
        if (instance == null) {
            instance = new PaymentClient();
        }
        return instance;
    }

    public void paid(Payment payment) {
        try {
            Thread.sleep(3000);

            payment.setStatus(PaymentStatus.APPROVED);

            System.out.println("Pagamento de " + payment.getTotalPaid() + " feito!");
        } catch (InterruptedException e) {
            System.out.println("Erro ao processar pagamento!");
        }
    }
}
