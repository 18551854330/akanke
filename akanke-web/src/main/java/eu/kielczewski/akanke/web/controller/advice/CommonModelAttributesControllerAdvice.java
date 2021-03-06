package eu.kielczewski.akanke.web.controller.advice;

import eu.kielczewski.akanke.common.service.document.DocumentService;
import eu.kielczewski.akanke.web.service.viewhelper.ViewHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.inject.Inject;

@ControllerAdvice
public class CommonModelAttributesControllerAdvice {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private ViewHelperService viewHelperService;

    @Value("${akanke.base-url:http://localhost:8080/}")
    private String baseUrl;

    @Value("${akanke.facebook.app-id:}")
    private String facebookAppId;

    @ModelAttribute("baseUrl")
    public String getBaseUrl() {
        return baseUrl;
    }

    @ModelAttribute("facebookAppId")
    public String getFacebookAppId() {
        return facebookAppId;
    }

    @ModelAttribute("documentService")
    public DocumentService getDocumentService() {
        return documentService;
    }

    @ModelAttribute("viewHelperService")
    public ViewHelperService getViewHelperService() {
        return viewHelperService;
    }

}
