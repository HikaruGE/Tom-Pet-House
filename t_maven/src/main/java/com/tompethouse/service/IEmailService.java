package com.tompethouse.service;

import java.util.ArrayList;
import java.util.Date;

public interface IEmailService {
    ArrayList<String> shortlistEmails(Date dateToCheck);
	void sendEmail(ArrayList<String> emails);
}
