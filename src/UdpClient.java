import java.net.*;

public class UdpClient {
    public static void main(String[] args) {
        try {
            // Создание сокета для отправки и получения данных
            DatagramSocket socket = new DatagramSocket();

            // Создание и отправка данных
            String sendData = "Hello, server!";
            byte[] sendDataBytes = sendData.getBytes();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;
            DatagramPacket sendPacket = new DatagramPacket(sendDataBytes, sendDataBytes.length, serverAddress, serverPort);
            socket.send(sendPacket);
            System.out.println("Отправлено: " + sendData);

            // Получение данных
            byte[] receiveDataBytes = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveDataBytes, receiveDataBytes.length);
            socket.receive(receivePacket);
            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Получено: " + receivedData);

            // Расшифровка данных
            String decryptedData = decryptData(receivedData);
            System.out.println("Расшифровано: " + decryptedData);

            // Закрытие сокета
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String decryptData(String data) {
        // Расшифровка данных
        // код расшифровки
        return data;
    }
}
