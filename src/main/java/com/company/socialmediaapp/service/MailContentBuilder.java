package com.company.socialmediaapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 *
 * @author mehul jain
 */
@Service
@AllArgsConstructor
public class MailContentBuilder {
    
    private final TemplateEngine templateEngine;
    
    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("mailTemplate", context);
    }
}
