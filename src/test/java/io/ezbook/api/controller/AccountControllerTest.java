package io.ezbook.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import io.ezbook.api.entity.Account;
import io.ezbook.api.entity.AccountType;
import io.ezbook.api.model.AccountPost;
import io.ezbook.api.model.ChartOfAccount;
import io.ezbook.api.service.AccountService;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

	@Mock
    private AccountService accountService;

	@InjectMocks
	private AccountController accountController;

	private static Optional<Account> optionalAccount;

	private static List<ChartOfAccount> chartOfAccountList;

	private static Account account;

	@BeforeClass
	public static void init() {
		chartOfAccountList = new ArrayList<>();
		ChartOfAccount parentAccount = new ChartOfAccount(1L, "parentAccount1", null);
		ChartOfAccount childAccount = new ChartOfAccount(2L, "childAccount1", "parentAccount1");
		chartOfAccountList.add(parentAccount);
		chartOfAccountList.add(childAccount);

		account = new Account();
		account.setAccountType(AccountType.Assets);
		optionalAccount = Optional.of(account);
	}

	@Before
	public void setUp() throws Exception {
		when(accountService.findLeafAccounts()).thenReturn(chartOfAccountList);
		when(accountService.findById(Mockito.anyLong())).thenReturn(optionalAccount);
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testFindAll() throws Exception {
		List<ChartOfAccount> result = accountController.findAll();
		verify(accountService, times(1)).findLeafAccounts();
		assertEquals(2, result.size());
		assertEquals("parentAccount1", result.get(0).getName());
		assertNull(result.get(0).getParentName());
	}

	@Test
	public void testAddAccount() throws Exception {
		AccountPost testAccount = new AccountPost();
		testAccount.setParentId(100L);
		Account result = accountController.addAccount(testAccount);

		ArgumentCaptor<Account> acInteger = ArgumentCaptor.forClass(Account.class);
		verify(accountService).addAccount(acInteger.capture());
		assertNotNull(result);
		assertEquals(AccountType.Assets, result.getAccountType());
	}
}

