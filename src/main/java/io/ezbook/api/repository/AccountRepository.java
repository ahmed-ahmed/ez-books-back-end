package io.ezbook.api.repository;

import io.ezbook.api.entity.Account;
import io.ezbook.api.model.AccountBalance;
import io.ezbook.api.model.ChartOfAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAccountByCategoryAccountIsTrue();

    @Query("select new io.ezbook.api.model.ChartOfAccount(id, name, parentAccount.name) from Account")
    List<ChartOfAccount> getLeafAccounts();

    @Query("select new io.ezbook.api.model.ChartOfAccount(id, name, parentAccount.name) from Account where id= :id")
    ChartOfAccount getLeafAccount(long id);


    @Query("select new io.ezbook.api.model.AccountBalance(j.account.id, j.account.name, sum(j.debt), sum(j.credit), j.account.accountType) " +
            "from JournalDetail j " +
            "GROUP BY j.account.id"
    )
    List<AccountBalance> getAccountBalances();

}
