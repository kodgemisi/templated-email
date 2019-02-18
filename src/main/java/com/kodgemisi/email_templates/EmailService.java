package com.kodgemisi.email_templates;

/**
 * Created on January, 2019
 *
 * @author destan
 */
public interface EmailService {

	void send(Email email);

	void send(TemplatedEmail templatedEmail);

}
