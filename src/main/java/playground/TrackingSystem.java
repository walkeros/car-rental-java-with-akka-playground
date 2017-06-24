package playground;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import playground.commands.StartCar;

import java.io.IOException;

/**
 * Created by tosh on 2017-06-23.
 */
public class TrackingSystem {

    public static void main(String[] args) {
        final ActorSystem system = ActorSystem.create("tracking_system");
        try {
            //#create-actors
            final ActorRef carService =
                    system.actorOf(CarService.props(), "carService");

            carService.tell(new StartCar("XCB-12313-23"), ActorRef.noSender());



        //    howdyGreeter.tell(new Object(), ActorRef.noSender());
            //#main-send-messages

            System.out.println(">>> Press ENTER to exit <<<");
            System.in.read();
        } catch (IOException ioe) {
        } finally {
            system.terminate();
        }
    }
}
