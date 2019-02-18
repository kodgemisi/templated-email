package com.kodgemisi.email_templates;

import java.util.Locale;
import java.util.Map;

/**
 * Created on January, 2019
 *
 * @author destan
 */
public interface EmailTemplateService {

	/**
	 *
	 * @param templateMetadata
	 * @param locale nullable
	 * @param variables
	 * @return
	 */
	RenderedEmailTemplate render(EmailTemplateMetadata templateMetadata, Locale locale, Map<String, Object> variables);

	/**
	 *
	 * @param templatedEmail
	 * @param locale nullable
	 * @return
	 */
	RenderedEmailTemplate render(TemplatedEmail templatedEmail, Locale locale);

	String render(String templateName, Locale locale, Map<String, Object> variables);
}
