package com.kodgemisi.email_templates;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * Created on February, 2019
 *
 * @author destan
 */
@Getter
@Builder
@RequiredArgsConstructor
public class EmailTemplateMetadata {

	private final String name;

	private final String path;

//	private final String template;

	private final Map<String, String> variableDefinitions;

}
