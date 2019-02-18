package com.kodgemisi.email_templates;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * Created on February, 2019
 *
 * @author destan
 */
@Getter
@RequiredArgsConstructor
public class RenderedEmailTemplate {

	private final EmailTemplateMetadata metadata;

	private final Map<String, Object> variables;

	/**
	 * Rendered content
	 */
	private final String content;

}
