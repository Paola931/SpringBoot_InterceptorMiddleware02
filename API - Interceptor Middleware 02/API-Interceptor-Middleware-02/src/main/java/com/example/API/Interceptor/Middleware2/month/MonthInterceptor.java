package com.example.API.Interceptor.Middleware2.month;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private List<Month> monthList() {
        return Arrays.asList(
                new Month(1, "January", "Gennaio", "Januar"),
                new Month(2, "February", "Febbraio", "Februar"),
                new Month(3, "March", "Marzo", "März"),
                new Month(4, "April", "Aprile", "April"),
                new Month(5, "May", "Maggio", "Mai"),
                new Month(6, "June", "Giugno", "Juli")
        );
    }
    private Month checkMonth(int monthNumberToCHeck) {
        for (Month month : monthList()) {
            if (month.getMonthNumber() == monthNumberToCHeck) {
                return month;
            }
        }
       return createNopeMonth(monthNumberToCHeck);
    }
    private Month createNopeMonth(int monthNumber) {
        Month nopeMonth = new Month();
        nopeMonth.setMonthNumber(monthNumber);
        nopeMonth.setEnglishName("nope");
        nopeMonth.setItalianName("nope");
        nopeMonth.setGermanName("nope");
        return nopeMonth;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");
        System.out.println(monthNumberHeader);

        if ( monthNumberHeader.isEmpty()) {
            response.sendError(400, "monthNumber must not be null");
            return false;
        }
        int monthNumber = Integer.parseInt(monthNumberHeader);
        System.out.println(monthNumber);

        request.setAttribute("monthNumber", checkMonth(monthNumber));
        response.setStatus(200);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
