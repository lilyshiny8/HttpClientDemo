package com.frame.http.request;

import com.frame.http.exception.MethodNotSupportException;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.util.CharsetUtils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;


public class MultiPartFormRequest extends BaseEntityRequest {

	MultipartEntityBuilder builder;
	
    public MultiPartFormRequest(String url, RequestMethod method) throws MethodNotSupportException, UnsupportedEncodingException {
        super(url, method);
        Charset charset = CharsetUtils.get(this.getRequestCharset());
        builder = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .setCharset(charset);
    }

    public MultiPartFormRequest(String url) throws MethodNotSupportException, UnsupportedEncodingException {
        super(url);
        Charset charset = CharsetUtils.get(this.getRequestCharset());
        builder = MultipartEntityBuilder.create()
                .setMode(HttpMultipartMode.BROWSER_COMPATIBLE)
                .setCharset(charset);
    }

    @Override
    public HttpEntity getEntity()  {
    	HttpEntity entity=builder.build();
        return entity;
    }

    public void addPart(String name, Object body,String contentype) {
    	if (null != body && body instanceof File){
    		 FileBody fileBody = new FileBody((File) body, ContentType.create(contentype));
    		 builder.addPart(name, fileBody);
    	}
    	else{
    		try {
				StringBody stringBody = new StringBody(null == body ? "" : body.toString()
				        , ContentType.create(contentype, CharsetUtils.get(getRequestCharset())));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				System.out.println("contenttype不支持"+getRequestCharset());
				e.printStackTrace();
			}
    	}
    }
}
