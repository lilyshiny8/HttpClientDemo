package com.frame.http;

import com.frame.http.exception.MethodNotSupportException;
import com.frame.http.request.BaseEntityRequest;
import com.frame.http.request.Request;
import com.frame.http.response.Response;
import datalib.DataStore;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;


public class HttpClientUtil {

    private static PoolingHttpClientConnectionManager connMgr;
    private static SSLConnectionSocketFactory sslConnectionSocketFactory = null;
    private static SSLContextBuilder sslContextBuilder = null;//管理Https连接的上下文类
    private static RequestConfig requestConfig;
    private static final int MAX_CONNECT_TIMEOUT = 10000;
    private static final int MAX_SOCKET_TIMEOUT = 10000;
    private static final int MAX_CONNECT_REQUEST_TIMEOUT = 10000;
    private static final int MAX_TOTAL = 100;
    private static CloseableHttpClient httpclient;
    /**
     * Do http request
     * @param request request object
     * @return response object
     */
    public static Response doRequest(Request request, HttpClientContext context) {
        try {
            //baseRequest-------GET http://localhost:8888/getCookie HTTP/1.1
            HttpRequestBase baseRequest = request.getHttpRequest();

            Header[] headers = request.getAllHeaders();
            if (null != headers && headers.length > 0) {
                baseRequest.setHeaders(headers);
            }
            baseRequest.setConfig(requestConfig);
            if (request instanceof BaseEntityRequest) { //to post entity
                ((HttpEntityEnclosingRequestBase) baseRequest).setEntity(((BaseEntityRequest) request).getEntity());
            }
            //toXHttpResponse里面有execute语句
            return toXHttpResponse(baseRequest, request.getResponseDefaultCharset(),context);
        } catch (IOException e) {
            e.printStackTrace();
            return getErrorXResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (MethodNotSupportException mnse) {
            return getErrorXResponse(HttpServletResponse.SC_METHOD_NOT_ALLOWED, mnse.getMessage());
        }
    }

    public static Response dodownloadRequest(Request request, HttpClientContext context, String filename) {
        try {
            HttpRequestBase baseRequest = request.getHttpRequest();

            Header[] headers = request.getAllHeaders();
            if (null != headers && headers.length > 0) {
                baseRequest.setHeaders(headers);
            }
            baseRequest.setConfig(requestConfig);
            if (request instanceof BaseEntityRequest) { //to post entity
                ((HttpEntityEnclosingRequestBase) baseRequest).setEntity(((BaseEntityRequest) request).getEntity());
            }
            return toXHttpResponse(baseRequest, request.getResponseDefaultCharset(),context,filename);
        } catch (IOException e) {
            e.printStackTrace();
            return getErrorXResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (MethodNotSupportException mnse) {
            return getErrorXResponse(HttpServletResponse.SC_METHOD_NOT_ALLOWED, mnse.getMessage());
        }
    }

    private static Response getErrorXResponse(int code, String errorMsg) {
        return new Response(code, errorMsg, null, null, null);
    }

    private static Response toXHttpResponse(HttpUriRequest request, String defaultCharset
            , HttpClientContext context) throws IOException {
        try  {
            //开始时间
            DataStore.starttime=System.currentTimeMillis();
            CloseableHttpResponse response = httpclient.execute(request,context);
            DataStore.endtime=System.currentTimeMillis();
            Response result = new Response(response.getStatusLine().getStatusCode(), response.getAllHeaders());
            result.setstatusline(response.getStatusLine().toString());
            result.setreasonPhrase(response.getStatusLine().getReasonPhrase().toString());
            HttpEntity entity = response.getEntity();
            if (entity != null) {

                //content encoding
                String charset = (null == entity.getContentEncoding()) ? defaultCharset : entity.getContentEncoding().getValue();
                result.setContentEncoding(charset);

                //content type
                String contentType = (null == entity.getContentType()) ? "" : entity.getContentType().getValue();
                result.setContentType(contentType);

                try {
                    result.setResponseText(EntityUtils.toString(entity, defaultCharset));
                } finally {
                    try {
                        EntityUtils.consume(response.getEntity());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private static Response toXHttpResponse(HttpUriRequest request, String defaultCharset
            , HttpClientContext context, String filename) throws IOException {
        try  {
            DataStore.starttime=System.currentTimeMillis();
            HttpResponse response = httpclient.execute(request,context);
            DataStore.endtime=System.currentTimeMillis();
            Response result = new Response(response.getStatusLine().getStatusCode(), response.getAllHeaders());
            HttpEntity entity = response.getEntity();
            if (entity != null) {

                //content encoding
                String charset = (null == entity.getContentEncoding()) ? defaultCharset : entity.getContentEncoding().getValue();
                result.setContentEncoding(charset);

                //content type
                String contentType = (null == entity.getContentType()) ? "" : entity.getContentType().getValue();
                result.setContentType(contentType);

                try {
                    InputStream is = entity.getContent();
                    File file = new File(filename);
                    file.getParentFile().mkdirs();
                    FileOutputStream fos = new FileOutputStream(file);
                    byte[] buffer = new byte[10000];
                    int len = -1;
                    while((len = is.read(buffer) )!= -1){
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                    is.close();
//                    result.setResponseText(EntityUtils.toString(entity));
                } finally {
                    try {
                        EntityUtils.consume(response.getEntity());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return result;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void setHttpClient( CookieStore cookieStore) {
        try {
            sslContextBuilder = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//                      信任所有站点 直接返回true
                    return true;
                }
            });
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContextBuilder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.INSTANCE)
                    .register("https", sslConnectionSocketFactory)
                    .build();
//    	   Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
//    	           .register("http", PlainConnectionSocketFactory.INSTANCE)
//    	           .register("https", createSSLConnSocketFactory())
//    	           .build();
            connMgr= new PoolingHttpClientConnectionManager(socketFactoryRegistry);
            connMgr.setMaxTotal(MAX_TOTAL);
            connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
            RequestConfig.Builder configBuilder = RequestConfig.custom();

            // timeout unit : milliseconds
            configBuilder.setConnectTimeout(MAX_CONNECT_TIMEOUT);
            configBuilder.setSocketTimeout(MAX_SOCKET_TIMEOUT);
            configBuilder.setConnectionRequestTimeout(MAX_CONNECT_REQUEST_TIMEOUT);
            configBuilder.setCookieSpec(CookieSpecs.STANDARD);

            // check availability
            //configBuilder.setStaleConnectionCheckEnabled(true);
            requestConfig = configBuilder.build();

//配置信息
            httpclient=HttpClients.custom()
                    .setDefaultCookieStore(cookieStore)
                    .setSSLSocketFactory(sslConnectionSocketFactory)
                    .setConnectionManager(connMgr)
                    .setDefaultRequestConfig(requestConfig)
                    .setConnectionManagerShared(true)
                    .build();
//    	httpclient=HttpClients.custom()
//        		.setDefaultCookieStore(cookieStore)
//                .setSSLSocketFactory(createSSLConnSocketFactory())
//                .setConnectionManager(connMgr)
//                .setDefaultRequestConfig(requestConfig)
//                .setConnectionManagerShared(true)
//                .build();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

    }

    //create SSLConnectionSocketFactory to trust all
    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        try {
            SSLContext sslcontext = SSLContexts.custom()
                    .loadTrustMaterial(null, (TrustStrategy) (chain, authType) -> true)
                    .build();
            return new SSLConnectionSocketFactory(sslcontext,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 创建SSL安全连接
     *
     * @return
     */





    /**
     * 构造get请求的参数
     *
     * @return
     */
    public static String buildUrl(Map<String, String> map) {
        if (MapUtils.isEmpty(map)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer("?");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            stringBuffer.append(stringStringEntry.getKey()).append("=").append(stringStringEntry.getValue()).append("&");
        }
        String result = stringBuffer.toString();
        if (StringUtils.isNotEmpty(result)) {
            result = result.substring(0, result.length() - 1);//去掉结尾的&连接符

        }

        return result;

    }



}
