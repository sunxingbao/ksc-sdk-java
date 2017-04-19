package com.ksc.live.model.transform;

import com.ksc.DefaultRequest;
import com.ksc.KscClientException;
import com.ksc.Request;
import com.ksc.http.HttpMethodName;
import com.ksc.live.model.GetListRequest;
import com.ksc.transform.Marshaller;
import com.ksc.util.StringUtils;

public class GetListRequestMarshaller implements
Marshaller<Request<GetListRequest>, GetListRequest> {

	public Request<GetListRequest> marshall(GetListRequest liveRequest) {
		if (liveRequest == null) {
            throw new KscClientException(
                    "Invalid argument passed to marshall(...)");
        }
		Request<GetListRequest> request = new DefaultRequest<GetListRequest>(
                liveRequest, "live");
		
        request.addParameter("Action", "listPubStreamsInfo");
        String version=liveRequest.getVersion();
        if(org.apache.commons.lang.StringUtils.isBlank(version)){
        	version="2016-10-26";
        }
        request.addParameter("Version", version);

        
        request.addParameter("uniquename", liveRequest.getUniquename());


        if(liveRequest.getMarker()!= 0){
        	request.addParameter("marker", StringUtils.fromInteger(liveRequest.getMarker()));
        }
        if(liveRequest.getLimit()!= 0){
            request.addParameter("limit", StringUtils.fromInteger(liveRequest.getLimit()));
        }

        if (liveRequest.getApp() != null && liveRequest.getPubhost() == null) {
            request.addParameter("app",liveRequest.getApp());
        }
        if (liveRequest.getPubhost() != null && liveRequest.getApp() == null) {
            request.addParameter("pubhost",liveRequest.getPubhost());
        }

        request.setHttpMethod(HttpMethodName.GET);
      
		return request;
	}

}
