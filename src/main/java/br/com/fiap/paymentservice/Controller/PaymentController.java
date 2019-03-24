package br.com.fiap.paymentservice.Controller;

import br.com.fiap.paymentservice.Entity.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {
    private ArrayList<Payment> payments = new ArrayList<>();

    @GetMapping("/payment/findById/{id}")
    public Map<String, Payment> findById(@PathVariable("id") int id) {
        HashMap<String, Payment> mapa = new HashMap<>();

        try {
            Payment order = this.payments.get(id);
            mapa.put("Payment", order);
        } catch (Exception err) {
            mapa.put("Payment", null);
        }
        return mapa;
    }

    @PostMapping("/payment/save")
    public Map<String, String> save(@RequestBody Payment payment) {
        HashMap<String, String> mapa = new HashMap<>();
        try {
            // Adiciona o payment ao array
            this.payments.add(payment);

            // Add o id ao payment atual
            int id = this.payments.size() - 1;
            this.payments.get(id).setId(id);

            mapa.put("URL", "http://localhost:8080/payment/findById/" + id);
        } catch (Exception err) {
            mapa.put("Payment", "Não foi possivel salvar!");
        }

        return mapa;
    }

    @PostMapping("/payment/update/{id}")
    public Map<String, String> update(@RequestBody Payment payment, @PathVariable("id") int id) {
        HashMap<String, String> mapa = new HashMap<>();
        try {
            this.payments.set(id, payment);
            mapa.put("Mensagem", "Payment atualizado!");
            mapa.put("Url", "http://localhost:8080/payment/findById/" + id);
        } catch (Exception err) {
            mapa.put("Mensagem", "Esta Payment não existe!");
        }

        return mapa;
    }

    @PostMapping("/payment/delete/{id}")
    public Map<String, String> delete(@PathVariable("id") int id) {

        HashMap<String, String> mapa = new HashMap<>();
        try {
            this.payments.remove(id);
            mapa.put("Mensagem", "Payment: " + id + " removido!");
        } catch (Exception err) {
            mapa.put("Payment", "Esta Payment não existe!");
        }

        return mapa;
    }
}
