package org.hign.platform.wanderlog.Firebase;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FirebaseNotificationService {

    public void sendNotification(String title, String body, String topic) {
        try {
            // Construir la notificación
            Notification notification = Notification.builder()
                    .setTitle(title)
                    .setBody(body)
                    .build();

            // Construir el mensaje
            Message message = Message.builder()
                    .setTopic(topic)
                    .putData("click_action", "FLUTTER_NOTIFICATION_CLICK")
                    .putData("type", "nuevo_paquete")
                    .setNotification(notification)
                    .build();

            // Enviar el mensaje
            String response = FirebaseMessaging.getInstance().send(message);
            System.out.println("Notificación enviada: " + response);
        } catch (Exception e) {
            System.err.println("Error al enviar notificación: " + e.getMessage());
        }
    }
}
