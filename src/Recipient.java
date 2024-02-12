import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

class Recipient {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(1050); // Создание объекта DatagramSocket,
            // который будет использоваться для приема пакетов данных

            while (true) { // Бесконечный цикл для непрерывного приема пакетов данных
                DatagramPacket pack = new DatagramPacket(new byte[5], 5); // Создание объекта DatagramPacket
                // для хранения принятых данных, размером 5 байт
                ds.receive(pack); // Прием пакета данных через сокет ds
                System.out.println(new String(pack.getData())); // Вывод принятых данных в виде строки
            }
        } catch (IOException e) { // Обработка исключения IOException, которое может
            // возникнуть при создании DatagramSocket или приеме пакета данных
            e.printStackTrace(); // Вывод стека вызовов исключения для отладки
        }
    }
}