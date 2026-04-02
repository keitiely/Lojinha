import clients.PaymentClient;
import entities.*;
import repositories.*;
import types.OrderStatus;
import types.PaymentType;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual o seu email?");
        String email = scanner.next();

        System.out.println("Qual a sua senha?");
        String password = scanner.next();

        User user = UsersRepository.login(email.trim(), password.trim());

        if (user != null) {
            System.out.println("Bem vindo, " + user.getName() + "!");

            List<Product> products = ProductsRepository.getProducts();
            Cart cart = CartsRepository.createCart(user.getId());

            System.out.println("Escolha os produtos que você quer adicionar ao carrinho.");

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.println("[" + i + "] " + p.getName() + " - R$" + p.getPrice() + " (estoque: " + p.getStock() + ")");
            }

            while (true) {
                System.out.println("\nDigite o número do produto (ou -1 para finalizar):");
                int index = scanner.nextInt();

                if (index == -1) break;

                Product selected = products.get(index);

                System.out.println("Quantidade:");
                int quantity = scanner.nextInt();

                if (quantity > selected.getStock()) {
                    System.out.println("Quantidade indisponível! Estoque: " + selected.getStock());
                    continue;
                }

                CartItem existingItem = CartItemsRepository.findByProductId(selected.getId());

                if (existingItem != null) {
                    existingItem.setQuantity(existingItem.getQuantity() + quantity);
                } else {
                    CartItemsRepository.createCartItem(cart.getId(), selected.getId(), quantity);
                }


                ProductsRepository.decreaseProductStock(selected.getId(), quantity);


                System.out.println(quantity + "x " + selected.getName() + " adicionado ao carrinho!");
            }

            System.out.println("\nProdutos no carrinho:");

            for (CartItem c : CartItemsRepository.cartItemList) {
                Product cartItemProduct = ProductsRepository.findById(c.getProductId());
                System.out.println("- " + cartItemProduct.getName() + " R$" + c.getQuantity() * cartItemProduct.getPrice());
            }

            System.out.println("Deseja finalizar o pedido? 0 - Não 1 - Sim ");
            int response = scanner.nextInt();

            if (response == 1) {
                Order order = OrdersRepository.createOrder();
                float totalPaid = 0.0f;
                PaymentClient paymentClient = PaymentClient.getInstance();

                for (CartItem c : CartItemsRepository.cartItemList) {
                    Product cartItemProduct = ProductsRepository.findById(c.getProductId());
                    OrderItemsRepository.createOrderItem(order.getId(), cartItemProduct.getId(), c.getQuantity() * cartItemProduct.getPrice());
                    totalPaid += c.getQuantity() * cartItemProduct.getPrice();

                }

                int paymentMethod = 0;
                Payment payment;

                while (paymentMethod < 1 || paymentMethod > 3) {
                    System.out.println("Qual será a forma de pagamento:");
                    System.out.println("[1] Cartão de Crédito");
                    System.out.println("[2] Cartão de Débito");
                    System.out.println("[3] Pix");

                    paymentMethod = scanner.nextInt();

                    if (paymentMethod < 1 || paymentMethod > 3) {
                        System.out.println("Opção inválida! Tente novamente.");
                    }
                }

                switch (paymentMethod) {
                    case 1:
                        payment = PaymentsRepository.createPayment(order.getId(), totalPaid, PaymentType.CREDIT_CARD);
                        paymentClient.paid(payment);
                        break;
                    case 2:
                        payment = PaymentsRepository.createPayment(order.getId(), totalPaid, PaymentType.DEBIT_CARD);
                        paymentClient.paid(payment);
                        break;
                    case 3:
                        payment = PaymentsRepository.createPayment(order.getId(), totalPaid, PaymentType.PIX);
                        paymentClient.paid(payment);
                        break;
                }

            }


        } else {
            System.out.println("Email ou senha inválidos!");
        }
    }
}