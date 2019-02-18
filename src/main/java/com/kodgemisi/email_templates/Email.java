package com.kodgemisi.email_templates;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * Created on January, 2019
 *
 * @author destan
 */

@Getter
@Builder
@RequiredArgsConstructor
public class Email {

	private final String from;

	private final String to;

	private final String cc;

	private final String bcc;

	private final String subject;

	private final String bodyText;

	private final String bodyHtml;

	public String getMimeType() {
		return StringUtils.isNotBlank(bodyHtml) ? "text/html" : "text/plain";
	}

}
