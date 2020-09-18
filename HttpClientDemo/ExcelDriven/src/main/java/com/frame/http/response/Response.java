package com.frame.http.response;

import org.apache.http.Header;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;


public class Response {

    private int code;
    private String statusline;
    private String reasonPhrase;
    private String responseText;
    private String contentType;
    private String contentEncoding;

    private Header[] headers;

    public Response(int code) {
        this(code, null, null, null, null);
    }

    public Response(int code, Header[] headers) {
        this(code, null, null, null, headers);
    }


    public Response(int code, String responseText, String contentType
            , String contentEncoding, Header[] headers) {
        this.code = code;
        this.responseText = getNotNullString(responseText);
        this.contentType = getNotNullString(contentType);
        this.contentEncoding = getNotNullString(contentEncoding);
        addHeaders(headers);
    }

    private void addHeaders(Header[] headers) {
     this.headers=headers;
    }

    private String getNotNullString(String str) {
        return null == str ? "" : str;
    }

    private Header[] getNotNullHeaders(Header[] headers) {
        return null == headers ? new Header[0] : headers;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public void setstatusline(String statusline) {
        this.statusline = statusline;
    }
    public String getstatusline() {
        return statusline;
    }
    
    public void setreasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }
    public String getreasonPhrase() {
        return reasonPhrase;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = getNotNullString(responseText);
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = getNotNullString(contentType);
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = getNotNullString(contentEncoding);
    }

    public String getHeader(String key) {
    	for (int i = 0; i < headers.length; i++) {
			if (headers[i].getName().equals(key))
				return headers[i].getValue();
		}
		return null;
    }
    
    public Header[] getHeaders(String key) {
    	Header[] header = null;
    	ArrayList<Header> result=new ArrayList<Header>();
    	for (int i = 0; i < headers.length; i++) {
			if (headers[i].getName().equals(key))
				result.add(headers[i]);
		}
		return result.toArray(header);
    }

    public Header[] getAllHeaders() {
        return headers;
    }
    public String getAllHeaderstoString() {
        String strignheaders="";
        for(int i=0;i<headers.length;i++){
        	strignheaders+=headers[i].toString()+"\r\n";
        }
        return strignheaders;
    }
    public String getAll() {
        return getstatusline()+"\r\n"+getAllHeaderstoString()+"\r\n"+getResponseText();
    }
	public InputStream getResponseBodyAsStream() throws Exception {
		// TODO Auto-generated method stub
			return  new FileInputStream(responseText);
	}
}
