package test;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import com.lightbend.akka.sample.Printer;
import test.commands.Move;
import test.commands.StartCar;

public class CarService extends AbstractActor {


    static public Props props() {
        return Props.create(CarService.class, () -> new CarService());
    }

    private Car car;


    @Override
    public Receive createReceive() {
        System.out.println(Thread.currentThread());

        return receiveBuilder()
                .match(StartCar.class, startCar -> {
                    System.out.println("matched");

                    final ActorRef carActor =
                            getContext().actorOf(Car.props(), "Car");



                    carActor.tell(new Move(startCar.getLicensePlateNumber()), getSelf());

                    // teraz ten proces tutaj sie konczy - ebent jest zapisany do journala.

                    // Z akka persitant plugin powinnismy wywolac continous query do journala ktore stworzy
                    // AKKA stream ---- Aktor mapy musi sie jakos sie zasubskrybowac do tego streama i bedzie
                    // odbieral eventy


                })
                .build();
    }}
