import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.util.Timer;
import java.util.TimerTask;

class Sender {
    private String host;
    private int port;

    Sender(String host, int port) { // Конструктор класса Sender, принимает значения host и port и
        // присваивает их соответствующим переменным
        this.host = host;
        this.port = port;
    }

    private void sendMessage(String mes) { // Приватный метод sendMessage, который принимает сообщение в виде строки
        try {
            byte[] data = mes.getBytes(); // Преобразование сообщения в байтовый массив
            InetAddress address = InetAddress.getByName(host); // Получение InetAddress объекта для указанного хоста
            DatagramPacket pack = new DatagramPacket(data, data.length, address, port); // Создание DatagramPacket для
            // отправки данных по указанному адресу и порту
            DatagramSocket ds = new DatagramSocket(); // Создание DatagramSocket
            ds.send(pack); // Отправка пакета
            ds.close(); // Закрытие сокета
        } catch (IOException e) { // Обработка возможных исключений ввода-вывода
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Sender sender = new Sender("localhost", 1050); // Создание объекта класса Sender с
        // указанными параметрами хоста и порта
        String message = "Hello"; // Задание сообщения

        Timer timer = new Timer(); // Создание объекта Timer
        timer.scheduleAtFixedRate(new TimerTask() { // Запуск выполнения задачи по расписанию
            @Override
            public void run() {
                sender.sendMessage(message); // Вызов метода sendMessage у объекта sender, передача в него сообщения
            }
        }, 1000, 1000);
    }

}
