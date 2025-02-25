package lb.project.banking.service.impl;

import lb.project.banking.dto.AccountDto;
import lb.project.banking.entity.Account;
import lb.project.banking.mapper.AccountMapper;
import lb.project.banking.repository.AccountRepository;
import lb.project.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account =  accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =  accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account =  accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account does not exists"));

        if(account.getBalance() < amount) {
            throw new RuntimeException("insufficient amount");
        }

        double total = account.getBalance() - amount ;
        account.setBalance(total);
        Account savecAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savecAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account =  accountRepository
                .findById(id)
                .orElseThrow( () -> new RuntimeException("Account does not exists"));

        accountRepository.deleteById(id);
    }
}
