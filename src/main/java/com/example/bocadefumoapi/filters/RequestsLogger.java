package com.example.bocadefumoapi.filters;

import com.example.bocadefumoapi.BocaDeFumoApiApplication;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.util.function.ToDoubleBiFunction;

@Component
public class RequestsLogger extends OncePerRequestFilter {

    private static final Logger Logger = LoggerFactory.getLogger(BocaDeFumoApiApplication.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper cachingRequestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper cachingResponseWrapper = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(cachingRequestWrapper, cachingResponseWrapper);

        String requestBody = getValueAsString(cachingRequestWrapper.getContentAsByteArray(), cachingRequestWrapper.getCharacterEncoding());
        String responseBody = getValueAsString(cachingResponseWrapper.getContentAsByteArray(), cachingResponseWrapper.getCharacterEncoding());
        Integer responseStatus = response.getStatus();

        logReqRes(requestBody, responseBody, cachingRequestWrapper.getRequestURI(), cachingRequestWrapper.getMethod(), responseStatus);

    }

    private String getValueAsString(byte[] contentAsByteArray, String characterEncoding){
        String dataAsString = "";
        try {
            dataAsString = new String(contentAsByteArray, characterEncoding);
        }catch (Exception e){
            logger.error("converter byte pra array deu ruim testeteeee");
            e.printStackTrace();
        }
        return  dataAsString;
    }

    @Async
    private void logReqRes(String request, String response, String uri, String httpMethod, Integer status){
        boolean err = status > 299;

        Logger.info(colorLog(String.valueOf(status), err) + " - " + httpMethod + " - " + uri);
        if (!request.isEmpty()){
            Logger.info("Request: " + request);
        }
        if (!response.isEmpty()) {
            Logger.info("Response: " + response);
        }
    }

    public String colorLog(String strIn, Boolean isErr){
        // TODO adicionar faixa de 300 a 399 (redirecionamento)
        String color = "4";
        if (isErr){
            color = "1";
        }
        return "\u001B[3"+color+"m" + strIn +"\u001B[0m";
    }
}
