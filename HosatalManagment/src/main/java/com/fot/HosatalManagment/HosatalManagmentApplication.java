package com.fot.HosatalManagment;

import com.fot.HosatalManagment.service.EmailSenderService;
import com.fot.HosatalManagment.utill.EmailFormat;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.List;
import java.util.Map;


@SpringBootApplication
@EnableScheduling
public class HosatalManagmentApplication {

	@Autowired
	private EmailSenderService senderService;

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public HosatalManagmentApplication(EmailSenderService senderService, JdbcTemplate jdbcTemplate) {
		this.senderService = senderService;
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(HosatalManagmentApplication.class, args);

	}



	@Scheduled(cron = "0 30 4 * * ?")
	public void sendEmailTestAt430AM() throws MessagingException {
		System.out.println("Email sent at 4:30 AM.");
	}


//	@Scheduled(cron = "0 0 0 1/3 * ?")
//	public void sendEmailAtMidnight() {
//
//		List<Map<String, Object>> data = jdbcTemplate.queryForList("SELECT * FROM OpenComplaintsWithinLast3Days");
//		EmailFormat emailFormat=new EmailFormat();
//		senderService.sendHtmlEmail("dilshankavinda371@gmail.com",
//				"Daily Data Report",
//				emailFormat.formatDataForEmail(data));
//
//		System.out.println("Email sent with Weekly Report.");
//	}


//	@Scheduled(cron = "0 0 0 1/7 * ?")
//	public void sendEmailAtMidnight() {
//
//		List<Map<String, Object>> data = jdbcTemplate.queryForList("SELECT * FROM deanreport");
//		EmailFormat emailFormat=new EmailFormat();
//		senderService.sendHtmlEmail("dilshankavinda371@gmail.com",
//				"Daily Data Report",
//				emailFormat.formatDataForTheEmail(data));
//
//		System.out.println("Email is send!!");
//	}




}
