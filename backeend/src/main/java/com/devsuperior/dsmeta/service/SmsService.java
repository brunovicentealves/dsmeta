package com.devsuperior.dsmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private SaleService saleService;

	public void sendSms(Long saleId) {

		Sale sale = saleService.getSaleId(saleId);

		Twilio.init(twilioSid, twilioKey);
		
		String date = sale.getDate().getMonthValue() +"/"+sale.getDate().getYear();
		
		String mesg = "O vendedor :" + sale.getSellerName() + "Foi destaque em "+date+
				"com um total de R$"+String.format("%.2f", sale.getAmount());

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from,mesg).create();

		System.out.println("id SMS:"+message.getSid());
		System.out.println("twilioSid:"+twilioSid);
		System.out.println("twilioKey:"+twilioKey);
		System.out.println("twilioPhoneFrom:"+twilioPhoneFrom);
		System.out.println("twilioPhoneTo:"+twilioPhoneTo);
	}

}
