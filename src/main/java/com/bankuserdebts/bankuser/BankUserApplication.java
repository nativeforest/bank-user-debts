package com.bankuserdebts.bankuser;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.bankuserdebts.bankuser.aop.TargetObject;
import com.bankuserdebts.bankuser.autowiredList.AreaCalculatorService;
import com.bankuserdebts.bankuser.models.Bank;
import com.bankuserdebts.bankuser.models.Debt;
import com.bankuserdebts.bankuser.models.User;
import com.bankuserdebts.bankuser.profiles.EnviromentService;
import com.bankuserdebts.bankuser.repositories.BankRepository;
import com.bankuserdebts.bankuser.repositories.UserRepository;
import com.bankuserdebts.bankuser.scopes.ScopeTest;
import com.bankuserdebts.bankuser.services.BankService;
import com.bankuserdebts.bankuser.services.DebtService;

@SpringBootApplication // == @Configuration + @EnableAutoConfiguration + @ComponentScan
public class BankUserApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private BankRepository bankRepository;
	@Autowired
	private BankService bankService;
	@Autowired
	private DebtService debtService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(":::::::RUNNING CommandLineRunner:::::::");
		User user = new User();
		user.setName("and");
		user.setEmail("and@gmail.com");
		user.setPassword("NOT CIPHERED PASS");
		User user2 = new User();
		user2.setName("Juanita");
		user2.setEmail("juanita@gmail.com");
		user2.setPassword("****");
		User user3 = new User();
		user3.setName("Carlitos");
		user3.setEmail("carlitos@gmail.com");
		user3.setPassword("**_**");

		Bank bank = new Bank();
		bank.setName("Bancolombia");
		Bank bank2 = new Bank();
		bank2.setName("ScotiaBank");
		User stateUser=userRepository.save(user);
		userRepository.save(user2);
		userRepository.save(user3);
		bankRepository.save(bank);
		Bank stateBank = bankRepository.save(bank2);
		Thread.sleep(50);
		// bankService.registerBankToUser(stateBank.getId(), stateUser.getId());
		bankService.registerBankToUser(1L, 1L);
		bankService.registerBankToUser(1L, 2L);
		bankService.registerBankToUser(1L, 3L);
		bankService.registerBankToUser(2L, 3L);

		Debt debt = new Debt();
		debt.setAmount(5000);
		debt.setBank(bank);
		debt.setUser(user);
		debtService.addDebt(debt);
		
		Debt debt2 = new Debt();
		debt2.setAmount(1100);
		debt2.setBank(bank);
		debt2.setUser(user2);
		debtService.addDebt(debt2);

		Debt debt3 = new Debt();
		debt3.setAmount(600);
		debt3.setBank(bank);
		debt3.setUser(user3);
		debtService.addDebt(debt3);

		Debt debt4 = new Debt();
		debt4.setAmount(888);
		debt4.setBank(bank2);
		debt4.setUser(user3);
		debtService.addDebt(debt4);
		
		System.out.println(":::::::DATA CREATED:::::::");
	}
	@Bean
	public String getApplicationName() {
		return "BankUserApplication";
	}
	public static void main(String[] args) {
		// SpringApplication.run(BankUserApplication.class, args);
		// logger.info("Hello {}",BankUserApplication.class);
		ConfigurableApplicationContext context = SpringApplication.run(BankUserApplication.class, args);
		EnviromentService env = context.getBean(EnviromentService.class);
		System.out.println("active env:"+env.getEnviroment());
		
		ScopeTest scopeexample = context.getBean(ScopeTest.class);
		ScopeTest scopeexample2 = context.getBean(ScopeTest.class);
		logger.info("scopeexample: {}",scopeexample==scopeexample2);
		
		String applicationName = context.getBean("getApplicationName", String.class);
		logger.info("scopeexample: {}",applicationName);

		AreaCalculatorService areaCalculatorService = context.getBean(AreaCalculatorService.class);
		logger.info("areaCalculatorService.calc area: {}",areaCalculatorService.getCalculateArea());

		ExpressionParser eParser = new SpelExpressionParser()	;
		Expression conc = eParser.parseExpression("'Hello World'.concat('!')");
		Expression comp = eParser.parseExpression("8<6");
		logger.info("comp: {}",comp.getValue());
		logger.info("conc: {}",conc.getValue());

		TargetObject targetObject = context.getBean(TargetObject.class);
		targetObject.method1();

	}

	private static final Logger logger = LogManager.getLogger("HelloWorld");

}
