package threads.tunnel;

import threads.tunnel.entities.RailManager;
import threads.tunnel.entities.Train;

import java.util.concurrent.TimeUnit;

/**
 * Тоннель.
 * В горах существует два железнодорожных тоннеля, по которым поезда могут двигаться в обоих направлениях.
 * По обоим концам тоннеля собралось много поездов. Обеспечить безопасное прохождение тоннелей в обоих направлениях.
 * Поезд можно перенаправить из одного тоннеля в другой при превышении заданного времени ожидания на проезд.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        RailManager railManager = new RailManager();
        for (int i = 0; i < 10; i++) {
            new Thread(new Train(railManager)).start();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
