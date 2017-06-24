package com.lightbend.akka.sample;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

//#printer-messages
public class Printer extends AbstractActor {
//#printer-messages
  static public Props props() {
    return Props.create(Printer.class, () -> new Printer());
  }

  //#printer-messages
  static public class Greeting {
    public final String message;

    public Greeting(String message) {
      this.message = message;
    }
  }

  static public class WhatDidYouMean {

  }
  //#printer-messages

  private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

  public Printer() {
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .match(Greeting.class, greeting -> {
            log.info(greeting.message);
        })
            .match(WhatDidYouMean.class, whatDidYouMean -> {
              log.info("I don't get what did you mean?");
            })
        .build();
  }
//#printer-messages
}
//#printer-messages
