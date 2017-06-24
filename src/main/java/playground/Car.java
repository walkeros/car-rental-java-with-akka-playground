package playground;

import akka.actor.*;
import akka.persistence.*;
import playground.commands.Move;
import playground.events.CarMoved;

import java.util.Optional;

//#greeter-messages
public class Car extends AbstractPersistentActor {

    private Optional<CarState> state = Optional.empty();

    //#greeter-messages
    static public Props props() {
        return Props.create(Car.class, () -> new Car());
    }


    public Car() {
    }


    @Override
    public Receive createReceive() {
        System.out.println("in Car recive");

        return receiveBuilder()
                .match(Move.class, startCar -> {

                    System.out.println("command recived" + startCar);

                    String licensePlateNumber = startCar.getLicensePlateNumber();

                    persist(new CarMoved(licensePlateNumber), event -> {
                        updateWith(event);
                        //getSender().tell("OK", getSelf());

                        System.out.println("persisted" + licensePlateNumber);
                    });

                })

                .build();
    }

    public void updateWith(CarMoved carMoved) {
        state = state.map(CarState::fromStopped);
    }
    @Override
    public String persistenceId() {
        return getSelf().path().name();
    }

    @Override
    public Receive createReceiveRecover() {
        return null;
    }

    enum MotionState {
        MOVING, STOPPED;
    }

    class CarState {
        private final MotionState state;

        private CarState(MotionState state) {
            this.state = state;
        }


        public CarState fromStopped() {
            return new CarState(MotionState.MOVING);
        }

        public CarState fromMoving() {
            return new CarState(MotionState.STOPPED);
        }


    }


//    @Override
//    public AbstractActor.Receive createReceive() {
//        System.out.println(Thread.currentThread());
//
//        return receiveBuilder()
//                .match(StartCar.class, startCar -> {
//
//                    String licensePlateNumber = startCar.getLicensePlateNumber();
//
//                })
//
//                .build();
//    }
//#greeter-messages
}
//#greeter-messages
