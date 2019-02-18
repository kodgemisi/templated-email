package com.kodgemisi.email_templates;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * Created on January, 2019
 *
 * @author destan
 */

@Getter
@Builder
@ToString
@RequiredArgsConstructor
public class TemplatedEmail {

	private final String from;

	private final String to;

	private final String cc;

	private final String bcc;

	private final String subject;

	private final Map<String, Object> variables;

	private final EmailTemplateMetadata emailTemplateMetadata;

	public Email toEmail(String bodyText, String bodyHtml) {
		//@formatter:off
		return Email.builder()
				.from(this.getFrom())
				.subject(this.getSubject())
				.to(this.getTo())
				.cc(this.getCc())
				.bcc(this.getBcc())
				.bodyText(bodyText)
				.bodyHtml(bodyHtml)
				.build();
		//@formatter:on
	}

}
