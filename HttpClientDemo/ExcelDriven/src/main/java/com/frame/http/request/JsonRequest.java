package com.frame.http.request;

import com.frame.http.exception.MethodNotSupportException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;


public class JsonRequest extends BaseEntityRequest {

    private Object jsonObject;

    private static final String JSON_CONTENT_TYPE = "application/json";

    public JsonRequest(String url, RequestMethod method) throws MethodNotSupportException {
        super(url, method);
    }

    public JsonRequest(String url) throws MethodNotSupportException {
        super(url);
    }

    public Object getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(Object jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public HttpEntity getEntity() {
        StringEntity stringEntity = new StringEntity(jsonObject.toString(), getRequestCharset());//getRequestCharset is UTF-8
        stringEntity.setContentEncoding(getResponseDefaultCharset());
        stringEntity.setContentType(JSON_CONTENT_TYPE);
        return stringEntity;
    }
}
