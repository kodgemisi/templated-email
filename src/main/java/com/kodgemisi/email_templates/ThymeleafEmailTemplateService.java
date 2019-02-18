package com.kodgemisi.email_templates;

import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.io.StringWriter;
import java.util.Locale;
import java.util.Map;

/**
 * Created on February, 2019
 *
 * @author destan
 */
@Slf4j
public class ThymeleafEmailTemplateService implements EmailTemplateService {

	private final TemplateEngine thymeleafTemplateEngine;

	public ThymeleafEmailTemplateService(TemplateEngine templateEngine, ITemplateResolver templateResolver) {

		this.thymeleafTemplateEngine = templateEngine != null ? templateEngine : new TemplateEngine();
		this.thymeleafTemplateEngine.setTemplateResolver(templateResolver);
	}

	public ThymeleafEmailTemplateService() {
		final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		//TODO configure templateResolver
		templateResolver.setCacheable(false);

		this.thymeleafTemplateEngine = new TemplateEngine();
		this.thymeleafTemplateEngine.setTemplateResolver(templateResolver);
	}

	@Override
	public RenderedEmailTemplate render(TemplatedEmail templatedEmail, Locale locale) {
		return this.render(templatedEmail.getEmailTemplateMetadata(), locale, templatedEmail.getVariables());
	}

	@Override
	public RenderedEmailTemplate render(EmailTemplateMetadata templateMetadata, Locale locale, Map<String, Object> variables) {

		if(log.isDebugEnabled()) {
			log.debug("Rendering template named: {} it's path is {}", templateMetadata.getName(), templateMetadata.getPath());
		}

		final String renderedContent = this.render(templateMetadata.getPath(), locale, variables);
		return new RenderedEmailTemplate(templateMetadata, variables, renderedContent);
	}

	@Override
	public String render(String templatePath, Locale locale, Map<String, Object> variables) {

		if(log.isDebugEnabled()) {
			log.debug("Rendering {} with locale {} and variables {}", templatePath, locale, variables);
		}

		final StringWriter writer = new StringWriter();
		final Context context = new Context(locale, variables);

		thymeleafTemplateEngine.process(templatePath, context, writer);

		writer.flush();
		return writer.toString();
	}
}
