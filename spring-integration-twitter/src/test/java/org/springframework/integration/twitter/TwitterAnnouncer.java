package org.springframework.integration.twitter;

import org.springframework.integration.twitter.core.DirectMessage;
import org.springframework.integration.twitter.core.Status;
import org.springframework.stereotype.Component;


@Component
public class TwitterAnnouncer {
	public void dm(DirectMessage directMessage) {
		System.out.println("A direct message has been received from " +
				directMessage.getSender().getScreenName() + " with text " + directMessage.getText());
	}

	public void mention(Status s) {
		System.out.println("A tweet mentioning (or replying) to " + "you was received having text " + s.getText() + " from " + s.getSource());
	}

	public void updates(Status t) {
		System.out.println("Received timeline update: " + t.getText() + " from " + t.getSource());
	}
}
