import java.net.*; //импортируется пакет java.net, содержащий классы для работы с сетевыми ресурсами

public class UdpClient { //объявляется открытый класс UdpClient
    public static void main(String[] args) { //объявляется открытый статический метод main, принимающий аргумент типа String массив
        try { //начало блока try, который используется для обработки исключений

            // Создание сокета для отправки и получения данных

            DatagramSocket socket = new DatagramSocket(); //создается новый экземпляр класса DatagramSocket,
            // который будет использоваться для отправки и получения данных сообщений

            // Создание и отправка данных
            String sendData = "Hello, server!"; //создается новая строковая переменная sendData и инициализируется
            // значением "Hello, server!"
            byte[] sendDataBytes = sendData.getBytes(); //создается новый массив байтов и заполняется данными из строки sendData
            InetAddress serverAddress = InetAddress.getByName("localhost"); //получается объект InetAddress и присваивается
            // переменной serverAddress. В данном случае используется адрес "localhost"
            int serverPort = 12345; //создается новая переменная serverPort и присваивается значение 12345
            DatagramPacket sendPacket = new DatagramPacket(sendDataBytes, sendDataBytes.length, serverAddress, serverPort); //создается
            // новый пакет данных DatagramPacket со сформированными данными, адресом сервера и портом
            socket.send(sendPacket); //отправляется пакет данных на сервер с помощью метода send объекта сокета
            System.out.println("Отправлено: " + sendData); //выводится сообщение о том, что данные были успешно отправлены на сервер

            // Получение данных
            byte[] receiveDataBytes = new byte[1024]; //создается новый массив байтов, который будет использоваться
            // для хранения полученных данных
            DatagramPacket receivePacket = new DatagramPacket(receiveDataBytes, receiveDataBytes.length); //создается новый пакет данных
            // DatagramPacket для получения данных от сервера
            socket.receive(receivePacket); //получение пакета данных от сервера с помощью метода receive объекта сокета
            String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength()); //создается новая
            // строковая переменная receivedData и инициализируется данными из пакета данных
            System.out.println("Получено: " + receivedData); //выводится сообщение о том, что данные были успешно получены от сервера

            // Расшифровка данных
            String decryptedData = decryptData(receivedData); //вызывается метод decryptData для расшифровки полученных данных
            System.out.println("Расшифровано: " + decryptedData); //выводится сообщение о том, что данные были успешно расшифрованы

            // Закрытие сокета
            socket.close(); //закрывается сокет. Конец блока try
        } catch (Exception e) { //начало блока catch, который обрабатывает исключение типа Exception
            e.printStackTrace(); //Конец блока catch
        }
    }

    private static String decryptData(String data) { //объявляется закрытый статический метод decryptData,
        // принимающий аргумент типа String
        // Расшифровка данных
        // код расшифровки
        return data; //возвращается неизмененное значение переданной строки. Конец метода decryptData
    }
}
