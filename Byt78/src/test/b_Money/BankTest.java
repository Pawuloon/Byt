package test.b_Money;

import static org.junit.Assert.*;

import b_Money.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class BankTest {
	Currency SEK, DKK;
	Bank SweBank, Nordea, DanskeBank;
	
	@Before
	public void setUp() throws Exception {
		DKK = new Currency("DKK", 0.20);
		SEK = new Currency("SEK", 0.15);
		SweBank = new Bank("SweBank", SEK);
		Nordea = new Bank("Nordea", SEK);
		DanskeBank = new Bank("DanskeBank", DKK);
		SweBank.openAccount("Ulrika");
		SweBank.openAccount("Bob");
		Nordea.openAccount("Bob");
		DanskeBank.openAccount("Gertrud");
	}

	// Test for getting a bank name
	@Test
	public void testGetName()
	{
		assertEquals("SweBank", SweBank.getName());
		assertEquals("Nordea", Nordea.getName());
		assertEquals("DanskeBank", DanskeBank.getName());
	}

	// Test for getting a bank currency
	@Test
	public void testGetCurrency()
	{
		assertEquals(SEK, SweBank.getCurrency());
		assertEquals(SEK,Nordea.getCurrency());
		assertEquals(DKK, DanskeBank.getCurrency());
	}

	// Test for opening an account
	@Test
	public void testOpenAccount() throws AccountExistsException
	{
		SweBank.openAccount("Alice");
		var aliceAcc = SweBank.getAccount("Alice");
		assertNotNull(aliceAcc);
		assertThrows(AccountExistsException.class, () -> SweBank.openAccount("Alice"));

		Nordea.openAccount("Alice");
		var aliceAcc2 = Nordea.getAccount("Alice");
		assertNotNull(aliceAcc2);
		assertThrows(AccountExistsException.class, () -> Nordea.openAccount("Alice"));

		DanskeBank.openAccount("Bob");
		var bobAcc = DanskeBank.getAccount("Bob");
		assertNotNull(bobAcc);
		assertThrows(AccountExistsException.class, () -> DanskeBank.openAccount("Bob"));
	}

	// Test for depositing money to an account
	@Test
	public void testDeposit() throws AccountDoesNotExistException, AccountExistsException
	{
		SweBank.deposit("Ulrika", new Money(1000000, SEK));
		var ulrikaAcc = SweBank.getAccount("Ulrika");
		assertEquals(1000000, ulrikaAcc.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> SweBank.deposit("Ulrika2", new Money(1000000, SEK)));

		Nordea.deposit("Bob", new Money(1000000, SEK));
		var bobAcc = Nordea.getAccount("Bob");
		assertEquals(1000000, bobAcc.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> Nordea.deposit("Bob2", new Money(1000000, SEK)));
	}

	// Test for withdrawing money from an account
	@Test
	public void testWithdraw() throws AccountDoesNotExistException
	{
		SweBank.deposit("Ulrika", new Money(1000000, SEK));
		SweBank.withdraw("Ulrika", new Money(1000000, SEK));
		var ulrikaAcc = SweBank.getAccount("Ulrika");
		assertEquals(0, ulrikaAcc.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> SweBank.withdraw("Ulrika2", new Money(1000000, SEK)));

		Nordea.deposit("Bob", new Money(1000000, SEK));
		Nordea.withdraw("Bob", new Money(1000000, SEK));
		var bobAcc = Nordea.getAccount("Bob");
		assertEquals(0, bobAcc.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> Nordea.withdraw("Bob2", new Money(1000000, SEK)));
	}

	// Test for getting an account
	@Test
	public void testGetBalance() throws AccountDoesNotExistException
	{
		SweBank.deposit("Ulrika", new Money(1000000, SEK));
		assertEquals(1000000, SweBank.getBalance("Ulrika"), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> SweBank.getBalance("Ulrika2"));

		Nordea.deposit("Bob", new Money(1000000, SEK));
		assertEquals(1000000, Nordea.getBalance("Bob"), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> Nordea.getBalance("Bob2"));
	}

	// Test for transferring money from an account to another account
	@Test
	public void testTransfer() throws AccountDoesNotExistException
	{
		SweBank.deposit("Ulrika", new Money(1000000, SEK));
		SweBank.transfer("Ulrika", Nordea, "Bob", new Money(1000000, SEK));
		var ulrikaAcc = SweBank.getAccount("Ulrika");
		assertEquals(0, ulrikaAcc.getBalance().getAmount(), 0.0);
		var bobAcc = Nordea.getAccount("Bob");
		assertEquals(1000000, bobAcc.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> SweBank.transfer("Ulrika2", Nordea, "Bob", new Money(1000000, SEK)));

		Nordea.deposit("Bob", new Money(1000000, SEK));
		Nordea.transfer("Bob", SweBank, "Ulrika", new Money(1000000, SEK));
		var ulrikaAcc2 = SweBank.getAccount("Ulrika");
		assertEquals(1000000, ulrikaAcc2.getBalance().getAmount(), 0.0);
		var bobAcc2 = Nordea.getAccount("Bob");
		assertEquals(1000000, bobAcc2.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> Nordea.transfer("Bob2", SweBank, "Ulrika", new Money(1000000, SEK)));
	}

	// Test for timed payments for accounts
	@Test
	public void testTimedPayment() throws AccountDoesNotExistException
	{
		SweBank.deposit("Ulrika", new Money(1000000, SEK));
		SweBank.addTimedPayment("Ulrika", "1", 2, 2, new Money(1000000, SEK), Nordea, "Bob");
		SweBank.tick();
		SweBank.tick();
		var ulrikaAcc = SweBank.getAccount("Ulrika");
		assertEquals(0, ulrikaAcc.getBalance().getAmount(), 0.0);
		var bobAcc = Nordea.getAccount("Bob");
		assertEquals(1000000, bobAcc.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> SweBank.addTimedPayment("Ulrika2", "1", 2, 2, new Money(1000000, SEK), Nordea, "Bob"));

		Nordea.deposit("Bob", new Money(1000000, SEK));
		Nordea.addTimedPayment("Bob", "1", 2, 2, new Money(1000000, SEK), SweBank, "Ulrika");
		Nordea.tick();
		Nordea.tick();
		var ulrikaAcc2 = SweBank.getAccount("Ulrika");
		assertEquals(1000000, ulrikaAcc2.getBalance().getAmount(), 0.0);
		var bobAcc2 = Nordea.getAccount("Bob");
		assertEquals(1000000, bobAcc2.getBalance().getAmount(), 0.0);
		assertThrows(AccountDoesNotExistException.class, () -> Nordea.addTimedPayment("Bob2", "1", 2, 2, new Money(1000000, SEK), SweBank, "Ulrika"));
	}
}
