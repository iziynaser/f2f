package com.f2f.config;

import com.f2f.dbc.domain.GlobalConstant;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import javax.servlet.http.HttpServletRequest;

/*
اطلاعات اضافه مثل کد تایید و شناسه گراف رو از درخواست http
دریافت می کته و در جریان احراز هویت نگه داری می کته
 */
public class CustomWebAuthenticationDetails extends WebAuthenticationDetails {
    private static final long serialVersionUID = 6975601077710753878L;
    private final String inputVerificationCode;
    private final String graphId;

    public CustomWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        inputVerificationCode = request.getParameter(GlobalConstant.VERIFICATION_CODE);
        graphId = request.getParameter(GlobalConstant.GRAPH_ID);
    }

    public String getInputVerificationCode() {
        return inputVerificationCode;
    }

    public String getGraphId() {
        return graphId;
    }

    @Override
    public String toString() {
        return super.toString() + "; inputVerificationCode: " + this.getInputVerificationCode() + "; graphId: " + this.getGraphId();
    }
}
