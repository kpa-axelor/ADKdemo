package com.axelor.contact.web;

import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class ContactController {
			
	
	public void printdata(ActionRequest request, ActionResponse response)
	{
		System.out.print("hellloooooooo");
		System.out.println(request.getContext().entrySet());
		response.setValue("priority", 53);
	}
	

}
