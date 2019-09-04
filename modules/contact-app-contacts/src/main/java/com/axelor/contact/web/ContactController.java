package com.axelor.contact.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.mapping.Set;

import com.axelor.app.AppSettings;
import com.axelor.contact.db.Contact;
import com.axelor.contact.db.Price;
import com.axelor.inject.Beans;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;

public class ContactController {

	public void printdata(ActionRequest request, ActionResponse response) {
		Price price = request.getContext().asType(Price.class);
		System.out.println(price.getPrice());
		System.out.println(price.getQuantity());

//		System.out.println(request.getContext().entrySet());
//		Map map = new HashMap();
//		Set set = (Set) request.getContext().entrySet();
//		 Iterator itr = ((java.util.Set<Entry<String, Object>>) set).iterator(); 
//		 while(itr.hasNext())
//		 {
//			 Map.Entry entry = (Map.Entry)itr.next();
//			 System.out.println(entry.getKey()+" "+entry.getValue());
//		 }

		response.setValue("totalAmount", (price.getPrice() * price.getQuantity()));
	}

	public void reportvalue(ActionRequest request, ActionResponse response) {

		System.out.println(request.getContext().entrySet());
		System.out.println("final=>" + request.getContext().get("_ids"));
		List<Integer> ids = (List<Integer>) request.getContext().get("_ids");
		System.out.println(ids);

		
		if (ids == null) {
			System.out.println("form value" + request.getContext().entrySet());
			System.out.println(request.getContext().get("id"));
			Long i = (Long) request.getContext().get("id");
			String s3 = i.toString(i);
			request.getContext().put("contactId", s3);
			System.out.println(request.getContext().get("contactId"));
		}
		else if (!ids.isEmpty()) {

			System.out.println(ids);
			String s1 = "";
			for (int i = 0; i < ids.size(); i++) {
				s1 = s1 + ids.get(i) + ",";
			}
			String s = (String) s1.subSequence(0, s1.length() - 1);
			System.out.println("string=" + s);
			System.err.println("req class == >" + request.getContext().put("contactId", s));
			System.out.println(request.getContext().get("contactId"));

		}

		String filePath = AppSettings.get().get("file.upload.dir");
		System.out.println("filePath=" + filePath);
		System.out.println("file put=" + request.getContext().put("photoPath", filePath));
		System.out.println(request.getContext().get("photoPath"));
//		Object[] ol = ids.toArray();
//		System.out.println("ArrayObj length =" + ol.length);

	}

//	public void formValue(ActionRequest request, ActionResponse response) {
//		System.out.println("form value" + request.getContext().entrySet());
//		System.out.println(request.getContext().get("id"));
//		Long i = (Long) request.getContext().get("id");
//		String s = i.toString(i);
//		request.getContext().put("contactId", s);
//		String filePath = AppSettings.get().get("file.upload.dir");
//		System.out.println("filePath=" + filePath);
//		System.out.println("file put=" + request.getContext().put("photoPath", filePath));
//		System.out.println(request.getContext().get("photoPath"));
//
//	}

}
