/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.adapter.file.config;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.integration.adapter.file.FileSource;
import org.w3c.dom.Element;

/**
 * Parser for the &lt;file-source/&gt; element.
 * 
 * @author Mark Fisher
 * @author Marius Bogoevici
 */
public class FileSourceParser extends AbstractDirectorySourceParser {

	public static final String DIRECTORY_ATTRIBUTE = "directory";

	public FileSourceParser() {
		super(false);
	}

	@Override
	protected Class<?> getBeanClass(Element element) {
		return FileSource.class;
	}

	@Override
	protected boolean isEligibleAttribute(String attributeName) {
		return !(DIRECTORY_ATTRIBUTE.equals(attributeName)) && super.isEligibleAttribute(attributeName);
	}

	@Override
	protected void postProcess(BeanDefinitionBuilder beanDefinition, Element element) {
		beanDefinition.addConstructorArgValue(element.getAttribute(DIRECTORY_ATTRIBUTE));		
		super.postProcess(beanDefinition, element);
	}

}
